package app;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rmi.InterfazRemota;
import sistema.Sistema;
import vistasbeans.ProveedorVista;
import beans.ItemStock;
import beans.Rodamiento;

public class principal {
	private static Sistema sistema;
	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		//rmi();
		sistema = Sistema.getSistema();
		//calcular();
		//calcular_();
		/*
		sistema.ItemStock_Alta_Ingreso("A221", "SKF", "40004", "Irlanda", "SKFA221", 40, "En Stock", 24, 54, new Date());
		sistema.ItemStock_Alta_Confirmacion("A221", 24);

		ItemStock i = sistema.ItemStock_Modificacion_Inicio(1);
		System.out.println("Modificacion: " + String.valueOf(i.getCantidad()) + " - " + i.getRodamiento().getNroSerie()); 
		sistema.ItemStock_Modificacion_Confirmacion(1, "A221", "SKF", "40007", "Irlanda", "SKFA221", 1, 71, "Habilitado", 24, 54, new Date());
		i = sistema.ItemStock_Eliminacion_Inicio(1);
		System.out.println("Eliminacion: " + String.valueOf(i.getCantidad()) + " - " + i.getRodamiento().getNroSerie()); 
		sistema.ItemStock_Eliminacion_Confirmacion(1);
		
		List <Proveedor> proveeodr = sistema.obtenerProveedor();
		for(Proveedor p:proveeodr){
			System.out.println(String.valueOf(p.getNro()) + " " + p.getRazonSocial()); 
		}
		
		ListaPrecio li = sistema.listadoPrecio_iniciar(1, 20, new Date(), 0);
		System.out.println(String.valueOf(li.getDescuentoContado()) + " " + String.valueOf(li.getNroListReemplazo())); 
		sistema.listadoPrecio_agregarFinanciacion(1, 0, 6, 22);
		sistema.listadoPrecio_agregarFinanciacion(1, 0, 12, 41);
		sistema.listadoPrecio_agregarItemPrecio(1, 0, 1, 1024, 12, 31);
		sistema.listadoPrecio_confirmar(1, 0);
		*/
		/*
		sistema.almacenarRodamiento("A221", "SKF", "40004", "Irlanda", "SKFA221");
		sistema.almacenarRodamiento("A222", "SKF", "40005", "Irlanda", "SKFA222");
		sistema.almacenarRodamiento("A223", "SKF", "40006", "Irlanda", "SKFA223");
		
		sistema.almacenarItemStock(40, "En Stock", 24, 54, 1, new Date());
		sistema.almacenarItemStock(5, "Critico", 16, 12, 2, new Date());
		sistema.almacenarItemStock(0, "Sin Stock", 116, 158, 3, new Date());
		*/
		/*
		List <Rodamiento> r = sistema.obtenerRodamientos();
		for(Rodamiento rod:r){
			System.out.println(rod.getMarca() + " - " + rod.getNroSerie()); 
		}
		*/
	}
	
	private static void calcular_(){
		List<String> marcas = new ArrayList <String>();
		marcas.add("SKF");
		marcas.add("ZKL");
		ProveedorVista _p = sistema.comparativaPrecio_iniciar_("22310", "SKF", marcas, "");
		
		System.out.println(String.valueOf(_p.getListaPrecios().get(0).getNro()) + " " + _p.getRazonSocial() + " - Precio: " + String.valueOf(_p.getListaPrecios().get(0).getItems().get(0).getPrecioVenta()) + " " + String.valueOf(_p.getListaPrecios().get(0).getItems().get(0).getCantidad()) + " " + _p.getListaPrecios().get(0).getItems().get(0).getRodamiento().getNroSerie());
		
	}
	
	private static void rmi() throws RemoteException, NotBoundException{
		final String ip = "127.0.0.1";
		final Registry registry = LocateRegistry.getRegistry(ip, Registry.REGISTRY_PORT);
		final String[] enlaceRemoto = registry.list();
		InterfazRemota ir;
		ProveedorVista _p = null;
		
		for(String enlace:enlaceRemoto){
			ir = (InterfazRemota) registry.lookup(enlace);
			List<String> marcas = new ArrayList <String>();
			/*marcas.add("SKF");
			marcas.add("ZKL");*/
			//_p = ir.getProveedor(1);
			_p = ir.comparativaDePrecio("22310", "SKF", marcas, "");
			System.out.println(String.valueOf(_p.getListaPrecios().get(0).getNro()) + " " + _p.getRazonSocial() + " - Precio: " + String.valueOf(_p.getListaPrecios().get(0).getItems().get(0).getPrecioVenta()) + " " + String.valueOf(_p.getListaPrecios().get(0).getItems().get(0).getCantidad()) + " " + _p.getListaPrecios().get(0).getItems().get(0).getRodamiento().getNroSerie());
		}		
	}
}
