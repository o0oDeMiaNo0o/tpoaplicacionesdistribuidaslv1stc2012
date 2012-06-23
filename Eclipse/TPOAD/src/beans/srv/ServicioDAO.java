package beans.srv;

import java.util.List;
import beans.ItemStock;
import beans.Rodamiento;
import beans.dao.HibernateDAO;

public class ServicioDAO {
	private static HibernateDAO dao;
	static {
		dao = HibernateDAO.getInstancia();
	}
	
	public List<Rodamiento> getRodamientos(){
		return dao.getRodamientos();
	}
	
	public void grabarRodamiento(Rodamiento r){
		dao.grabarRodamiento(r);
	}

	public void grabarItemStock(ItemStock i){
		dao.grabarItemStock(i);
	}	
	
}
