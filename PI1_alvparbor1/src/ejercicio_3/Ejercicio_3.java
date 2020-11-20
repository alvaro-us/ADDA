package ejercicio_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.geometria.Punto2D;
import utiles.Utiles;

/*
*
* Autor: Alvaro Paradas Borrego
*/
public class Ejercicio_3 {

	public static List<Punto2D> leeFichero(String path){
		List<Punto2D> puntos = new ArrayList<Punto2D>();
		List<String> lineas = Utiles.leeFichero(path);
		int nLineas = 0;
		while(nLineas < lineas.size()) {
			String linea = lineas.get(nLineas);
			String[] trozo = linea.split(",");
			String x = trozo[0].replace('(', ' ').trim();
			String y = trozo[1].replace(')', ' ').trim();
			
			Punto2D p = Punto2D.create(Double.parseDouble(x), Double.parseDouble(y));
			puntos.add(p);
			
			nLineas++;
		}
		return puntos;
	}
	
	public static Map<Punto2D.Cuadrante, Double> sumaXCuadrantes(List<Punto2D> l){
		Map<Punto2D.Cuadrante, Double> res = new HashMap<Punto2D.Cuadrante, Double>();
		Double temp = 0.; 
		int i = 0;
		while(i < l.size()) {
			Punto2D p2d = l.get(i);
			switch(p2d.getCuadrante()) {
				case PRIMER_CUADRANTE: 
					temp = p2d.getX();
					if(res.get(p2d.getCuadrante()) == null) {
						res.put(p2d.getCuadrante(), temp);
					} else {
						temp += res.get(p2d.getCuadrante());
						res.replace(p2d.getCuadrante(), temp);
					}
					break;
					
				case SEGUNDO_CUADRANTE: 
					temp = p2d.getX();
					if(res.get(p2d.getCuadrante()) == null) {
						res.put(p2d.getCuadrante(), temp);
					} else {
						temp += res.get(p2d.getCuadrante());
						res.replace(p2d.getCuadrante(), temp);
					}
					break;
					
				case TERCER_CUADRANTE: 
					temp = p2d.getX();
					if(res.get(p2d.getCuadrante()) == null) {
						res.put(p2d.getCuadrante(), temp);
					} else {
						temp += res.get(p2d.getCuadrante());
						res.replace(p2d.getCuadrante(), temp);
					}
					break;
					
				case CUARTO_CUADRANTE: 
					temp = p2d.getX();
					if(res.get(p2d.getCuadrante()) == null) {
						res.put(p2d.getCuadrante(), temp);
					} else {
						temp += res.get(p2d.getCuadrante());
						res.replace(p2d.getCuadrante(), temp);
					}
					break;
			}
			i++;
		}
		
		return res;
	}
	
}
