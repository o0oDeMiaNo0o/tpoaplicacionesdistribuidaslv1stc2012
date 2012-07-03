package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

import vistasbeans.FacturaItemVista;
import vistasbeans.ItemPrecioVista;
import vistasbeans.ListaPrecioVista;
import vistasbeans.ProveedorVista;

@Entity
@Table(name="Proveedor")
public class Proveedor {

	@Id @Column(name="IdProveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;
	private String direccion;
	@OneToMany
	@JoinColumn(name="FK_Proveedor", referencedColumnName="IdProveedor")
	private List<ListaPrecio> listaPrecios;
	private String razonSocial;
	private String telefono;
	private ArrayList<Rodamiento> rodamientos;
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
	public void setNro(int nro) {
		this.nro = nro;
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
	
	public boolean sosProveedor(int id){
		return (id == this.nro);
	}	
	
	/* TODO :: CU09 - Administrar listas de precios de proveedores ::*/
	public void nuevaListaPrecioProveedor(ListaPrecioVista vista){ 
		ListaPrecio listaPrecioProveedor = new ListaPrecio();
		listaPrecioProveedor.setNro(vista.getNro());
		listaPrecioProveedor.setFechaEmision(vista.getFechaEmision());
		listaPrecioProveedor.setFechaVencimiento(vista.getFechaVencimiento());
		listaPrecioProveedor.setDescuentoContado(vista.getDescuentoContado());
		//listaPrecioProveedor.setFinanciacion(vista.getFinanciacion());
		listaPrecioProveedor.setNroListReemplazo(vista.getNroListReemplazo());
		//listaPrecioProveedor.setItems(generarItemsLista (vista.getItems()));
		listaPrecios.add(listaPrecioProveedor);
		
	}
	private List<ItemPrecio> generarItemsLista(Vector<ItemPrecioVista> itemsPrecioVista) {
		Vector<ItemPrecio> itemsLista = new Vector<ItemPrecio>();
		for(ItemPrecioVista vista: itemsPrecioVista){
			ItemPrecio item=new ItemPrecio();
			item.setId(vista.getId());
			item.setCantidad(vista.getCantidad());
			item.setPrecioCosto(vista.getPrecioCosto());
			item.setPrecioVenta (vista.getPrecioVenta());
			item.setRodamiento(buscarRodamiento(vista.getRodamiento().getCodigo()));
			itemsLista.add(item);
		}		
		return itemsLista;
	}


		public Rodamiento buscarRodamiento(String codigo){
			Rodamiento r=null;
			for(Rodamiento aux : rodamientos){
				if(aux.getCodigo()==codigo){
					r=aux;
					break;
				}
			}
			return r;		
		}
	
		public void agregarListadoPrecio(ListaPrecio l){
			if(!ArrayList.class.isInstance(listaPrecios)){
				listaPrecios = new ArrayList<ListaPrecio>();
			}
			this.listaPrecios.add(l);
		}

		public ProveedorVista vista(){
			List<ListaPrecioVista> lp = new ArrayList<ListaPrecioVista>();
			for(ListaPrecio l:listaPrecios){
				lp.add(l.vista());
			}
			return (new ProveedorVista(direccion, lp, nro, razonSocial, telefono));
		}
}
