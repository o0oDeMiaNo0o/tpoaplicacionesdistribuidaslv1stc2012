package beans.srv;

import java.util.ArrayList;
import java.util.List;

import vistasbeans.ProveedorVista;

import beans.Cliente;
import beans.Financiacion;
import beans.ItemPrecio;
import beans.ItemStock;
import beans.ListaPrecio;
import beans.ODV;
import beans.Proveedor;
import beans.Remito;
import beans.RemitoCliente;
import beans.RemitoItem;
import beans.RemitoProveedor;
import beans.RemitoTransporte;
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

	/* LISTADO DE PRECIO */
	@SuppressWarnings("unchecked")
	public List<Proveedor> getProveedor(){
		return dao.getProveedor();
	}	
	
	@SuppressWarnings("unchecked")
	public Proveedor getProveedor(int id){
		return dao.getProveedor(id);
	}		
	
	public int grabarListaPrecio(ListaPrecio l){
		return dao.grabarListaPrecio(l);
	}
	
	public void actualizarProveedor(Proveedor p){
		dao.actualizarProveedor(p);
	}
	
	/*FIN LISTADO DE PRECIO*/
	
	/* :: OBTENER MEJOR PRECIO :: */	
	public ProveedorVista comparativaDePrecio(String nroSerie, String marca, List <String> marcas, String origen){
		return obtenerMejorPrecioRodamiento(dao.comparativaDePrecio(nroSerie, marca, marcas, origen)).vista();
	}		
	
	private Proveedor obtenerMejorPrecioRodamiento(List <Object[]> lista){
		ListaPrecio l = null;
		Proveedor p = null;
		Proveedor _p = null;
		Rodamiento r = null;
		ItemPrecio it = null;
		float mejorPrecio = 0;
		Object[] tmp = null;
		
		if(!lista.isEmpty()){
			tmp = lista.get(0);
			it = (ItemPrecio) lista.get(0)[2];
			mejorPrecio = it.getPrecioVenta();
		
			for(Object[] o : lista){
				it = (ItemPrecio) o[2];
				
				if(it.getPrecioVenta() < mejorPrecio){
					mejorPrecio = it.getPrecioVenta();
					tmp = o;
				}				
			}
	
			p = (Proveedor) tmp[0];
			l = (ListaPrecio) tmp[1];
			it = (ItemPrecio) tmp[2];
			r = (Rodamiento) tmp[3];
						
			ItemPrecio _it = new ItemPrecio();
			_it.setCantidad(it.getCantidad());
			_it.setId(it.getId());
			_it.setPrecioCosto(it.getPrecioCosto());
			_it.setPrecioVenta(it.getPrecioVenta());
			_it.setRodamiento(r);
			
			ListaPrecio _li = new ListaPrecio();
			_li.setDescuentoContado(l.getDescuentoContado());
			_li.setFechaEmision(l.getFechaEmision());
			_li.agregarItemPrecio(_it);
			_li.setNro(l.getNro());
			_li.setFinanciacion(new ArrayList<Financiacion>());
			_li.setNroListReemplazo(l.getNroListReemplazo());
			
			_p = new Proveedor();
			_p.setDireccion(p.getDireccion());
			_p.setNro(p.getNro());
			_p.setRazonSocial(p.getRazonSocial());
			_p.setTelefono(p.getTelefono());
			_p.agregarListadoPrecio(_li);
		}
		return _p;
	}

	
	/* FIN LISTADO PRECIO */	
	
	
/* Obtener ODV */
	
	public ODV getodv(int idODV) {
		return dao.devolverODV(idODV);
	}

/* Grabar Remito Cliente */
	public int addRemitoCliente(RemitoCliente remitoCl) {
		return dao.grabarRemitoCliente(remitoCl);
		}

	public List<RemitoCliente> getRemitoCl() {
		return dao.getRemitoCl();
	}

	public List<RemitoProveedor> getRemitoPrv() {
		return dao.getRemitoPrv();
	}

	public List<RemitoTransporte> getRemitoTpte() {
		return dao.getRemitoTpte();
	}

	public Remito getUniqueRemito(int nroRemito) {
		// TODO Auto-generated method stub
		return dao.getUniqueRemito(nroRemito);
	}

	public RemitoCliente getUniqueRemitoC(int nroRemito) {
		// TODO Auto-generated method stub
		return dao.getUniqueRemitoC(nroRemito);
	}

	public RemitoTransporte getUniqueRemitoT(int nroRemito) {
		// TODO Auto-generated method stub
		return dao.getUniqueRemitoT(nroRemito);
	}

	public RemitoProveedor getUniqueRemitoP(int nroRemito) {
		// TODO Auto-generated method stub
		return dao.getUniqueRemitoP(nroRemito);
	}

	public int grabarItemStock(RemitoItem ri) {
		// TODO Auto-generated method stub
		return dao.grabarItenStock(ri);
	}


}	
	



