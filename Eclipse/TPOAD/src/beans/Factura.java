package beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Factura")
public class Factura {
	@Id @Column(name="IdFactura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;	
	private float descuentoContado;
	private Date fechaEmision;
	private Date fechaVencimiento;
	@OneToOne
	@JoinColumn(name="FK_Financiacion", referencedColumnName="IdFinanciacion")
	private Financiacion financiacion;
	@OneToOne
	@JoinColumn(name="FK_Remito", referencedColumnName="IdRemito")
	private Remito remito;
	@OneToMany
	@JoinColumn(name="FK_Factura", referencedColumnName="IdFactura")	
	private List<FacturaItem> itemsFactura;
	
}
