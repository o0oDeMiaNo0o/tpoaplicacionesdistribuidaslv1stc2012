package vistasbeans;

import java.io.Serializable;

public class ItemPrecioVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private float precioCosto;
	private float precioVenta;
	private RodamientoVista rodamiento;
	
	public ItemPrecioVista(int id, int cant, float pc, float pv, RodamientoVista r){
		this.id = id;
		this.cantidad = cant;
		this.precioCosto = pc;
		this.precioVenta = pv;
		this.rodamiento = r;
	}
		
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public RodamientoVista getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(RodamientoVista rodamiento) {
		this.rodamiento = rodamiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
