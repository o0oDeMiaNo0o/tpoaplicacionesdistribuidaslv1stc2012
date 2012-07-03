package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class RemitoVista {

	private Date fecha;
	private Vector<RemitoItemVista> items;
	private int nro;
	private String estadoEnvio;
	public Date getFecha() {
		return fecha;
	}
	public void setFechaEmision(Date fecha) {
		this.fecha = fecha;
	}
	public Vector<RemitoItemVista> getItems() {
		return items;
	}
	public void setItems(Vector<RemitoItemVista> items) {
		this.items = items;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getEstadoEnvio() {
		return estadoEnvio;
	}
	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}
	
	
}
