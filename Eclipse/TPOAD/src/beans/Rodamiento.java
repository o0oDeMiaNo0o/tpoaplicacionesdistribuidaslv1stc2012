package beans;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import vistasbeans.RodamientoVista;

@Entity
@Table(name="Rodamiento")
public class Rodamiento {
	@Id @Column(name="IdRodamiento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String codigo; //creo que por ahí debería ser un string
	private String marca;
	private String nroSerie;
	private String origen;
	private String sufijo;
	
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
	public boolean sosRodamiento(int id){
		return (id == this.id);
	}
	
	public RodamientoVista getVista(){
		RodamientoVista vista = new RodamientoVista();
		vista.setCodigo(codigo);
		vista.setId(id);
		vista.setMarca(marca);
		vista.setNroSerie(nroSerie);
		vista.setOrigen(origen);
		vista.setSufijo(sufijo);
		return vista;
	}
	
}
