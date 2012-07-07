package beans;

import javax.persistence.*;

@Entity
@Table(name="ODV")
public class ODV {

	@Id @Column(name="IdODV")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdODV;
	@Column (name="Direccion")
	private String direccion;
	@Column (name="responsable")
	private String responsable;
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public int getIdODV() {
		return IdODV;
	}
	public void setIdODV(int idODV) {
		IdODV = idODV;
	}
	
	
}
