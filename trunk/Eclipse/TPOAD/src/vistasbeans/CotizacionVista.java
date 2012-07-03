package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class CotizacionVista {

	private ClienteVista cliente;
	private float descuentoContado; //creo que debería ser float
	private int diasVigencia;
	private Date fechaEmision;
	private Vector<FinanciacionVista> financiacion;
	private Vector<CotizacionProveedor> items;
	private int nro;
	private Vector<SolicitudCotizacionVista> solicitudes;
	private String estado;

	public String getEstado() {
		return estado;
	}
}
