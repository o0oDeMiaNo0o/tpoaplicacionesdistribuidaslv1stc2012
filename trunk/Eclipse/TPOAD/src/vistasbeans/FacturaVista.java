package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class FacturaVista {

	private float descuentoContado; //decía int
	private Date fechaEmision;
	private Date fechaVencimiento;
	private FinanciacionVista financiacion;
	private int nro;
	private RemitoClienteVista remito;
	private Vector<ItemCotizacionVista> itemsFactura;
	public float getDescuentoContado() {
		return descuentoContado;
	}
	public void setDescuentoContado(float descuentoContado) {
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
	public FinanciacionVista getFinanciacion() {
		return financiacion;
	}
	public void setFinanciacion(FinanciacionVista financiacion) {
		this.financiacion = financiacion;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public RemitoClienteVista getRemito() {
		return remito;
	}
	public void setRemito(RemitoClienteVista remito) {
		this.remito = remito;
	}
	public Vector<ItemCotizacionVista> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(Vector<ItemCotizacionVista> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	
	
}
