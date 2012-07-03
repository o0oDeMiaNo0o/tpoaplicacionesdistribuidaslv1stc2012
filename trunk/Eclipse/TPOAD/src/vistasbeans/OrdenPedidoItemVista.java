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
}