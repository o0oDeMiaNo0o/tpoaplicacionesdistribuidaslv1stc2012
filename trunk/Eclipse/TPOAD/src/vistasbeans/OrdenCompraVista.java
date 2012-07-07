package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class OrdenCompraVista {

	private Date fechaEmision;
	private Vector<OrdenCompraItemVista> items;
	private int nro;
	private Vector<OrdenPedidoVista> ordenPedidos;
	private ProveedorVista proveedor;
	private String estado;
	private float estadoCompletitud;
	
	
	
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Vector<OrdenCompraItemVista> getItems() {
		return items;
	}
	public void setItems(Vector<OrdenCompraItemVista> items) {
		this.items = items;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public Vector<OrdenPedidoVista> getOrdenPedidos() {
		return ordenPedidos;
	}
	public void setOrdenPedidos(Vector<OrdenPedidoVista> ordenPedidos) {
		this.ordenPedidos = ordenPedidos;
	}
	public ProveedorVista getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorVista proveedor) {
		this.proveedor = proveedor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getEstadoCompletitud() {
		return estadoCompletitud;
	}
	public void setEstadoCompletitud(float estadoCompletitud) {
		this.estadoCompletitud = estadoCompletitud;
	}
	
	
}
