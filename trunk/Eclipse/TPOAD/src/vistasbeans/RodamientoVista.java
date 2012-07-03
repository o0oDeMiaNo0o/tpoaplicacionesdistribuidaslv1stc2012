package vistasbeans;

import java.io.Serializable;

public class RodamientoVista  implements Serializable {

	private int id;
	private String codigo; //creo que por ahí debería ser un string
	private String marca;
	private String nroSerie;
	private String origen;
	private String sufijo;
	
	public RodamientoVista(int id, String codigo, String marca, String nroSerie, String origen, String sufijo){
		this.id = id;
		this.codigo = codigo;
		this.marca = marca;
		this.nroSerie = nroSerie;
		this.origen = origen;
		this.sufijo = sufijo;
	}
	
	public RodamientoVista(){
		
	}		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getSufijo() {
		return sufijo;
	}
	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}
}
