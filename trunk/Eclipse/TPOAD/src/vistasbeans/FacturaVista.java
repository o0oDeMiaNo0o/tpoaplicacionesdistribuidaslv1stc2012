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
	private Vector<FacturaItemVista> itemsFactura;
	private String estado;

	
	
	
	public FacturaVista(int nro, Date fechaEmision, RemitoClienteVista remito,
			FinanciacionVista financiacion, float descuentoContado,
			Date fechaVencimiento, Vector<FacturaItemVista> itemsFactura,
			String estado) {
		super();
		this.nro = nro;
		this.fechaEmision = fechaEmision;
		this.remito = remito;
		this.financiacion = financiacion;
		this.descuentoContado = descuentoContado;
		this.fechaVencimiento = fechaVencimiento;
		this.itemsFactura = itemsFactura;
		this.estado = estado;
	}
	public FacturaVista() {
		// TODO Auto-generated constructor stub
	}
	public String getEstado() {
		return estado;
	}
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
	public Vector<FacturaItemVista> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(Vector<FacturaItemVista> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	
	
}
