package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	
	
	
}
