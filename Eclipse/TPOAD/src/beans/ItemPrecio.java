package beans;

import java.util.ArrayList;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="ListaPrecioItem")
public class ItemPrecio {
	@Id @Column(name="IdItemPrecio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private int cantidad;
	private float precioCosto;
	private float precioVenta;
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
	public float getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	
	
}
