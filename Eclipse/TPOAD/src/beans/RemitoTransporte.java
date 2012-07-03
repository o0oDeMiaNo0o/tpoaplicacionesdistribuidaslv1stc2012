package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class RemitoTransporte extends Remito{

	@OneToOne
	@JoinColumn(name="FK_ODV", referencedColumnName="IdODV")		
	private ODV odv;
	@OneToMany
	@JoinTable(name="Remito_OrdenPedido",
			joinColumns=@JoinColumn(name="FK_Remito", referencedColumnName="IdRemito"),
			inverseJoinColumns=@JoinColumn(name="FK_OrdenPedido", referencedColumnName="IdOrdenPedido")
	)		
	private List<OrdenPedido> ordenPedido;
}
