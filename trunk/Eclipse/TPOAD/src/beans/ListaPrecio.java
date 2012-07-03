package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import vistasbeans.FinanciacionVista;
import vistasbeans.ItemPrecioVista;
import vistasbeans.ListaPrecioVista;

@Entity
@Table(name="ListaPrecio")
public class ListaPrecio {

	@Id @Column(name="IdListaPrecio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;	
	private int descuentoContado;
	private Date fechaEmision;
	private Date fechaVencimiento;
	@OneToMany
	@JoinTable(name="FinanciacionListaPrecio",
			joinColumns={@JoinColumn(name="FK_ListaPrecio")},
			inverseJoinColumns={@JoinColumn(name="FK_Financiacion")}
			)	
	private List<Financiacion> financiacion;
	@OneToMany
	@JoinColumn(name="FK_ListaPrecio", referencedColumnName="IdListaPrecio")
	private List<ItemPrecio> items;
	private int nroListReemplazo;
	private String estado;

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNro() {
		return nro;
	}
	
	public void setNro(int nro) {
		this.nro = nro;
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
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public List<Financiacion> getFinanciacion() {
		return financiacion;
	}
	public void setFinanciacion(List<Financiacion> financiacion) {
		this.financiacion = financiacion;
	}
	public List<ItemPrecio> getItems() {
		return items;
	}
	public void setItems(List<ItemPrecio> items) {
		this.items = items;
	}
	public int getNroListReemplazo() {
		return nroListReemplazo;
	}
	public void setNroListReemplazo(int nroListReemplazo) {
		this.nroListReemplazo = nroListReemplazo;
	}
	
	public void agregarFinanciacion(Financiacion f){
		this.financiacion.add(f);
	}
	
	public void agregarItemPrecio(ItemPrecio i){
		this.items.add(i);
	}
	
	public ListaPrecioVista vista(){
		List<ItemPrecioVista> i = new ArrayList<ItemPrecioVista>();
		for(ItemPrecio it:items){
			i.add(it.vista());
		}
		List<FinanciacionVista> f = new ArrayList<FinanciacionVista>();
		for(Financiacion fi:financiacion){
			f.add(fi.vista());
		}		
		return (new ListaPrecioVista(descuentoContado, fechaEmision, fechaVencimiento, f, i, nro, nroListReemplazo));
	}	
	
	
}
