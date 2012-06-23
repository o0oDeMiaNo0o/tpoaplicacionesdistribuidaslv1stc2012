package beans;

import javax.persistence.*;

@Entity
@Table(name="ListaPrecioItem")
public class ItemPrecio {
	@Id @Column(name="IdItemPrecio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private int cantidad;
	private float precioCosto;
	private float precioVenta;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
	
}
