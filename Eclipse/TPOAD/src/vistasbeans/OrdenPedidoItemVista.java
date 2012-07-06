package vistasbeans;

public class OrdenPedidoItemVista {

	private int id;
	private int cantidad;
	private float precio;
	private RodamientoVista rodamiento;
	private ProveedorVista proveedor;
	private String estado;

	public String getEstado() {
		return estado;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public RodamientoVista getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoVista rodamiento) {
		this.rodamiento = rodamiento;
	}

	public ProveedorVista getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorVista proveedor) {
		this.proveedor = proveedor;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}