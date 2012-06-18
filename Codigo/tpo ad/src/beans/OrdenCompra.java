package beans;

import java.util.Date;
import java.util.Vector;

public class OrdenCompra {

	private Date fechaEmision;
	private Vector<ItemCotizacion> items;
	private int nro;
	private Vector<OrdenPedido> ordenPedidos;
	private Proveedor proveedor;
	private String estado;
	private float estadoCompletitud;
	
}
