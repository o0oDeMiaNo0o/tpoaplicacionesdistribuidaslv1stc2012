package beans;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="OrdenPedidoItem")
public class OrdenPedidoItem {

	@Id @Column(name="IdOrdenPedidoItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private int cantidad;
	private float precio;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
	@OneToOne
	@JoinColumn(name="FK_Proveedor", referencedColumnName="IdProveedor")
	private Proveedor proveedor;
}