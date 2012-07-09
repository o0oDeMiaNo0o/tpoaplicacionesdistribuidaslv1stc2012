package beans.srv;

import java.util.ArrayList;
import java.util.List;

import vistasbeans.ProveedorVista;

import beans.Cliente;
import beans.Factura;
import beans.Financiacion;
import beans.ItemPrecio;
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
  
	
	/*FIN LISTADO DE PRECIO*/
	
	/* :: OBTENER MEJOR PRECIO :: */	
	public ProveedorVista comparativaDePrecio(String nroSerie, String marca, List <String> marcas, String origen){
		//Reveer
	}		
	
	private Proveedor obtenerMejorPrecioRodamiento(List <Object[]> lista){
		//Reveer esto
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

	public List<RemitoItem> getItemsRemito(int remitoID) {
		
		return dao.getItemsRemito(remitoID);
	}

	public boolean updateRemitoCliente(RemitoCliente rc) {
		
		return dao.updateRemitoCliente (rc);
	}

	public boolean updateRemitoClienteSt(int nroRemito, String estado) {
			return dao.updateRemitoClienteSt(nroRemito, estado);
	}

	public int addFactura(Factura factura) {
		return dao.grabarFactura(factura);
	}

	public List<Factura> getfacturas() {
		return dao.getfacturas();
	}

	public Factura getUniqueFactura(int nroFactura) {
		return dao.getUniqueFactura(nroFactura);
	}

	public boolean updateFacturaSt(int nroFactura, String estado) {
		return dao.updateFacturaSt(nroFactura, estado);
	}

	public int addOrdenCompra(OrdenCompra oc) {
		return dao.grabarOrdenCompra(oc);		
	}

	public boolean updateOPISt(int id, String string) {
		return dao.updateOPISt(id, string);
	}

	public OrdenPedidoItem getUniqueOPI(int idOPI) {
		return dao.getUniqueOPI(idOPI);
	}

	public boolean updateOrdenPedidoStPedidoProveedor(int nroOP, String string) {
		return dao.updateOrdenPedidoStPedidoProveedor(nroOP,string);
	}

	public OrdenPedido getUniqueOrdenPedido(int nroOP) {
		return dao.getUniqueOrdenPedido(nroOP);
	}

	public List<OrdenCompra> getOrdenCompra() {
		return dao.getOrdenCompra();
	}

	public boolean updateOrdenCompraStCerrado(int nroOC, String string) {
		return dao.updateOrdenCompraStCerrado(nroOC,string);
	}

	public OrdenCompra getUniqueOrdenCompra(int nroOC) {
		return dao.getUniqueOrdenCompra(nroOC);
	}


}	
	



