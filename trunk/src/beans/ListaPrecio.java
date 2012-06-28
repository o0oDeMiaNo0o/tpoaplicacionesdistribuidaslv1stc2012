package beans;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.*;

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
	
}
