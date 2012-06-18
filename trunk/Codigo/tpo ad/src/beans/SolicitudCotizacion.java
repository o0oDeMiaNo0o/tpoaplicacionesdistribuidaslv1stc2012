package beans;

import java.util.Date;
import java.util.Vector;

public class SolicitudCotizacion {

	private Cliente cliente;
	private Date fechaEmision;
	private Vector<ItemCantidad> items;
	private int nro;
	private String estado;
}
