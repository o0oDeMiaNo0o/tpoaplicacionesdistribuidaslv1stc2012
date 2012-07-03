package vistasbeans;

import java.io.Serializable;
import java.util.List;

public class ProveedorVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String direccion;
	private List<ListaPrecioVista> listaPrecios;
	private int nro;
	private String razonSocial;
	private String telefono;
	private String estado;

	public String getEstado() {
		return estado;
	}	
	public ProveedorVista(String dir, List <ListaPrecioVista> lp, int nro, String rz, String tel ){
		this.direccion = dir;
		this.listaPrecios = lp;
		this.nro = nro;
		this.razonSocial = rz;
		this.telefono = tel;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<ListaPrecioVista> getListaPrecios() {
		return listaPrecios;
	}

	public int getNro() {
		return nro;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getTelefono() {
		return telefono;
	}
}
