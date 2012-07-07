package beans;

import javax.persistence.*;

@Entity
@Table(name="OrdenCompraItem")
public class OrdenCompraItem {
	@Id @Column(name="IdOrdenCompraItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private int id;
	@Column (name="Cantidad")
	private int cantidad;
	@Column (name = "Precio")
	private float precio;
	@OneToOne
	@JoinColumn(name="FK_Rodamiento", referencedColumnName="IdRodamiento")
	private Rodamiento rodamiento;
	@Column (name="Estado")
	private String estado;

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
