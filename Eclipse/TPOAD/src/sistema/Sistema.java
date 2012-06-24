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
	
	public void nuevaSolicitudCotizacion(){ //CU1
		
	}
	
	//CU 2
	public Vector<SolicitudCotizacionVista> solicitudesCotizacion(){
		Vector<SolicitudCotizacionVista> solicitudes=new Vector<SolicitudCotizacionVista>();
		for(SolicitudCotizacion c: solicitudesCotizacion)
			solicitudes.add(c.getVista());
		return solicitudes;		
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
			if(iActual.sosItemStock(i.getId())){
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

	//Agregar filtro por estado
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
	  
   
}
