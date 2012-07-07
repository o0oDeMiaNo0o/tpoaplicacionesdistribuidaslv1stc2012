package vistasbeans;

import java.util.Date;
import java.util.Vector;

import beans.Cliente;

public class RemitoClienteVista extends RemitoVista{

	private ClienteVista cliente;
	private Vector<OrdenPedidoVista> ordenPedido;
	private String estado;

	
	
	
	public RemitoClienteVista(Date fecha, Vector<RemitoItemVista> items, int nro,
			String estadoEnvio, ClienteVista cliente,
			Vector<OrdenPedidoVista> ordenPedido, String estado) {
		super(fecha, items, nro, estadoEnvio);
		this.cliente = cliente;
		this.ordenPedido = ordenPedido;
		this.estado = estado;
	}
	
	public RemitoClienteVista() {
		super();
	}
	public String getEstado() {
		return estado;
	}
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

