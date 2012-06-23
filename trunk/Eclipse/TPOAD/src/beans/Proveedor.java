package beans;

import java.util.List;
import java.util.Vector;
import javax.persistence.*;

@Entity
@Table(name="Proveedor")
public class Proveedor {

	@Id @Column(name="IdProveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;
	private String direccion;
	@OneToMany
	@JoinColumn(name="FK_Proveedor", referencedColumnName="IdProveedor")
	private List<ListaPrecio> listaPrecios;
	private String razonSocial;
	private String telefono;
}
