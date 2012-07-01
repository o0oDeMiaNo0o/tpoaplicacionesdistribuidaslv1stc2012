package beans;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="CotizacionItem")
public class CotizacionItem {

	@Id @Column(name="IdCotizacionItem")
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