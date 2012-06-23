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
	
	@SuppressWarnings("unchecked")
	public List<Rodamiento> getRodamientos(){
		Session session = getSession();
		List<Rodamiento> retVal = null;
		Query q = session.createQuery("from Rodamiento");
		retVal = q.list();
		session.close();
		return retVal;
	}
	
	public void grabarRodamiento(Rodamiento r){
		Session session = getSession();
		session.beginTransaction();
		session.persist(r);
		session.flush();
		session.beginTransaction().commit();
	}

	public void grabarItemStock(ItemStock i){
		Session session = getSession();
		session.beginTransaction();
		session.persist(i);
		session.flush();
		session.beginTransaction().commit();
	}	
	
}
