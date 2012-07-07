package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import vistasbeans.RemitoClienteVista;
import vistasbeans.*;

@Entity
public class RemitoCliente extends Remito{
	@OneToOne
	@JoinColumn(name="FK_Cliente", referencedColumnName="IdCliente")
	private Cliente cliente;
	@OneToMany
	@JoinTable(name="Remito_OrdenPedido",
			joinColumns=@JoinColumn(name="FK_Remito", referencedColumnName="IdRemito"),
			inverseJoinColumns=@JoinColumn(name="FK_OrdenPedido", referencedColumnName="IdOrdenPedido")
	)			
	private List<OrdenPedido> ordenPedido;
	@Column (name="Estado de envio", nullable=false)
	private String estado;

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<OrdenPedido> getOrdenPedido() {
		return ordenPedido;
	}
	public void setOrdenPedido(List<OrdenPedido> ordenPedido) {
		this.ordenPedido = ordenPedido;
	}
	public boolean sosRemitoCliente(int nro) {
			return (nro == this.nro);
	}
	
	public RemitoClienteVista vista(){
		
		return ( new RemitoClienteVista(fecha, items, nro, estadoEnvio, cliente, ordenPedido, estado));
	}	
	
	
	
}
