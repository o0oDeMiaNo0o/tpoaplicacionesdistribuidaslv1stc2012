package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="OrdenPedido")
public class OrdenPedido {

	@Id @Column(name="IdOrdenPedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;
	
	@OneToOne
	@JoinColumn(name="FK_Cliente", referencedColumnName="IdCliente")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name="FK_Financiacion", referencedColumnName="IdFinanciacion")
	private Financiacion fianciacion;

	@OneToOne
	@JoinColumn(name="FK_ODV", referencedColumnName="IdODV")
	private ODV odv;	
	
	@OneToMany
	@JoinColumn(name="FK_OrdenPedido", referencedColumnName="IdOrdenPedido")
	private List<OrdenPedidoItem> items;
	
	private float estadoCompletitud;
	private int descuentoContado;
	private Date fechaEmision;	
	
	@OneToMany
	@JoinTable(name="OrdenPedido_Cotizacion",
			joinColumns=@JoinColumn(name="FK_OrdenPedido", referencedColumnName="IdOrdenPedido"),
			inverseJoinColumns=@JoinColumn(name="FK_Cotizacion", referencedColumnName="IdCotizacion")
	)
	private List<Cotizacion> cotizacion;
	private String estado;
	private String origen;

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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Financiacion getFianciacion() {
		return fianciacion;
	}
	public void setFianciacion(Financiacion fianciacion) {
		this.fianciacion = fianciacion;
	}
	public ODV getOdv() {
		return odv;
	}
	public void setOdv(ODV odv) {
		this.odv = odv;
	}
	public List<OrdenPedidoItem> getItems() {
		return items;
	}
	public void setItems(List<OrdenPedidoItem> items) {
		this.items = items;
	}
	public float getEstadoCompletitud() {
		return estadoCompletitud;
	}
	public void setEstadoCompletitud(float estadoCompletitud) {
		this.estadoCompletitud = estadoCompletitud;
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
	public List<Cotizacion> getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(List<Cotizacion> cotizacion) {
		this.cotizacion = cotizacion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
}
