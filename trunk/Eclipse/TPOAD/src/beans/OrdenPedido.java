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
}
