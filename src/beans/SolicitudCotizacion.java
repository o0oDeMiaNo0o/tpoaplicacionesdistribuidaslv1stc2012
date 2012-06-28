package beans;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.*;

import vistasbeans.ItemCantidadVista;
import vistasbeans.SolicitudCotizacionItemVista;
import vistasbeans.SolicitudCotizacionVista;

@Entity
@Table(name="SolicitudCotizacion")
public class SolicitudCotizacion {

	@Id @Column(name="IdSolicitudCotizacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nro;
	@OneToOne
	@JoinColumn(name="FK_Cliente", referencedColumnName="IdCliente")
	private Cliente cliente;
	private Date fechaEmision;
	@OneToMany
	@JoinColumn(name="FK_SolicitudCotizacion", referencedColumnName="IdSolicitudCotizacion")
	private List<SolicitudCotizacionItem> items;
	private String estado;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public List<SolicitudCotizacionItem> getItems() {
		return items;
	}
	public void setItems(Vector<SolicitudCotizacionItem> items) {
		this.items = items;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public SolicitudCotizacionVista getVista(){
		SolicitudCotizacionVista vista=new SolicitudCotizacionVista();
		vista.setCliente(cliente.getVista());
		vista.setEstado(estado);
		vista.setFechaEmision(fechaEmision);
		Vector<SolicitudCotizacionItemVista> itemsvista=new Vector<SolicitudCotizacionItemVista>();
		for(SolicitudCotizacionItem i : items){
			itemsvista.add(i.getVista());
			//itemsvista.add(i.getVista());			
		}		
		vista.setItems(itemsvista);
		vista.setNro(nro);
		
		return vista;
	}
}
