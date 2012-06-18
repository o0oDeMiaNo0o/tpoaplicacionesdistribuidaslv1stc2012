package beans;

import java.util.Date;
import java.util.Vector;

public class Factura {

	private float descuentoContado; //decía int
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Financiacion financiacion;
	private int nro;
	private Remito remito;
	private Vector<ItemCotizacion> itemsFactura;
	
}
