package vistasbeans;

import java.util.Vector;

import beans.Cliente;

public class RemitoClienteVista extends RemitoVista{

	private ClienteVista cliente;
	private Vector<OrdenPedidoVista> ordenPedido;
	public ClienteVista getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVista cliente) {
		this.cliente = cliente;
	}
	public Vector<OrdenPedidoVista> getOrdenPedido() {
		return ordenPedido;
	}
	public void setOrdenPedido(Vector<OrdenPedidoVista> ordenPedido) {
		this.ordenPedido = ordenPedido;
	}
	
	
	
}

