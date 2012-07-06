package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="OrdenCompra")
public class OrdenCompra {
	@Id @Column(name="IdOrdenCompra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int nro;
	private Date fechaEmision;
	@OneToMany
	@JoinColumn(name="FK_OrdenCompra", referencedColumnName="IdOrdenCompra")
	private List<OrdenCompraItem> items;
	@OneToMany
	@JoinTable(name="OrdenCompra_OrdenPedido",
			joinColumns=@JoinColumn(name="FK_OrdenCompra", referencedColumnName="IdOrdenCompra"),
			inverseJoinColumns=@JoinColumn(name="FK_OrdenPedido", referencedColumnName="IdOrdenPedido")
	)	
	private List<OrdenPedido> ordenPedidos;
	@OneToOne
	@JoinColumn(name="FK_Proveedor", referencedColumnName="IdProveedor")
	private Proveedor proveedor;
	private float estadoCompletitud;
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
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public List<OrdenCompraItem> getItems() {
		return items;
	}
	public void setItems(List<OrdenCompraItem> items) {
		this.items = items;
	}
	public List<OrdenPedido> getOrdenPedidos() {
		return ordenPedidos;
	}
	public void setOrdenPedidos(List<OrdenPedido> ordenPedidos) {
		this.ordenPedidos = ordenPedidos;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public float getEstadoCompletitud() {
		return estadoCompletitud;
	}
	public void setEstadoCompletitud(float estadoCompletitud) {
		this.estadoCompletitud = estadoCompletitud;
	}
	
}
