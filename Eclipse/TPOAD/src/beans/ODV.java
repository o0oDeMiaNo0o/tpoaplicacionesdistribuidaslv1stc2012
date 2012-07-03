package beans;

import javax.persistence.*;

@Entity
@Table(name="ODV")
public class ODV {

	private String direccion;
	private String responsable;
	@Id @Column(name="IdODV")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdODV;
	
}
