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
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<RemitoItem> getItems() {
		return items;
	}
	public void setItems(List<RemitoItem> items) {
		this.items = items;
	}
	public String getEstadoEnvio() {
		return estadoEnvio;
	}
	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}
	
	
}
