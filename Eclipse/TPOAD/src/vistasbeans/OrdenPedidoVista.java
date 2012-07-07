package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class OrdenPedidoVista {

	private ClienteVista cliente;
	private Vector<CotizacionVista> cotizacion;
	private int descuentoContado;
	private Date fechaEmision;
	private FinanciacionVista fianciacion;
	private Vector<CotizacionProveedor> items;
	private int nro;
	private ODVVista odv;
	private String estado;
	private float estadoCompletitud;
	private String origen;
	public ClienteVista getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVista cliente) {
		this.cliente = cliente;
	}
	public Vector<CotizacionVista> getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Vector<CotizacionVista> cotizacion) {
		this.cotizacion = cotizacion;
	}
	public int getDescuentoContado() {
		return descuentoContado;
	}
	public void setDescuentoContado(int descuentoContado) {
		this.descuentoContado = descuentoContado;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public FinanciacionVista getFianciacion() {
		return fianciacion;
	}
	public void setFianciacion(FinanciacionVista fianciacion) {
		this.fianciacion = fianciacion;
	}
	public Vector<CotizacionProveedor> getItems() {
		return items;
	}
	public void setItems(Vector<CotizacionProveedor> items) {
		this.items = items;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public ODVVista getOdv() {
		return odv;
	}
	public void setOdv(ODVVista odv) {
		this.odv = odv;
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
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	
}
