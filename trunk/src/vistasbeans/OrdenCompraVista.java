package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class OrdenCompraVista {

	private Date fechaEmision;
	private Vector<ItemCotizacionVista> items;
	private int nro;
	private Vector<OrdenPedidoVista> ordenPedidos;
	private ProveedorVista proveedor;
	private String estado;
	private float estadoCompletitud;
	
}
