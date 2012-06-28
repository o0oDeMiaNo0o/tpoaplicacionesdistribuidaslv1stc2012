package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FacturaItem")
public class FacturaItem {
	@Id @Column(name="IdFacturaItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int id;
	private int cantidad;
	private float precio;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
}
