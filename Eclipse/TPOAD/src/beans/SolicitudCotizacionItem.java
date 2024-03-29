package beans;

import javax.persistence.*;

import vistasbeans.SolicitudCotizacionItemVista;

@Entity
@Table(name="SolicitudCotizacionItem")
public class SolicitudCotizacionItem {
	
	@Id @Column(name="IdSolicitudCotizacionItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
	private String estado;

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}	
	public SolicitudCotizacionItemVista getVista(){
		SolicitudCotizacionItemVista vista= new SolicitudCotizacionItemVista();
		vista.setCantidad(cantidad);
		vista.setRodamiento(rodamiento.getVista());
		return vista;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	
	
}