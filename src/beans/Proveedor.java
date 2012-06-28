package beans;

import java.util.List;

//import java.util.Vector;
import javax.persistence.*;

@Entity
@Table(name="Proveedor")
public class Proveedor {

	@Id @Column(name="IdProveedor") // no habira que agregar que sea autoincremente 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;
	private String direccion;
	@OneToMany
	@JoinColumn(name="FK_Proveedor", referencedColumnName="IdProveedor")
	private List<ListaPrecio> listaPrecios;
	private String razonSocial;
	private String telefono;
	
	private String estado;
	
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getNro() {
		return nro;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<ListaPrecio> getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(List<ListaPrecio> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
