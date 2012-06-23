package beans;

import javax.persistence.*;

@Entity
public class RemitoProveedor extends Remito{

	@OneToOne
	@JoinColumn(name="FK_OrdenCompra", referencedColumnName="IdOrdenCompra")	
	private OrdenCompra ordenCompra;
	@OneToOne
	@JoinColumn(name="FK_Proveedor", referencedColumnName="IdProveedor")	
	private Proveedor proveedor;
}
