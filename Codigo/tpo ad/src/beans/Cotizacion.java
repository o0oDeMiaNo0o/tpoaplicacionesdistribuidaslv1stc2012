package beans;

import java.util.Date;
import java.util.Vector;

public class Cotizacion {

	private Cliente cliente;
	private float descuentoContado; //creo que debería ser float
	private int diasVigencia;
	private Date fechaEmision;
	private Vector<Financiacion> financiacion;
	private Vector<CotizacionProveedor> items;
	private int nro;
	private Vector<SolicitudCotizacion> solicitudes;
	private String estado;
}
