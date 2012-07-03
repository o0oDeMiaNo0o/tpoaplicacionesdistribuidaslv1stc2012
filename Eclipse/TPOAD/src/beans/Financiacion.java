package beans;

import javax.persistence.*;

import vistasbeans.FinanciacionVista;

@Entity
@Table(name="Financiacion")
public class Financiacion {
	@Id @Column(name="IdFinanciacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private int cuotas;
	private float recargo; //creo que un float quedaría mejor

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public float getRecargo() {
		return recargo;
	}
	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}
	
	public FinanciacionVista vista(){
		return (new FinanciacionVista(id, cuotas, recargo));
	}
}
