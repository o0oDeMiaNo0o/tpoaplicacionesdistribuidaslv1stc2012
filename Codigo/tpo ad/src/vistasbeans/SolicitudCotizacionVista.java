package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class SolicitudCotizacionVista {

	private ClienteVista cliente;
	private Date fechaEmision;
	private Vector<ItemCantidadVista> items;
	private int nro;
	private String estado;
	public ClienteVista getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVista cliente) {
		this.cliente = cliente;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Vector<ItemCantidadVista> getItems() {
		return items;
	}
	public void setItems(Vector<ItemCantidadVista> items) {
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
	
}
