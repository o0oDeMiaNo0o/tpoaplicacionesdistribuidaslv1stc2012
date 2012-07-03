package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Cotizacion")
public class Cotizacion {

	@Id @Column(name="IdCotizacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int nro;	
	@OneToOne
	@JoinColumn(name="FK_Cliente", referencedColumnName="IdCliente")
	private Cliente cliente;
	private float descuentoContado; //creo que debería ser float
	private int diasVigencia;
	private Date fechaEmision;
	@OneToMany
	@JoinTable(name="FinanciacionCotizacion",
			joinColumns={@JoinColumn(name="Fk_Cotización")},
			inverseJoinColumns={@JoinColumn(name="Fk_Financiacion")}
			)
	private List<Financiacion> financiacion;
	
	@OneToMany
	@JoinColumn(name="FK_Cotizacion", referencedColumnName="IdCotizacion")
	private List<CotizacionItem> items;
	
	@OneToMany
	@JoinTable(name="Cotizacion_Solicitudes",
			joinColumns=@JoinColumn(name="FK_Cotizacion", referencedColumnName="IdCotizacion"),
			inverseJoinColumns=@JoinColumn(name="FK_SolicitudCotizacion", referencedColumnName="IdSolicitudCotizacion")
	)
	private List<SolicitudCotizacion> solicitudes;
	private String estado;

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
