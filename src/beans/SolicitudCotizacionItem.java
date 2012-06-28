package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import vistasbeans.ItemCantidadVista;
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