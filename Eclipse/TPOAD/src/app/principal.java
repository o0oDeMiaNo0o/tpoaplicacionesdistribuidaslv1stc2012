package app;
import java.util.Date;
import java.util.List;

import beans.Rodamiento;

import sistema.Sistema;

public class principal {
	private static Sistema sistema;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sistema = Sistema.getSistema();
		sistema.almacenarRodamiento("A221", "SKF", "40004", "Irlanda", "SKFA221");
		sistema.almacenarRodamiento("A222", "SKF", "40005", "Irlanda", "SKFA222");
		sistema.almacenarRodamiento("A223", "SKF", "40006", "Irlanda", "SKFA223");
		
		sistema.almacenarItemStock(40, "En Stock", 24, 54, 1, new Date());
		sistema.almacenarItemStock(5, "Critico", 16, 12, 2, new Date());
		sistema.almacenarItemStock(0, "Sin Stock", 116, 158, 3, new Date());
		
		List <Rodamiento> r = sistema.obtenerRodamientos();
		for(Rodamiento rod:r){
			System.out.println(rod.getMarca() + " - " + rod.getNroSerie()); 
		}
	}

}
