package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import vistasbeans.ProveedorVista;
import beans.srv.ServicioDAO;

public class ImplementsRemota extends UnicastRemoteObject implements InterfazRemota {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ServicioDAO srv = new ServicioDAO();
	
	public ImplementsRemota() throws RemoteException {
		super();
		//srv = new ServicioDAO();
	}

	@Override
	public ProveedorVista comparativaDePrecio(String nroSerie, String marca, List<String> marcas, String origen) throws RemoteException {
		return srv.comparativaDePrecio(nroSerie, marca, marcas, origen);
	}
	
}
