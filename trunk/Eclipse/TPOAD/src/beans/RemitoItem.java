package beans;

import javax.persistence.*;

@Entity
@Table(name="RemitoItem")
public class RemitoItem {
	
	@Id @Column(name="IdRemitoItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
}