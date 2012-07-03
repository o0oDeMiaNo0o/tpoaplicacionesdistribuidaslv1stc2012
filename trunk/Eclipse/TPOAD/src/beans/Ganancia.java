package beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Ganancia")
public class Ganancia {
	
	@Id @Column(name="IdGanancia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float ganancia;
	private float promedioVentas;
	private Date fechaCambio;
	private String motivo;
	private String estado;
	
}