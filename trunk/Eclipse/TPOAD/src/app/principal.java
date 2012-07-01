package app;
import java.util.Date;
import java.util.List;

import sistema.Sistema;
import beans.ItemStock;
import beans.Rodamiento;

public class principal {
	private static Sistema sistema;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 	sistema = Sistema.getSistema();
		
    //Alta Item Stock
		sistema.ItemStock_Alta_Ingreso("A221", "SKF", "40004", "Irlanda", "SKFA221", 40, "En Stock", 24, 54, new Date());
		sistema.ItemStock_Alta_Confirmacion("A221", 24);

    //Modificaicon Item Stock
		ItemStock i = sistema.ItemStock_Modificacion_Inicio(1);
		System.out.println("Modificacion: " + String.valueOf(i.getCantidad()) + " - " + i.getRodamiento().getNroSerie()); 
		sistema.ItemStock_Modificacion_Confirmacion(1, "A221", "SKF", "40007", "Irlanda", "SKFA221", 1, 71, "Habilitado", 24, 54, new Date());
		//Eliminación lógica de Item Stock
    i = sistema.ItemStock_Eliminacion_Inicio(1);
    System.out.println("Eliminacion: " + String.valueOf(i.getCantidad()) + " - " + i.getRodamiento().getNroSerie()); 
		sistema.ItemStock_Eliminacion_Confirmacion(1);
		
    //Impresion de todos los rodamientos disponibles
		List <Rodamiento> r = sistema.obtenerRodamientos();
		for(Rodamiento rod:r){
			System.out.println(rod.getMarca() + " - " + rod.getNroSerie()); 
		}
	}

}
