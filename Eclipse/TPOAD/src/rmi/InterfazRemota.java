package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import beans.Proveedor;

import vistasbeans.ProveedorVista;

public interface InterfazRemota extends Remote {
	
	public ProveedorVista comparativaDePrecio(String nroSerie, String marca, List <String> marcas, String origen) throws RemoteException;

}
