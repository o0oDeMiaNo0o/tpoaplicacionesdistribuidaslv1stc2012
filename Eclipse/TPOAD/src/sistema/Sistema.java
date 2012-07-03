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
	
	
	//CU 1 Recepci�n de solicitudes de cotizaci�n de rodamientos
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
	
	//CU 2 Solicitud de cotizaci�n  - - falta especificacion
	public Vector<SolicitudCotizacionVista> solicitudesCotizacion(){
		Vector<SolicitudCotizacionVista> solicitudes=new Vector<SolicitudCotizacionVista>();
		for(SolicitudCotizacion c: solicitudesCotizacion)
			solicitudes.add(c.getVista());
		return solicitudes;		
	}
	
	
	//CU 3 Recepci�n de orden de pedido - - Falta especificacion
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
	
	/* :: CU04 - Env�o de rodamientos (Remito) :: */
	public void nuevoRemito_a_Cliente(RemitoClienteVista vista){ 
		RemitoCliente remitoCl = new RemitoCliente();
		remitoCl.setCliente(buscarCliente(vista.getCliente().getCUIT())); 
		remitoCl.setFecha(vista.getFecha());
		//Fijense que cuando hice lo Hibernate cada documento tiene sus
		//Items: Cotizacion -> CotizacionItem; Factura -> FacturaItem y demas
		//Ya no usamos una clase como item gen�rico de varios documentos ya que se hace dificil hacer las anotaciones
		//remitoCl.setItems(generarItemsRemito(vista.getItems()));
		remitoCl.setNro(vista.getNro());
		remitoCl.setEstadoEnvio(vista.getEstadoEnvio());
		remitosCliente.add(remitoCl);
		
	}
	

	private List<RemitoItem> generarItemsRemito(Vector<ItemCotizacionVista> itemsRemVista) {
		Vector<RemitoItem> itemsRemito = new Vector<RemitoItem>();
		for(ItemCotizacionVista vista: itemsRemVista){
			RemitoItem item=new RemitoItem();
			item.setCantidad(vista.getCantidad());
			item.setRodamiento(buscarRodamiento(vista.getRodamiento().getCodigo()));
			itemsRemito.add(item);
		}		
		return itemsRemito;		
	}
	/* :: CU05 - Venta de Rodamientos (Facturacion) :: */
	public void nuevaFactura(FacturaVista vista){ 
		Factura factura = new Factura();
		/* factura.setCliente(buscarCliente(vista.getRemito().getCliente().getCUIT()));*/ 
		factura.setFechaEmision(vista.getFechaEmision());
		factura.setFechaVencimiento(vista.getFechaVencimiento());
		//factura.setItemsFactura((List<FacturaItem>) generarItemsFactura(vista.getItemsFactura()));
		factura.setNro(vista.getNro());
		factura.setDescuentoContado(vista.getDescuentoContado());
		//factura.setFinanciacion(vista.getFinanciacion());
		facturas.add(factura);
		
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
	
	/*BAJA LÓGICA DE ITEM STOCK*/
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


}

/* :: CU09 - Administrar listas de precios de proveedores ::  GO TO Proveedores.java*/


/* TODO :: CU10 - Compra de rodamientos :: */
/* TODO :: CU11 - Recepci�n de Mercader�a :: */
/* TODO :: CU12 - Determinaci�n del porcentaje de ganancia :: */
/* TODO :: CU13 - Determinaci�n del porcentaje de ganancia :: */


