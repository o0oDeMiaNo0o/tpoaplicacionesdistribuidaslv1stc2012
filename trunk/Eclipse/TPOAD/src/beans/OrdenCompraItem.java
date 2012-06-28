package beans;

import javax.persistence.*;

@Entity
@Table(name="OrdenCompraItem")
public class OrdenCompraItem {
	@Id @Column(name="IdOrdenCompraItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int id;
	private int cantidad;
	private float precio;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
}