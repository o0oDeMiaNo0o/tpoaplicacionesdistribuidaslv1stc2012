package beans;

import javax.persistence.*;

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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	
}
