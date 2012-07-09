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
	
	public ImplementsRemota() throws RemoteException {
		
	}

	
}
