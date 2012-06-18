package vistasbeans;

import java.util.Date;
import java.util.Vector;

public class FacturaVista {

	private float descuentoContado; //decía int
	private Date fechaEmision;
	private Date fechaVencimiento;
	private FinanciacionVista financiacion;
	private int nro;
	private RemitoVista remito;
	private Vector<ItemCotizacionVista> itemsFactura;
	
}
