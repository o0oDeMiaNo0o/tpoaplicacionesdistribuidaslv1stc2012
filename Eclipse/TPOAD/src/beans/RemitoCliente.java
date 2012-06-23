package beans;

import java.util.List;
import javax.persistence.*;

@Entity
public class RemitoCliente extends Remito{
	@OneToOne
	@JoinColumn(name="FK_Cliente", referencedColumnName="IdCliente")
	private Cliente cliente;
	@OneToMany
	@JoinTable(name="Remito_OrdenPedido",
			joinColumns=@JoinColumn(name="FK_Remito", referencedColumnName="IdRemito"),
			inverseJoinColumns=@JoinColumn(name="FK_OrdenPedido", referencedColumnName="IdOrdenPedido")
	)			
	private List<OrdenPedido> ordenPedido;
}
