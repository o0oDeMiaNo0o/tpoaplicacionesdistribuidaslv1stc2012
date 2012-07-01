package beans;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="Factura")
public class Factura {
	@Id @Column(name="IdFactura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;	
	private float descuentoContado;
	private Date fechaEmision;
	private Date fechaVencimiento;
	@OneToOne
	@JoinColumn(name="FK_Financiacion", referencedColumnName="IdFinanciacion")
	private Financiacion financiacion;
	@OneToOne
	@JoinColumn(name="FK_Remito", referencedColumnName="IdRemito")
	private Remito remito;
	@OneToMany
	@JoinColumn(name="FK_Factura", referencedColumnName="IdFactura")	
	private List<FacturaItem> itemsFactura;
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
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
	public Financiacion getFinanciacion() {
		return financiacion;
	}
	public void setFinanciacion(Financiacion financiacion) {
		this.financiacion = financiacion;
	}
	public Remito getRemito() {
		return remito;
	}
	public void setRemito(Remito remito) {
		this.remito = remito;
	}
	public List<FacturaItem> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(List<FacturaItem> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	

		// TODO Auto-generated method stub
		
	}
	
