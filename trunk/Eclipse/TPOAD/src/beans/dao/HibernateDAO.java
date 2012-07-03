package beans.dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Cliente;
import beans.ItemStock;
import beans.ListaPrecio;
import beans.Proveedor;
import beans.Rodamiento;

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
		Query q = session.createQuery("from ItemStock s where s.id = ?");
		q.setInteger(0, id);
		retVal = (ItemStock) q.uniqueResult();
		session.close();
		return retVal;
	}		

	@SuppressWarnings("unchecked")
	public Rodamiento getRodamiento(int id){
		Session session = getSession();
		Rodamiento retVal = null;
		Query q = session.createQuery("from Rodamiento r where r.id = ?");
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
	
	
	//CU_06 and CU_08
	public void grabarCliente(Cliente c) {
		Session session= getSession();
		session.beginTransaction();
		session.persist(c);
		session.flush();
		session.beginTransaction().commit();
		
	}


	@SuppressWarnings("unchecked")
	public Cliente devolverCliente(String cuit) {
		Session session = getSession();
		List<Cliente> cliente = null;
		Query q = session.createQuery("from Clientes where cuit=?");//ver esto
		cliente=q.list();
		session.close();
		return cliente.get(0);
	}

	public void grabarProveedor(Proveedor p) {
		Session session= getSession();
		session.beginTransaction();
		session.persist(p);
		session.flush();
		session.beginTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	public Proveedor devolverProveedor(String razonSocial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Proveedor> proveedor = null;
		Query q = session.createQuery("from Proveedores where razonSocial=?");//ver esto
		proveedor=q.list();
		session.close();
		return proveedor.get(0);
	}
	//END 06/08

	/* CU09 - ABM */
	@SuppressWarnings("unchecked")
	public List<Proveedor> getProveedor(){
		Session session = getSession();
		List<Proveedor> retVal = null;
		Query q = session.createQuery("from Proveedor");
		retVal = q.list();
		session.close();
		return retVal;
	}	
	
	@SuppressWarnings("unchecked")
	public Proveedor getProveedor(int id){
		Session session = getSession();
		Proveedor retVal = null;
		Query q = session.createQuery("from Proveedor p where p.nro = ?");
		q.setInteger(0, id);
		retVal = (Proveedor) q.uniqueResult();
		session.close();
		return retVal;
	}	
	
	public int grabarListaPrecio(ListaPrecio l){
		Session session = getSession();
		session.beginTransaction();
		int retVal = (Integer) session.save(l);
		session.flush();
		session.beginTransaction().commit();
		return retVal;
	}
	
	public void actualizarProveedor(Proveedor p){
		Session session = getSession();
		session.beginTransaction();
		session.update(p);
		session.flush();
		session.beginTransaction().commit();
	}	
	
	/* FIN CU09 - ABM */
	
	/* COMPARATIVA DE PRECIO */
	
	
	@SuppressWarnings("unchecked")
	public List <Object[]> comparativaDePrecio(String nroSerie, String marca, List <String> marcas, String origen){
		String sQuery = "select p, li, it, r from Proveedor p join p.listaPrecios li join li.items it join it.rodamiento r where li.id = " +
						"(select max(l.id) from Proveedor pr join pr.listaPrecios l where l.id = li.id) " +
						"and r.nroSerie = :nroSerie ";
		
		
		if(!marca.equals("") && !marcas.isEmpty()){ //Agrego la marca y su listado
			sQuery = sQuery +"and (r.marca = :marca or r.marca in (:marcas)) ";
		}else{
			if(!marca.equals("") && marcas.isEmpty()){ //Agrego la Marca
				sQuery = sQuery + "and r.marca = :marca ";
			}
			if(marca.equals("") && !marcas.isEmpty()){ //Agrego el listado de marcas
				sQuery = sQuery + "and r.marca in (:marcas) ";
			}
		}
		if(!origen.equals("")){ //Agrego el origen
			sQuery = sQuery + "and origen = :origen ";			
		}

		
		Session session = getSession();
		List <Object[]> retVal = null;
		Query q = session.createQuery(sQuery);
		
		
		q.setString("nroSerie", nroSerie);
		if(!marca.equals("") && !marcas.isEmpty()){ //Agrego la marca y su listado
			q.setString("marca", marca);
			q.setParameterList("marcas", marcas);
		}else{
			if(!marca.equals("") && marcas.isEmpty()){ //Agrego la Marca
				q.setString("marca", marca);
			}
			if(marca.equals("") && !marcas.isEmpty()){ //Agrego el listado de marcas
				q.setParameterList("marcas", marcas);
			}
		}		
		if(!origen.equals("")){ //Agrego el origen
			q.setString("origen", origen);
		}
		
		retVal = q.list();
		session.close();
		return retVal;		
	}
	
	/* FIN COMPARATIVA DE PRECIO */	
	
}
