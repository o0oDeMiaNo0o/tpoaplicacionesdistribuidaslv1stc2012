package vistasbeans;

import java.io.Serializable;

public class FinanciacionVista implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;	
	private int cuotas;
	private float recargo; //creo que un float quedaría mejor
	
	public FinanciacionVista(int id, int cuotas, float recargo){
		this.id = id;
		this.cuotas = cuotas;
		this.recargo = recargo;
	}

	public int getId() {
		return id;
	}

	public int getCuotas() {
		return cuotas;
	}

	public float getRecargo() {
		return recargo;
	}
	
}
