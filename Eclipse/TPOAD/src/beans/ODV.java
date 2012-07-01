package beans;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="ODV")
public class ODV {

	private String direccion;
	private String responsable;
	@Id @Column(name="IdODV")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdODV;
	
}
