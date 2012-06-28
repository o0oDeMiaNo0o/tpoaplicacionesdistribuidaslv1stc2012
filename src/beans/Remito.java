package beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Remito")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Remito {
	@Id @Column(name="IdRemito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected int nro;
	protected Date fecha;
	@OneToMany
	@JoinColumn(name="FK_Remito", referencedColumnName="IdRemito")
	protected List<RemitoItem> items;
	protected String estadoEnvio;
}
