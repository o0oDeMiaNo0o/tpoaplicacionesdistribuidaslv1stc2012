package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class OrdenPedidoVista {

	private ClienteVista cliente;
	private Vector<CotizacionVista> cotizacion;
	private int descuentoContado;
	private Date fechaEmision;
	private FinanciacionVista fianciacion;
	private Vector<CotizacionProveedor> items;
	private int nro;
	private ODVVista odv;
	private String estado;
	private float estadoCompletitud;
}
