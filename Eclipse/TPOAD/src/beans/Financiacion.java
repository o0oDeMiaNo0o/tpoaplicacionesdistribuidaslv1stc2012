package beans;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="Financiacion")
public class Financiacion {
	@Id @Column(name="IdFinanciacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private int cuotas;
	private float recargo; //creo que un float quedaría mejor
}
