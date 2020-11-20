package ejercicio_2;

import java.util.ArrayList;
import java.util.List;

import us.lsi.math.Math2;
import utiles.Utiles;

/*
*
* Autor: Alvaro Paradas Borrego
*/
public class Ejercicio_2 {

	public static List<Integer> leeFichero(String path){
		List<Integer> res = new ArrayList<Integer>();
		List<String> lineas = Utiles.leeFichero(path);
		int nLinea = 0;
		while(nLinea < lineas.size()) {
			String linea = lineas.get(nLinea);
			String[] trozo = linea.split(":");
			res.add(Integer.parseInt(trozo[1].trim()));
			nLinea++;
		}
		
		return res;
	}
	
	public static String siguientePrimo(Integer limit) {
		String cadenaPrimos = new String("");
		int temp = 0;
		int i = 2;
		while(i <= limit) {
			if(Math2.esPrimo(i)) {
				temp = i*i;
				cadenaPrimos += Integer.toString(temp) + "\n";
				//System.out.println(Integer.toString(temp));
			}
			i++;
		}
		return cadenaPrimos;
		
	}
	
	
}
