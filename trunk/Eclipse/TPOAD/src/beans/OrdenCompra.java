package beans;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

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
	private String estado;
	private float estadoCompletitud;
	
}
