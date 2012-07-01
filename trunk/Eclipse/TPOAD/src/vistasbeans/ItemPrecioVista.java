package vistasbeans;

public class ItemPrecioVista {
	private int id;
	private int cantidad;
	private float precioCosto;
	private float precioVenta;
	private RodamientoVista rodamiento;
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
