package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.*;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		//Publico La interfaz Remota
		publicar(new ImplementsRemota());
	}
	
	private static void publicar(InterfazRemota ir) throws RemoteException, MalformedURLException{
		LocateRegistry.createRegistry(1099);
		Naming.rebind("//127.0.0.1:1099/InterfazRemota", ir);
	}
}
