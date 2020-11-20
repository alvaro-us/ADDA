package ejercicio_1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.math.Math2;
import utiles.Utiles;

/*
*
* Autor: Alvaro Paradas Borrego
*/
public class Ejercicio_1 {

	public static List<List<Integer>> leerFichero(String path){		
		// por cada elemento de la lista obtenemos una linea completa del fichero leido
		List<String> objetos = Utiles.leeFichero(path);
		int tam = 0;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		while(tam < objetos.size()) {
			String linea = objetos.get(tam);
			String[] trozo = linea.split(",");
			List<Integer> objInt = new ArrayList<Integer>();
			int t_tam = 0;
			
			while(t_tam < trozo.length) {
				objInt.add(Integer.parseInt(trozo[t_tam].trim()));
				t_tam++;
			}
			res.add(objInt);
			tam++;
		}		
		
		return res;
	}
	
	public static List<Integer> esPrimo(List<List<Integer>> listas){
		List<Integer> res = new ArrayList<Integer>();
		int tamList = 0; // tamaño lista de listas
		
		while(tamList < listas.size()) {
			List<Integer> temp = listas.get(tamList);
			int tamSubList = 0; // tamaño lista de linea
			
			while(tamSubList < temp.size()) {
				if(Math2.esPrimo(temp.get(tamSubList))) {
					res.add(temp.get(tamSubList));
				}
				tamSubList++;
			
			}
			tamList++;
		}
		return res;
	}


}
