package beans;

import java.util.Date;
import java.util.Vector;

public class OrdenPedido {

	private Cliente cliente;
	private Vector<Cotizacion> cotizacion;
	private int descuentoContado;
	private Date fechaEmision;
	private Financiacion fianciacion;
	private Vector<CotizacionProveedor> items;
	private int nro;
	private ODV odv;
	private String estado;
	private float estadoCompletitud;
}
