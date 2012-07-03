package vistasbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import beans.Proveedor;

public class ListaPrecioVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int descuentoContado;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private List<FinanciacionVista> financiacion;
	private List<ItemPrecioVista> items;
	private int nro;
	private int nroListReemplazo;
	private String estado;

	public String getEstado() {
		return estado;
	}	
	public ListaPrecioVista(int doc, Date femis, Date fvenc, List <FinanciacionVista> f, List <ItemPrecioVista> i, int nro, int nroReemp){
		this.descuentoContado = doc;
		this.fechaEmision = femis;
		this.fechaVencimiento = fvenc;
		this.financiacion = f;
		this.items = i;
		this.nro = nro;
		this.nroListReemplazo = nroReemp;
	}
	
	public int getDescuentoContado() {
		return descuentoContado;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public List<FinanciacionVista> getFinanciacion() {
		return financiacion;
	}

	public List<ItemPrecioVista> getItems() {
		return items;
	}

	public int getNro() {
		return nro;
	}

	public int getNroListReemplazo() {
		return nroListReemplazo;
	}
	/*
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
	
	*/
}
