package sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import beans.*;
import beans.srv.ServicioDAO;
import vistasbeans.*;

public class Sistema {
	private static Sistema sistema;
	private ServicioDAO srvDAO = new ServicioDAO();	
	
	private List<Cliente> clientes;
	private List<Cotizacion> cotizaciones;
	private List<Factura> facturas;
	private List<ODV> odv;
	private List<OrdenCompra> ordenesCompra;
	private List<OrdenPedido> ordenesPedido;
	private List<Proveedor> proveedores;
	private List<RemitoCliente> remitosCliente;
	private List<RemitoProveedor> remitosProveedor;
	private List<RemitoTransporte> remitosTransporte;
	private List<Rodamiento> rodamientos;
	private List<SolicitudCotizacion> solicitudesCotizacion;
	private List<ItemStock> stock;
	private List<Ganancia> ganancia; 
	
	private Sistema(){
		clientes=new ArrayList<Cliente>();
		cotizaciones=new ArrayList<Cotizacion>();
		facturas=new ArrayList<Factura>();
		odv=new ArrayList<ODV>();
		ordenesCompra=new ArrayList<OrdenCompra>();
		ordenesPedido=new ArrayList<OrdenPedido>();
		proveedores=new ArrayList<Proveedor>();
		remitosCliente=new ArrayList<RemitoCliente>();
		remitosProveedor=new ArrayList<RemitoProveedor>();
		remitosTransporte=new ArrayList<RemitoTransporte>();
		rodamientos=new ArrayList<Rodamiento>();
		solicitudesCotizacion=new ArrayList<SolicitudCotizacion>();
		stock=new ArrayList<ItemStock>();
		ganancia=new ArrayList<Ganancia>();		
	}
	
	public static Sistema getSistema(){
		if(sistema==null)
			sistema=new Sistema();		
		return sistema;		
	}
	
	
	public boolean clienteExiste(String cuil){
		boolean existe= false;
		for(Cliente c: clientes){
			if(c.getCUIT()==cuil)
				existe=true;
		}
		return existe;
	}
	
	
	//CU 1 Recepción de solicitudes de cotización de rodamientos
	public void nuevaSolicitudCotizacion(SolicitudCotizacionVista vista){ 
		SolicitudCotizacion solicitud = new SolicitudCotizacion();
		solicitud.setCliente(buscarCliente(vista.getCliente().getCUIT())); 
		solicitud.setFechaEmision(vista.getFechaEmision());
		solicitud.setItems(generarItems(vista.getItems()));
		solicitud.setNro(vista.getNro());
		solicitud.setEstado(vista.getEstado());
		solicitudesCotizacion.add(solicitud);
		
	}
	
	public Cliente buscarCliente(String cuit){
		Cliente c=null;
		for(Cliente aux : clientes){
			if(aux.getCUIT()==cuit)
				c=aux;
				break;
		}
		return c;
	}
	
	public Vector<SolicitudCotizacionItem> generarItems(List<SolicitudCotizacionItemVista> itemsVista){
		Vector<SolicitudCotizacionItem> items=new Vector<SolicitudCotizacionItem>();
		for(SolicitudCotizacionItemVista vista: itemsVista){
			SolicitudCotizacionItem item=new SolicitudCotizacionItem();
			item.setCantidad(vista.getCantidad());
			item.setRodamiento(buscarRodamiento(vista.getRodamiento().getCodigo()));
			items.add(item);
		}		
		return items;		
	}
		
	public Rodamiento buscarRodamiento(String codigo){
		Rodamiento r=null;
		for(Rodamiento aux : rodamientos){
			if(aux.getCodigo()==codigo){
				r=aux;
				break;
			}
		}
		return r;		
	}
	
	//CU 2 Solicitud de cotización  - - falta especificacion
	public Vector<SolicitudCotizacionVista> solicitudesCotizacion(){
		Vector<SolicitudCotizacionVista> solicitudes=new Vector<SolicitudCotizacionVista>();
		for(SolicitudCotizacion c: solicitudesCotizacion)
			solicitudes.add(c.getVista());
		return solicitudes;		
	}
	
	
	//CU 3 Recepción de orden de pedido - - Falta especificacion
	//no dice donde se agregan los nuevos items si es que se solicitan
	public Vector<ItemCotizacionVista> itemsCotizacionesSolicitadasDeUnCliente(String cuil){
		Vector<ItemCotizacionVista> resultado = new Vector<ItemCotizacionVista>();
		Cliente c= buscarCliente(cuil);
		for(SolicitudCotizacion s : solicitudesCotizacion){
			if(c==s.getCliente()){
				for(SolicitudCotizacionItem item: s.getItems()){
					//resultado.add(item.getVista());					
				}				
			}			
		}
		return resultado;
	}
	
	/* :: CU04 - Envío de rodamientos (Remito) :: */
	public void nuevoRemito_a_Cliente(RemitoClienteVista vista){ 
		RemitoCliente remitoCl = new RemitoCliente();
		remitoCl.setCliente(buscarCliente(vista.getCliente().getCUIT())); 
		remitoCl.setFecha(vista.getFecha());
		remitoCl.setItems(generarItemsRemito(vista.getItems()));
		remitoCl.setNro(vista.getNro());
		remitoCl.setEstadoEnvio(vista.getEstadoEnvio());
		remitosCliente.add(remitoCl);
		srvDAO.addRemitoCliente(remitoCl);
		
		//TODO	public void chgItemPedidoSt();
		//TODO public void chgPorcCompletitudOP();
	}
	
	
	
	public RemitoCliente RemitoCliente_Modificacion_Inicio(int NroRemitoCliente){
		return this.getUniqueRemitoC(NroRemitoCliente);		
	}

	public boolean RemitoCliente_Modificacion_Confirmacion(int nroRemito, Date fecha, List<RemitoItem> items, String estado, Cliente cl,  List<OrdenPedido> op){
		 boolean retVal = false;
		 RemitoCliente rc = generarRemitoCliente(nroRemito,fecha,items,estado,cl, op);
		 retVal = srvDAO.updateRemitoCliente(rc);
		 if(retVal){
			 actualizarRemitoClienteEnColeccion(rc);
		}
		 return retVal;
	}
	
	
	private RemitoCliente generarRemitoCliente(int nroRemito, Date fecha, List<RemitoItem> items, String estado, Cliente cl,  List<OrdenPedido> op ){
		RemitoCliente rc = new RemitoCliente();
		rc.setNro(nroRemito);
		rc.setFecha(fecha);
		rc.setItems(items);
		rc.setEstadoEnvio(estado);
		rc.setCliente(cl);
		rc.setOrdenPedido(op);
		return rc;
	}
	
	

	private void actualizarRemitoClienteEnColeccion(RemitoCliente rc){
		for(RemitoCliente rcActual: remitosCliente){
			if(rcActual.sosRemitoCliente(rc.getNro())){
				 rcActual.setEstado(rc.getEstado());
			}
		}
	}
	
	
public boolean chgRemitoClienteSt(int nroRemito){
		boolean retVal = false;
		this.actualizarRemitoClienteSt(nroRemito, "Facturado");
		retVal = srvDAO.updateRemitoClienteSt(nroRemito, "Facturado");
		return retVal;
	}	
	
private void actualizarRemitoClienteSt(int nroRemito, String estado) {
		RemitoCliente rc = this.getUniqueRemitoC(nroRemito);
		rc.setEstado(estado);
		rc.setEstadoEnvio(estado);
		this.actualizarRemitoClienteEnColeccion(rc);
		
	}


// TODO	public void chgRemitoProveedorSt();
	
// TODO	public void chgRemitoTransporteSt();
	
			
	public List <RemitoCliente> obtenerRemitoCl(){
		remitosCliente = srvDAO.getRemitoCl();
		return remitosCliente;
	}
	
	public List <RemitoProveedor> obtenerRemitoPrv(){
		remitosProveedor = srvDAO.getRemitoPrv();
		return remitosProveedor;
	}
	
	public List <RemitoTransporte> obtenerRemitoTpte(){
		remitosTransporte = srvDAO.getRemitoTpte();
		return remitosTransporte;
	}
	
		
	public Remito getUniqueRemito(int NroRemito){
		Remito r= null;
		if(remitoExiste(NroRemito)){
		r= srvDAO.getUniqueRemito(NroRemito);
		}
		return r;
		}
	
	public RemitoCliente getUniqueRemitoC(int NroRemito){
		RemitoCliente r= null;
		if(remitoExiste(NroRemito)){
		r= srvDAO.getUniqueRemitoC(NroRemito);
		}
		return r;
		}
	
	public RemitoTransporte getUniqueRemitoT(int NroRemito){
		RemitoTransporte r= null;
		if(remitoExiste(NroRemito)){
		r= srvDAO.getUniqueRemitoT(NroRemito);
		}
		return r;
		}
	
	public RemitoProveedor getUniqueRemitoP(int NroRemito){
		RemitoProveedor r= null;
		if(remitoExiste(NroRemito)){
		r= srvDAO.getUniqueRemitoP(NroRemito);
		}
		return r;
		}

	private boolean remitoExiste(int NroRemito){
		boolean existe= false;
		for(Remito rc: remitosCliente){
		if(rc.getNro()== NroRemito)
		existe=true;
		}
		for(Remito rp: remitosProveedor){
			if (rp.getNro()== NroRemito)
				existe=true;
		}
		for(Remito rt: remitosTransporte){
			if(rt.getNro()==NroRemito)
				existe=true;
		}
		return existe;
		}
	

	private List<RemitoItem> generarItemsRemito(Vector<RemitoItemVista> itemsRemVista) {
		Vector<RemitoItem> itemsRemito = new Vector<RemitoItem>();
		for(RemitoItemVista vista: itemsRemVista){
			RemitoItem item=new RemitoItem();
			item.setCantidad(vista.getCantidad());
			item.setRodamiento(buscarRodamiento(vista.getRodamiento().getCodigo()));
			itemsRemito.add(item);
			grabarItemRemito(item);
		}		
		return itemsRemito;		
	}
	

		
	private int grabarItemRemito(RemitoItem ri){
		return srvDAO.grabarItemStock(ri);
	}	
	  
	public List <RemitoItem> obtenerItemsRemito(int remitoID){
		List <RemitoItem> ri= srvDAO.getItemsRemito(remitoID);
		return ri;
	}
	
	
	/* :: CU05 - Venta de Rodamientos (Facturacion) :: */
	
	public List<RemitoCliente> remitosAFacturar(){
	List<RemitoCliente> rc = obtenerRemitosaFacturar();
	return rc;
	}
	
	private List<RemitoCliente> obtenerRemitosaFacturar() {
		List<RemitoCliente> lista = null;
		for(RemitoCliente rcActual : remitosCliente)
			if(rcActual.getEstadoEnvio()== "Emitido" || rcActual.getEstadoEnvio() == "Conformado")
			{
				lista.add(rcActual);
			}
		return lista;
	}

	
	
	public void nuevaFactura(FacturaVista vista){ 
		Factura factura = new Factura();
		List<RemitoCliente> lista = this.remitosAFacturar();
		for(RemitoCliente rcActual : lista)
		{
			factura.setNro(vista.getNro());
			factura.setFechaEmision(vista.getFechaEmision());
			factura.setRemito(rcActual);
			factura.setFinanciacion(generarFinanciacion(vista.getFinanciacion()));
			factura.setDescuentoContado(vista.getDescuentoContado());
			factura.setFechaVencimiento(vista.getFechaVencimiento());
			factura.setItemsFactura(generarItemsFactura(vista.getItemsFactura()));
			facturas.add(factura);
			srvDAO.addFactura(factura);	
			chgRemitoClienteSt(rcActual.getNro());
		}
	}
	
private Financiacion generarFinanciacion(FinanciacionVista financiacion) {
		Financiacion f = new Financiacion();
		f.setId(financiacion.getId());
		f.setCuotas(financiacion.getCuotas());
		f.setRecargo(financiacion.getRecargo());
		
		return f;
	}
	
	private List<FacturaItem> generarItemsFactura(Vector<FacturaItemVista> itemsFacturaVista) {
		Vector<FacturaItem> itemsFactura = new Vector<FacturaItem>();
		for(FacturaItemVista vista: itemsFacturaVista){
			FacturaItem item=new FacturaItem();
			item.setId(vista.getId());
			item.setCantidad(vista.getCantidad());
			item.setPrecio(vista.getPrecio());
			item.setRodamiento(buscarRodamiento(vista.getRodamiento().getCodigo()));
			itemsFactura.add(item);
		}
	return itemsFactura;
	}


	
	public List <Factura> obtenerFactura(){
		facturas = srvDAO.getfacturas();
		return facturas;
	}
	
	public Factura getUniqueFactura(int NroFactura){
		Factura f= null;
		if(facturaExiste(NroFactura)){
		f= srvDAO.getUniqueFactura(NroFactura);
		}
		return f;
		}
	


	private boolean facturaExiste(int NroFactura){
		boolean existe= false;
		for(Factura f: facturas){
		if(f.getNro() == NroFactura)
		existe=true;
		}
		return existe;
		}

	
	
	public boolean chgFacturaSt(int nroFactura){
		boolean retVal = false;
		this.actualizarFacturaSt(nroFactura, "Cobrada");
		retVal = srvDAO.updateFacturaSt(nroFactura, "Cobrada");
		return retVal;
	}	
	
private void actualizarFacturaSt(int nroFactura, String estado) {
		Factura f = this.getUniqueFactura(nroFactura);
		f.setEstado(estado);
		this.actualizarFacturaEnColeccion(f);
}
	

private void actualizarFacturaEnColeccion(Factura f){
			for(Factura fActual: facturas){
				if(fActual.sosFactura(f.getNro())){
					 fActual.setEstado(f.getEstado());
				}
			}
		}
	
 /* :: CU07 - ABM STOCK RODAMIENTO :: */
	/*ALTA DE ITEM DE STOCK*/
	public ItemStock ItemStock_Alta_Ingreso(String codigo, String marca, String nroSerie, String origen, String sufijo, int cantidad,String estado,float precioCosto,float precioVenta, Date ultimaActualizacion){
		 Rodamiento r = generarRodamiento(0, codigo,  marca,  nroSerie,  origen,  sufijo);
		 ItemStock i = generarItemStock(0, cantidad, estado, precioCosto, precioVenta,  r,  ultimaActualizacion);
		 stock.add(i);
		 return i;
	}
	
	public int ItemStock_Alta_Confirmacion(String codigo, float precioCosto){
		ItemStock i = buscarItemStockAlta(codigo, precioCosto);
		Rodamiento r = i.getRodamiento();
		int id = 0;
		id = grabarRodamiento(r);
		r.setId(id);
		rodamientos.add(r);
		i.setRodamiento(r);
		id = grabarItemStock(i);
		i.setId(id);
		stock.add(i);
		return id;
	}
	
	/*BAJA LÃ“GICA DE ITEM STOCK*/
	public ItemStock ItemStock_Eliminacion_Inicio(int IdItemStock){
		ItemStock i = this.buscarItemStock(IdItemStock);
		if(i.getEstado() == "Deshabilitado"){
			return null;
		}
		return i;
	}
	
	public boolean ItemStock_Eliminacion_Confirmacion(int IdItemStock){
		boolean retVal = false;
		actualizarItemStockEnColeccion(IdItemStock, "Deshabilitado");
		retVal = srvDAO.updateEstadoItemStock(IdItemStock, "Deshabilitado");
		return retVal;
	}	
 	
	/*MODIFICACION DE ITEM STOCK*/	
	public ItemStock ItemStock_Modificacion_Inicio(int IdItemStock){
		return this.buscarItemStock(IdItemStock);		
	}

	public boolean ItemStock_Modificacion_Confirmacion(int idRod, String codigo, String marca, String nroSerie, String origen, String sufijo, int idItem, int cantidad,String estado,float precioCosto,float precioVenta, Date ultimaActualizacion){
		 boolean retVal = false;
		 Rodamiento r = generarRodamiento(idRod, codigo,  marca,  nroSerie,  origen,  sufijo);
		 ItemStock i = generarItemStock(idItem, cantidad, estado, precioCosto, precioVenta,  r,  ultimaActualizacion);
		 retVal = srvDAO.updateItemStock(i);
		 if(retVal){
			 actualizarRodamientoEnColeccion(r);
			 actualizarItemStockEnColeccion(i);			 
		 }
		 return retVal;
	}
	
	/*METODOS PRIVADOS*/
	private void actualizarRodamientoEnColeccion(Rodamiento rn){
		for(Rodamiento rActual: rodamientos){
			if(rActual.sosRodamiento(rn.getId())){
				 rActual.setCodigo(rn.getCodigo());
				 rActual.setMarca(rn.getMarca());
				 rActual.setNroSerie(rn.getNroSerie());
				 rActual.setOrigen(rn.getOrigen());
				 rActual.setSufijo(rn.getSufijo());
			}
		}
	}
	
	private void actualizarItemStockEnColeccion(ItemStock i){
		for(ItemStock iActual: stock){
			if((iActual).sosItemStock(i.getId())){
				iActual.setCantidad(i.getCantidad());
				iActual.setEstado(i.getEstado());
				iActual.setPrecioCosto(i.getPrecioCosto());
				iActual.setPrecioVenta(i.getPrecioVenta());
				iActual.setUltimaActualizacion(i.getUltimaActualizacion());
				iActual.setRodamiento(i.getRodamiento());
			}
		}
	}

	private void actualizarItemStockEnColeccion(int id, String estado){
		for(ItemStock iActual: stock){
			if(iActual.sosItemStock(id)){
				iActual.setEstado(estado);
			}
		}
	}	
	
	private ItemStock buscarItemStockAlta(String codigo, float precioCosto){
		for(ItemStock i:stock){
			if(i.getPrecioCosto() == precioCosto && i.getRodamiento().getCodigo() == codigo && i.getId() == 0){
				return i;
			}
		}
		return null;
	}

	private ItemStock buscarItemStock(int IdItemStock){
		for(ItemStock i:stock){
			if(i.sosItemStock(IdItemStock)){
				return i;
			}
		}
		ItemStock i = srvDAO.getItemStock(IdItemStock);
		if(i != null){
			stock.add(i);
			return i;
		}	
		return null;
	}

	private Rodamiento buscarRodamiento(int id){
		for(Rodamiento r: rodamientos){
			if(r.sosRodamiento(id)){
				return r;
			}
		}
		Rodamiento r = srvDAO.getRodamiento(id);
		if(r!=null){
			rodamientos.add(r);
			return r;
		}
		return null;
	}
	
	private Proveedor buscarProveedor(int id){
		for(Proveedor r: proveedores){
			if(r.sosProveedor(id)){
				return r;
			}
		}
		Proveedor r = srvDAO.getProveedor(id);
		if(r!=null){
			proveedores.add(r);
			return r;
		}
		return null;
	}		

	private Rodamiento generarRodamiento(int id, String codigo, String marca, String nroSerie, String origen, String sufijo){
		Rodamiento r = new Rodamiento();
		r.setCodigo(codigo);
		r.setMarca(marca);
		r.setNroSerie(nroSerie);
		r.setOrigen(origen);
		r.setSufijo(sufijo);
		r.setId(id);
		return r;
	}	
	
	private ItemStock generarItemStock(int id, int cantidad,String estado,float precioCosto,float precioVenta, Rodamiento rodamiento, Date ultimaActualizacion){
		ItemStock i = new ItemStock();
		i.setCantidad(cantidad);
		i.setEstado(estado);
		i.setPrecioCosto(precioCosto);
		i.setPrecioVenta(precioVenta);
		i.setRodamiento(rodamiento);
		i.setUltimaActualizacion(ultimaActualizacion);
		i.setId(id);
		return i;
	}		
	/*:: FIN ABM STOCK DE RODAMIENTOS*/ 
	
 /*OLD*/
	 
	public List <Rodamiento> obtenerRodamientos(){
		rodamientos = srvDAO.getRodamientos();
		return rodamientos;
	}
	
	private int grabarRodamiento(Rodamiento r){
		return srvDAO.grabarRodamiento(r);
	}

	private int grabarItemStock(ItemStock i){
		return srvDAO.grabarItemStock(i);
	}	
	  
   


//CU_06 & CU_08////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//alta Cliente
	
	public void addCliente(String cuit, String direccion, String razonSocial, String condIVA){
	Cliente c=  new Cliente();
	c.setCondIVA(condIVA);
	c.setCUIT(cuit);
	c.setDireccion(direccion);
	c.setRazonSocial(razonSocial);
	srvDAO.agregarCli(c);
	clientes.add(c);
	
	}
	//alta proveedor
	public void addProveedor(String direccion, String razonSocial, String telefono){
	Proveedor p=  new Proveedor();
	if (proveedorExiste(razonSocial)){
	p.setDireccion(direccion);
	p.setRazonSocial(razonSocial);
	p.setListaPrecios(null);
	p.setTelefono(telefono);
	srvDAO.agregarPro(p);
	proveedores.add(p);
	}else{
	System.out.println("Este cliente ya existe");
	}
	
	}
	
	//recuperar cliente
	private Cliente getCliente(String cuit){
	Cliente c= null;
	if(clienteExiste(cuit)){
	c= srvDAO.getClient(cuit);
	}
	
	return c;
	}
	
	//recuperar proveedor
	private Proveedor getProveedor(String razonSocial){
	Proveedor p= null;
	if(proveedorExiste(razonSocial)){
	p= srvDAO.getProveedor(razonSocial);
	}
	
	return p;
	}
	
	//modificar cliente
	public void modifyClient(String cuit, String CondIVA, String direccion, String razonSocial, String estado){
	if(clienteExiste(cuit)){
	Cliente c = getCliente(cuit);
	c.setCondIVA(CondIVA);
	c.setCUIT(cuit);
	c.setDireccion(direccion);
	c.setRazonSocial(razonSocial);
	//c.setEstado(estado);
	System.out.println("El cliente ha sido actualizado");
	}else{
	System.out.println("Este cliente no existe, por favor ir al menu principal y crear un nuevo cliente");
	}
	}
	
	
	//modificar proveedor
	public void modifyProveedor (String razonSocial, String direccion, String telefono, String estado){
		if(proveedorExiste(razonSocial)){
		Proveedor p1 = null;
		p1=getProveedor(razonSocial);
		p1.setDireccion(p1.getDireccion());
		p1.setTelefono(telefono);
		p1.setEstado(estado);
		
		System.out.println("El cliente ha sido actualizado");
		}
		}
	
	public void bajaCliente(String cuit){
	if(clienteExiste(cuit)){
	Cliente c = getCliente(cuit);
	//c.setEstado("Desactivado");
	System.out.println("El cliente ha sido eliminado");
	}
	}
	
	
	public void bajaProveedor(String razonSocial){
	if(proveedorExiste(razonSocial)){
	Proveedor p = getProveedor(razonSocial);
	p.setEstado("Desactivado");
	System.out.println("El proveedor ha sido eliminado");
	}
	}
	
	
	private boolean proveedorExiste(String razonSocial){
	boolean existe= false;
	for(Proveedor p: proveedores){
	if(p.getRazonSocial()== razonSocial)
	existe=true;
	}
	return existe;
	}


/* :: CU09 Administrar listado de precios :: */
	
	public List <Proveedor> obtenerProveedor(){
		return srvDAO.getProveedor();
	}
	
	public ListaPrecio listadoPrecio_iniciar(int proveedor, int descuentoContado, Date fechaVencimiento, int nroListReemplazo){
		ListaPrecio retVal = new ListaPrecio();
		retVal.setDescuentoContado(descuentoContado);
		retVal.setFechaEmision(new Date());
		retVal.setFechaVencimiento(fechaVencimiento);
		retVal.setNroListReemplazo(nroListReemplazo);
		retVal.setNro(0);
		Proveedor p = buscarProveedor(proveedor);
		p.agregarListadoPrecio(retVal);
		return retVal;
	}

	public void listadoPrecio_agregarFinanciacion(int proveedor, int nroReemplazo, int cuota, float recargo){
		Financiacion f = new Financiacion();
		f.setCuotas(cuota);
		f.setRecargo(recargo);
		for(Proveedor r: proveedores){
			if(r.sosProveedor(proveedor)){
				for(ListaPrecio l: r.getListaPrecios()){
					if(l.getNro() == 0 && l.getNroListReemplazo() == nroReemplazo){
						l.agregarFinanciacion(f);
					}
				}
			}
		}
	}
	
	public void listadoPrecio_agregarItemPrecio(int proveedor, int nroReemplazo, int rodamiento, int cantidad, float precioCosto, float precioVenta){
		ItemPrecio i = new ItemPrecio();
		i.setCantidad(cantidad);
		i.setPrecioCosto(precioCosto);
		i.setPrecioVenta(precioVenta);
		Rodamiento r = this.buscarRodamiento(rodamiento);
		i.setRodamiento(r);
		
		for(Proveedor p: proveedores){
			if(p.sosProveedor(proveedor)){
				for(ListaPrecio l: p.getListaPrecios()){
					if(l.getNro() == 0 && l.getNroListReemplazo() == nroReemplazo){
						l.agregarItemPrecio(i);
					}
				}
			}
		}
	}

	public boolean listadoPrecio_confirmar(int proveedor, int nroReemplazo){
		ListaPrecio li = null; int idRet = 0; Proveedor prov = null;
		for(Proveedor p: proveedores){
			if(p.sosProveedor(proveedor)){
				prov = p;
				for(ListaPrecio l: p.getListaPrecios()){
					if(l.getNro() == 0 && l.getNroListReemplazo() == nroReemplazo){
						li = l;
					}
				}
			}
		}
		if(li != null){
			idRet = srvDAO.grabarListaPrecio(li);
			li.setNro(idRet);
			srvDAO.actualizarProveedor(prov);
		}
		return (idRet > 0);
	}
	
	/* FIN CU 9 */
	
	/* :: CU 13 COMPARATIVA DE PRECIO :: */

	public ProveedorVista comparativaPrecio_iniciar_(String nroSerie, String marca, List <String> marcas, String origen){
		return srvDAO.comparativaDePrecio(nroSerie, marca, marcas, origen);
	}	
	
	/* FIN CU 13*/	
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




/* :: CU09 - Administrar listas de precios de proveedores ::  GO TO Proveedores.java*/


/* TODO :: CU10 - Compra de rodamientos :: */

	

	public List<OrdenPedido> ordenPedidoAComprar(){
		List<OrdenPedido> op = obtenerOrdenPedidoAComprar();
		return op;
		}
		
	@SuppressWarnings("null")
	private List<OrdenPedido> obtenerOrdenPedidoAComprar() {
			List<OrdenPedido> lista = null;
			for(OrdenPedido opActual : ordenesPedido)
				if(opActual.getEstado() == "Para Comprar" || opActual.getEstado() == "Emitida")
				{
					lista.add(opActual);
				}
			return lista;
	}

	
	public void nuevoOrdenCompra(OrdenCompraVista vista)
	{ 
		List<OrdenPedido> lista = this.ordenPedidoAComprar();
		for(OrdenPedido opActual : lista)
		{
			List<OrdenPedidoItem> ListaOPI = opActual.getItems();
			for(OrdenPedidoItem opi : ListaOPI){
			if (opi.getEstado()== "Pendiente")
			{
				OrdenCompra oc = new OrdenCompra();	
				oc.setNro(vista.getNro());
				oc.setFechaEmision(vista.getFechaEmision());
				oc.setEstado(vista.getEstado());
				oc.setEstadoCompletitud(vista.getEstadoCompletitud());
				List<OrdenCompraItem> itemsOrdenCompra = null;
				Proveedor pActual = opi.getProveedor();
				oc.setProveedor(pActual);
				chgOrdenPedidoItemSt(opi.getId(),"Pedido a Proveedor");
				OrdenCompraItem oci = convertOpiToOci(opi);
				itemsOrdenCompra.add(oci);
				for(OrdenPedidoItem opi2 : ListaOPI)
				{
					if(opi2.getEstado()== "Pendiente" && opi2.getProveedor()== pActual)
					{
						chgOrdenPedidoItemSt(opi2.getId(), "Pedido a Proveedor");
						OrdenCompraItem oci2 = convertOpiToOci(opi2);
						itemsOrdenCompra.add(oci2);
					}							
				}
				oc.setItems(itemsOrdenCompra);
				ordenesCompra.add(oc);
				srvDAO.addOrdenCompra(oc);	
				chgOrdenPedidoStPedidoProveedor(opActual.getNro());
			}
		}
		}
	
		
	}


	public List <OrdenCompra> obtenerOrdenCompra(){
		ordenesCompra = srvDAO.getOrdenCompra();
		return ordenesCompra;
	}

	public boolean chgOrdenCompraStCerrado(int nroOC){
		boolean retVal = false;
		this.actualizarOrdenCompraStCerrado(nroOC, "Cerrada");
		retVal = srvDAO.updateOrdenCompraStCerrado(nroOC, "Cerrada");
		return retVal;
	}	
	
private void actualizarOrdenCompraStCerrado(int nroOC, String estado) {
		OrdenCompra oc = this.getUniqueOrdenCompra(nroOC);
		oc.setEstado(estado);
		this.actualizarOrdenCompraEnColeccion(oc);
}
	

private OrdenCompra getUniqueOrdenCompra(int nroOC) {

	OrdenCompra op= null;
	op= srvDAO.getUniqueOrdenCompra(nroOC);
	return op;

}

private void actualizarOrdenCompraEnColeccion(OrdenCompra oc){
			for(OrdenCompra ocActual: ordenesCompra){
				if(ocActual.sosOrdenCompra(oc.getNro())){
					 ocActual.setEstado(oc.getEstado());
				}
			}
		}

	
		
		public boolean chgOrdenPedidoItemSt(int id, String string)
		{			
				boolean retVal = false;
				this.actualizarOrdenPedidoItemSt(id, string);
				retVal = srvDAO.updateOPISt(id, string);
				return retVal;
			}	
			
		private void actualizarOrdenPedidoItemSt(int idOPI, String estado)
		{
				OrdenPedidoItem opi = this.getUniqueOPI(idOPI);
				opi.setEstado(estado);
				this.actualizarOPIEnColeccion(opi);
		}
			

		private OrdenPedidoItem getUniqueOPI(int idOPI) 
		{
			OrdenPedidoItem opi= null;
			opi= srvDAO.getUniqueOPI(idOPI);
			return opi;
		}

		private void actualizarOPIEnColeccion(OrdenPedidoItem opi){
					for(OrdenPedido opActual: ordenesPedido){
						List<OrdenPedidoItem> lista = opActual.getItems();
						for(OrdenPedidoItem opiActual : lista)
						{
							if(opiActual.getId() == opi.getId())
							{
							 opiActual.setEstado(opi.getEstado());
							}
						}
					}
		}
		
	
		private OrdenCompraItem convertOpiToOci(OrdenPedidoItem opi) {
				OrdenCompraItem oci = new OrdenCompraItem();
				oci.setCantidad(opi.getCantidad());
				oci.setEstado("Pendiente de recepcion");
				oci.setPrecio(opi.getPrecio());
				oci.setRodamiento(opi.getRodamiento());
				//oci.setId(); Como se le asigna el valor desde aca... quizas llamando a la base de datos 
				//para que me devuelva el ultimo ID y a eso le sumo uno??
				return oci;
			}

		private boolean chgOrdenPedidoStPedidoProveedor(int nroOP) {
				boolean retVal = false;
				this.actualizarOrdenPedidoStPedidoProveedor(nroOP, "En proceso de Compra Proveedor");
				retVal = srvDAO.updateOrdenPedidoStPedidoProveedor(nroOP, "En proceso de Compra Proveedor");
				return retVal;
			}	
			
		private void actualizarOrdenPedidoStPedidoProveedor(int nroOP, String estado) {
				OrdenPedido op = this.getUniqueOrdenPedido(nroOP);
				op.setEstado(estado);
				this.actualizarOrdenPedidoEnColeccion(op);
		}

		private OrdenPedido getUniqueOrdenPedido(int nroOP) {
			OrdenPedido op= null;
			if(ordenPedidoExiste(nroOP)){
			op= srvDAO.getUniqueOrdenPedido(nroOP);
			}
			return op;
		}
		

		private boolean ordenPedidoExiste(int nroOP) {
			boolean existe= false;
			for(OrdenPedido op: ordenesPedido){
			if(op.getNro() == nroOP)
			existe=true;
			}
			return existe;
		}

		private void actualizarOrdenPedidoEnColeccion(OrdenPedido op){
					for(OrdenPedido opActual: ordenesPedido){
						if(opActual.sosOrdenPedido(op.getNro())){
							 opActual.setEstado(op.getEstado());
						}
					}
				}
/*
private List<OrdenPedido> incorporarOrdenPedidos(Vector<OrdenPedidoVista> ordenPedidosVista) 
{
	Vector<OrdenPedido> OP = new Vector<OrdenPedido>();
	for(OrdenPedidoVista vista: ordenPedidosVista)
	{
		OrdenPedido op=new OrdenPedido();
		op.setCliente(getCliente(vista.getCliente().getCUIT()));
		op.setDescuentoContado(vista.getDescuentoContado());
		op.setEstado(vista.getEstado());
		op.setEstadoCompletitud(vista.getEstadoCompletitud());
		op.setFechaEmision(vista.getFechaEmision());
		op.setNro(vista.getNro());
		op.setOrigen(vista.getOrigen());
		op.setOdv(getODV(vista.getOdv().getIdODV()));
		op.setFinanciacion (vista.getFianciacion());
		op.setCotizacion(vista.getCotizacion());
		
		
		ordenesPedido.add(op);
	}		
	return OP;
		
	}
*/
private ODV getODV(int idODV){
	ODV o= null;
	if(odvExiste(idODV)){
	o= srvDAO.getodv(idODV);
	}
	
	return o;
	}
	
private boolean odvExiste(int idODV){
	boolean existe= false;
	for(ODV o: odv){
	if(o.getIdODV() == idODV)
		existe=true;
	}
	return existe;
}
}


/*
private List<OrdenCompraItem> generarItemsOC(Vector<OrdenCompraItemVista> itemOrdenCompraVista) 
{
	Vector<OrdenCompraItem> itemsOC = new Vector<OrdenCompraItem>();
	for(OrdenCompraItemVista vista: itemOrdenCompraVista)
	{
		OrdenCompraItem item=new OrdenCompraItem();
		item.setCantidad(vista.getCantidad());
		item.setEstado(vista.getEstado());
		item.setPrecio(vista.getPrecio());
		item.setRodamiento(buscarRodamiento(vista.getRodamiento().getCodigo()));
		itemsOC.add(item);
	}		
	return itemsOC;		
	}
}


/* TODO :: CU11 - Recepción de Mercadería :: */
/* TODO :: CU12 - Determinación del porcentaje de ganancia :: */



