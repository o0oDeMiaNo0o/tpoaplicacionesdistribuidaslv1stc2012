package beans.dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Cliente;
import beans.Factura;
import beans.ItemStock;
import beans.ListaPrecio;
import beans.ODV;
import beans.OrdenCompra;
import beans.OrdenPedido;
import beans.OrdenPedidoItem;
import beans.Proveedor;
import beans.Remito;
import beans.RemitoCliente;
import beans.RemitoItem;
import beans.RemitoProveedor;
import beans.RemitoTransporte;
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

	public boolean updateEstadoItemStock(int id, String estado){
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update StockRdamient s set s.estado = ? where s.id = ?");
		q.setInteger(1, id);
		q.setString(0, estado);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}
	
	public boolean updateItemStock(ItemStock i){
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update Stock s set s.cantidad = ?, s.estado = ?, s.precioCosto = ?, s.precioVenta = ?, s.ultimaActualizacion = ? where s.id = ?");
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
	

	
	
	@SuppressWarnings("unchecked")
	public List <ItemPrecio> comparativaDePrecio(String nroSerie, String marca, List <String> marcas, String origen){
	  //Mirar
	}
	

	
	/* Obtener ODV */
	@SuppressWarnings("unchecked")
	public ODV devolverODV(int idODV) {
		Session session = getSession();
		ODV odv = null;
		Query q = session.createQuery("from ODV where IdODV=?");
		q.setInteger(0, idODV);
		odv = (ODV) q.uniqueResult();
		session.close();
		return odv;
	}

	public int grabarRemitoCliente(RemitoCliente remitoCl) {
			Session session = getSession();
			session.beginTransaction();
			int retVal = (Integer) session.save(remitoCl);
			session.flush();
			session.beginTransaction().commit();
			return retVal;
		}

	@SuppressWarnings("unchecked")
	public List<RemitoCliente> getRemitoCl() {
			Session session = getSession();
			List<RemitoCliente> retVal = null;
			Query q = session.createQuery("from Remito r Where e.Cliente not Null");
			retVal = q.list();
			session.close();
			return retVal;
		}
	
	@SuppressWarnings("unchecked")
	public List<RemitoProveedor> getRemitoPrv() {
		Session session = getSession();
		List<RemitoProveedor> retVal = null;
		Query q = session.createQuery("from Remito r Where e.Proveedor not Null");
		retVal = q.list();
		session.close();
		return retVal;
	}

	public List<RemitoTransporte> getRemitoTpte() {
		Session session = getSession();
		List<RemitoTransporte> retVal = null;
		Query q = session.createQuery("from Remito r Where e.ODV not Null");
		retVal = q.list();
		session.close();
		return retVal;
	}

	public Remito getUniqueRemito(int nroRemito) {
		Session session = getSession();
		Remito rmt = null;
		Query q = session.createQuery("from Remito where nro=?");
		q.setInteger(0, nroRemito);
		rmt = (Remito) q.uniqueResult();
		session.close();
		return rmt;
	}

	public RemitoCliente getUniqueRemitoC(int nroRemito) {
		Session session = getSession();
		RemitoCliente rmt = null;
		Query q = session.createQuery("from Remito where nro=?");
		q.setInteger(0, nroRemito);
		rmt = (RemitoCliente) q.uniqueResult();
		session.close();
		return rmt;
	}

	public RemitoTransporte getUniqueRemitoT(int nroRemito) {
		Session session = getSession();
		RemitoTransporte rmt = null;
		Query q = session.createQuery("from Remito where nro=?");
		q.setInteger(0, nroRemito);
		rmt = (RemitoTransporte) q.uniqueResult();
		session.close();
		return rmt;
	}

	public RemitoProveedor getUniqueRemitoP(int nroRemito) {
		Session session = getSession();
		RemitoProveedor rmt = null;
		Query q = session.createQuery("from Remito where nro=?");
		q.setInteger(0, nroRemito);
		rmt = (RemitoProveedor) q.uniqueResult();
		session.close();
		return rmt;
	}

	public int grabarItenStock(RemitoItem ri) {
		Session session = getSession();
		session.beginTransaction();
		int retVal = (Integer) session.save(ri);
		session.flush();
		session.beginTransaction().commit();
		return 0;
	}

	public List<RemitoItem> getItemsRemito(int remitoID) {
		Session session = getSession();
		List<RemitoItem> retVal = null;
		Query q = session.createQuery("from RemitoItem ri Where ri.RemitoID =?");
		retVal = q.list();
		session.close();
		return retVal;
	}

	public boolean updateRemitoCliente(RemitoCliente rc) {
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update Remito s set s.Nro, s.Fecha = ?, s.Items, s.estadoEnvio = ?,s.Cliente,s.OrdenPedido, s.Estado");// ver esto por las colecciones
		q.setInteger(0, rc.getNro());
		q.setDate(1, rc.getFecha());
		q.setParameter(2, rc.getItems());
		q.setString(3, rc.getEstadoEnvio());	
		q.setParameter(4, rc.getCliente());
		q.setParameter(5, rc.getOrdenPedido());
		q.setString(6, rc.getEstado());
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
		
	}

	public boolean updateRemitoClienteSt(int nroRemito, String estado) {
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update Remito r set r.estado = ? where s.id = ?");
		q.setInteger(1, nroRemito);
		q.setString(0, estado);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
		
	}

	public int grabarFactura(Factura factura) {
		Session session = getSession();
		session.beginTransaction();
		int retVal = (Integer) session.save(factura);
		session.flush();
		session.beginTransaction().commit();
		return retVal;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factura> getfacturas() {
		Session session = getSession();
		List<Factura> retVal = null;
		Query q = session.createQuery("from Factura");
		retVal = q.list();
		session.close();
		return retVal;
	}

	public Factura getUniqueFactura(int nroFactura) {
		Session session = getSession();
		Factura f = null;
		Query q = session.createQuery("from Factura f where nro=?");
		q.setInteger(0, nroFactura);
		f = (Factura) q.uniqueResult();
		session.close();
		return f;
	}

	public boolean updateFacturaSt(int nroFactura, String estado) {
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update Factura f set f.estado = ? where s.id = ?");
		q.setInteger(1, nroFactura);
		q.setString(0, estado);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}

	public int grabarOrdenCompra(OrdenCompra oc) {
		Session session = getSession();
		session.beginTransaction();
		int retVal = (Integer) session.save(oc);
		session.flush();
		session.beginTransaction().commit();
		return retVal;
		}

	public boolean updateOPISt(int id, String string) {
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update OrdenPedidoItem opi set opi.estado = ? where s.id = ?");
		q.setInteger(1, id);
		q.setString(0, string);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}

	public OrdenPedidoItem getUniqueOPI(int idOPI) {
		Session session = getSession();
		OrdenPedidoItem opi = null;
		Query q = session.createQuery("from OrdenPedidoItem opi where nro=?");
		q.setInteger(0, idOPI);
		opi = (OrdenPedidoItem) q.uniqueResult();
		session.close();
		return opi;
	}

	public boolean updateOrdenPedidoStPedidoProveedor(int nroOP, String string) {
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update OrdenPedido op set op.estado = ? where s.id = ?");
		q.setInteger(1, nroOP);
		q.setString(0, string);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
		}

	public OrdenPedido getUniqueOrdenPedido(int nroOP) {
		Session session = getSession();
		OrdenPedido op = null;
		Query q = session.createQuery("from OrdenPedido op where nro=?");
		q.setInteger(0, nroOP);
		op = (OrdenPedido) q.uniqueResult();
		session.close();
		return op;
	}

	public List<OrdenCompra> getOrdenCompra() {
		Session session = getSession();
		List<OrdenCompra> retVal = null;
		Query q = session.createQuery("from OrdenCompra");
		retVal = q.list();
		session.close();
		return retVal;
	}

	public boolean updateOrdenCompraStCerrado(int nroOC, String string) {
		Session session = getSession();
		int retVal = 0;
		Query q = session.createQuery("update OrdenCompra oc set oc.estado = ? where s.id = ?");
		q.setInteger(1, nroOC);
		q.setString(0, string);
		retVal = q.executeUpdate();
		session.close();
		return (retVal > 0);
	}

	public OrdenCompra getUniqueOrdenCompra(int nroOC) {
		Session session = getSession();
		OrdenCompra oc = null;
		Query q = session.createQuery("from OrdenCompra oc where nro=?");
		q.setInteger(0, nroOC);
		oc = (OrdenCompra) q.uniqueResult();
		session.close();
		return oc;	}

	
	
}
