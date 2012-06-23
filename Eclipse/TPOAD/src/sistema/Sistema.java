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
	
	public void almacenarRodamiento(String codigo, String marca, String nroSerie, String origen, String sufijo){
		Rodamiento r = new Rodamiento();
		r.setCodigo(codigo);
		r.setMarca(marca);
		r.setNroSerie(nroSerie);
		r.setOrigen(origen);
		r.setSufijo(sufijo);
		grabarRodamiento(r);
		rodamientos.add(r);
	}
	
	public void almacenarItemStock(int cantidad,String estado,float precioCosto,float precioVenta, int idRodamiento, Date ultimaActualizacion){
		Rodamiento r = buscarRodamiento(idRodamiento);
		if(r != null){
			ItemStock i = new ItemStock();
			i.setCantidad(cantidad);
			i.setEstado(estado);
			i.setPrecioCosto(precioCosto);
			i.setPrecioVenta(precioVenta);
			i.setRodamiento(r);
			i.setUltimaActualizacion(ultimaActualizacion);
			grabarItemStock(i);
			stock.add(i);
		}
	}
	
	public List <Rodamiento> obtenerRodamientos(){
		rodamientos = srvDAO.getRodamientos();
		return rodamientos;
	}
	
	private void grabarRodamiento(Rodamiento r){
		srvDAO.grabarRodamiento(r);
	}

	private void grabarItemStock(ItemStock i){
		srvDAO.grabarItemStock(i);
	}	
	
	private Rodamiento buscarRodamiento(int id){
		for(Rodamiento r: rodamientos){
			if(r.sosRodamiento(id)){
				return r;
			}
		}
		return null;
	}
	
}
