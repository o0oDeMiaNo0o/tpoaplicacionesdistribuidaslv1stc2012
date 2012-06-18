package beans;

import java.util.Date;
import java.util.Vector;

import vistasbeans.SolicitudCotizacionVista;

public class SolicitudCotizacion {

	private Cliente cliente;
	private Date fechaEmision;
	private Vector<ItemCantidad> items;
	private int nro;
	private String estado;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Vector<ItemCantidad> getItems() {
		return items;
	}
	public void setItems(Vector<ItemCantidad> items) {
		this.items = items;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public SolicitudCotizacionVista getVista(){
		SolicitudCotizacionVista vista=new SolicitudCotizacionVista();
		vista.setCliente(cliente.getVista());
		vista.setEstado(estado);
		vista.setFechaEmision(fechaEmision);
		vista.setItems(items); //hacer la vista del os items
		vista.setNro(nro);
		
		return vista;
	}
}
