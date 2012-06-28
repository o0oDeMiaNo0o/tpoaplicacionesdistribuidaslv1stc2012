package beans.srv;

import java.util.List;

import beans.Cliente;
import beans.ItemStock;
import beans.Proveedor;
import beans.Rodamiento;
import beans.dao.HibernateDAO;

public class ServicioDAO {
	private static HibernateDAO dao;
	static {
		dao = HibernateDAO.getInstancia();
	}
	
 /*CUO7 STOCK RODAMIENTOS */
	/*ABM STOCK RODAMIENTO*/	
	public ItemStock getItemStock(int id){
		return dao.getItemStock(id);
	}

	public Rodamiento getRodamiento(int id){
		return dao.getRodamiento(id);
	}
	/*BAJA LÓGICA ITEM STOCK DE RODAMIENTO*/
	public boolean updateEstadoItemStock(int id, String estado){
		return dao.updateEstadoItemStock(id, estado);
	}
	
	/*MODIFICACION DE ITEM STOCK DE RODAMIENTO*/
	public boolean updateItemStock(ItemStock i){
		if(dao.updateRodamiento(i.getRodamiento())){
			dao.updateItemStock(i);
			return true;
		}
		return false;
	}	
	
	public int grabarRodamiento(Rodamiento r){
		return dao.grabarRodamiento(r);
	}

	public int grabarItemStock(ItemStock i){
		return dao.grabarItemStock(i);
	}
	/*FIN ABM STOCK RODAMIENTO*/
	
	/*OLD*/
	public List<Rodamiento> getRodamientos(){
		return dao.getRodamientos();
	}
	
	public List<ItemStock> getItemStock(){
		return dao.getItemStock();
	}	
	
	//CU_06 and CU_08
		public void agregarCli(Cliente c) {
			dao.grabarCliente(c);
			
		}

		public Cliente getClient(String cuit) {
			return dao.devolverCliente(cuit);
		}

		public void agregarPro(Proveedor p) {
			dao.grabarProveedor(p);
			
		}

		public Proveedor getProveedor(String razonSocial) {
			return dao.devolverProveedor(razonSocial);
		}
		//END 06/08

}
