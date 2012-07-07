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
