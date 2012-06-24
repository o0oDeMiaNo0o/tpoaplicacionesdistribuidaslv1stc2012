package beans.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.*;

import hbt.HibernateUtil;

public class HibernateDAO {
	private static HibernateDAO instancia = null;
	private static SessionFactory sf = null;
	private Session session;	

	public static HibernateDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateDAO();
		} 
		return instancia;
	}
	
	public Session getSession() {
		if(session == null || !session.isOpen()){
			session = sf.openSession();
		}
		return session;
	}	
	
   /*CUO7 STOCK RODAMIENTOS */
	/*ABM STOCK RODAMIENTOS*/
	@SuppressWarnings("unchecked")
	public ItemStock getItemStock(int id){
		Session session = getSession();
		ItemStock retVal = null;
		Query q = session.createQuery("from StockRodamiento s where s.IdStock = ?");
		q.setInteger(0, id);
		retVal = (ItemStock) q.uniqueResult();
		session.close();
		return retVal;
	}		

	@SuppressWarnings("unchecked")
	public Rodamiento getRodamiento(int id){
		Session session = getSession();
		Rodamiento retVal = null;
		Query q = session.createQuery("from Rodamiento r where r.IdRodamiento = ?");
		q.setInteger(0, id);
		retVal = (Rodamiento) q.uniqueResult();
		session.close();
		return retVal;
	}			
	
	public int grabarRodamiento(Rodamiento r){
		Session session = getSession();
		session.beginTransaction();
		int retVal = (Integer) session.save(r);
		session.flush();
		session.beginTransaction().commit();
		return retVal;
	}

	public int grabarItemStock(ItemStock i){
		Session session = getSession();
		session.beginTransaction();
		int retVal = (Integer) session.save(i);		
		session.flush();
		session.beginTransaction().commit();
		return retVal;
	}
	
	public boolean updateEstadoItemStock(int id, String estado){
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update ItemStock s set s.estado = ? where s.id = ?");
		q.setInteger(1, id);
		q.setString(0, estado);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}
	
	public boolean updateItemStock(ItemStock i){
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update ItemStock s set s.cantidad = ?, s.estado = ?, s.precioCosto = ?, s.precioVenta = ?, s.ultimaActualizacion = ? where s.id = ?");
		q.setInteger(0, i.getCantidad());
		q.setString(1, i.getEstado());
		q.setFloat(2, i.getPrecioCosto());
		q.setFloat(3, i.getPrecioVenta());	
		q.setDate(4, i.getUltimaActualizacion());
		q.setInteger(5, i.getId());
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}
	
	public boolean updateRodamiento(Rodamiento r){
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update Rodamiento r set r.codigo = ?, r.marca = ?, r.nroSerie = ?, r.origen = ?, r.sufijo = ? where r.id = ?");
		q.setString(0,r.getCodigo());
		q.setString(1,r.getMarca());
		q.setString(2,r.getNroSerie());
		q.setString(3,r.getOrigen());
		q.setString(4,r.getSufijo());
		q.setInteger(5,r.getId());
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}	
	/*FIN ABM STOCK RODAMIENTOS*/
	
	/*OLD*/
	@SuppressWarnings("unchecked")
	public List<Rodamiento> getRodamientos(){
		Session session = getSession();
		List<Rodamiento> retVal = null;
		Query q = session.createQuery("from Rodamiento");
		retVal = q.list();
		session.close();
		return retVal;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemStock> getItemStock(){
		Session session = getSession();
		List<ItemStock> retVal = null;
		Query q = session.createQuery("from StockRodamiento");
		retVal = q.list();
		session.close();
		return retVal;
	}	  
	
}
