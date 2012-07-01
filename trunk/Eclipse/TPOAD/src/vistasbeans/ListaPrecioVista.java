package vistasbeans;

import java.util.Date;
import java.util.Vector;

import beans.Proveedor;

public class ListaPrecioVista {

	private int descuentoContado;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Vector<FinanciacionVista> financiacion;
	private Vector<ItemPrecioVista> items;
	private int nro;
	private int nroListReemplazo;
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
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Vector<FinanciacionVista> getFinanciacion() {
		return financiacion;
	}
	public void setFinanciacion(Vector<FinanciacionVista> financiacion) {
		this.financiacion = financiacion;
	}
	public Vector<ItemPrecioVista> getItems() {
		return items;
	}
	public void setItems(Vector<ItemPrecioVista> items) {
		this.items = items;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public int getNroListReemplazo() {
		return nroListReemplazo;
	}
	public void setNroListReemplazo(int nroListReemplazo) {
		this.nroListReemplazo = nroListReemplazo;
	}
	
	
}
