package sistema;

import java.util.Vector;

import beans.*;
import vistasbeans.*;

public class Sistema {

	private static Sistema sistema;
	
	private Vector<Cliente> clientes;
	private Vector<Cotizacion> cotizaciones;
	private Vector<Factura> facturas;
	private Vector<ODV> odv;
	private Vector<OrdenCompra> ordenesCompra;
	private Vector<OrdenPedido> ordenesPedido;
	private Vector<Proveedor> proveedores;
	private Vector<RemitoCliente> remitosCliente;
	private Vector<RemitoProveedor> remitosProveedor;
	private Vector<RemitoTransporte> remitosTransporte;
	private Vector<Rodamiento> rodamientos;
	private Vector<SolicitudCotizacion> solicitudesCotizacion;
	private Vector<ItemStock> stock;
	
	private Sistema(){
		clientes=new Vector<Cliente>();
		cotizaciones=new Vector<Cotizacion>();
		facturas=new Vector<Factura>();
		odv=new Vector<ODV>();
		ordenesCompra=new Vector<OrdenCompra>();
		ordenesPedido=new Vector<OrdenPedido>();
		proveedores=new Vector<Proveedor>();
		remitosCliente=new Vector<RemitoCliente>();
		remitosProveedor=new Vector<RemitoProveedor>();
		remitosTransporte=new Vector<RemitoTransporte>();
		rodamientos=new Vector<Rodamiento>();
		solicitudesCotizacion=new Vector<SolicitudCotizacion>();
		stock=new Vector<ItemStock>();
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
	
	
	
	
	
}
