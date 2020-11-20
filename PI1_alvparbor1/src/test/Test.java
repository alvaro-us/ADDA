package test;

import java.util.List;
import java.util.Map;

import ejercicio_1.Ejercicio_1;
import ejercicio_2.Ejercicio_2;
import ejercicio_3.Ejercicio_3;
import us.lsi.geometria.Punto2D;

/*
*
* Autor: Alvaro Paradas Borrego
*/
public class Test {

	public static void main(String[] args) {
		testEjercicio_1();
		testEjercicio_2();
		testEjercicio_3();

	}

	private static void testEjercicio_3() {
		System.out.println("--------------TEST EJERCICIO 3: -------------------");
		List<Punto2D> puntos = Ejercicio_3.leeFichero(".\\Ficheros\\PI1Ej3DatosEntrada.txt");
		Map<Punto2D.Cuadrante, Double> res = Ejercicio_3.sumaXCuadrantes(puntos);
		System.out.println(res.toString());
		System.out.println("---------------------------------------------------\n");
		
	}

	private static void testEjercicio_2() {
		System.out.println("--------------TEST EJERCICIO 2: -------------------");
		List<Integer> res = Ejercicio_2.leeFichero(".\\Ficheros\\PI1Ej2DatosEntrada.txt");
		int tam = 0;
		while(tam < res.size()) {
			String s = Ejercicio_2.siguientePrimo(res.get(tam));
			System.out.println("Límite " + res.get(tam) + ": \n" + s + "\n===========================================");
			tam++;
		}
		System.out.println("---------------------------------------------------\n");
	}

	private static void testEjercicio_1() {
		System.out.println("--------------TEST EJERCICIO 1: -------------------");
		List<List<Integer>> listas = Ejercicio_1.leerFichero(".\\Ficheros\\PI1Ej1DatosEntrada.txt");	
		List<Integer> res = Ejercicio_1.esPrimo(listas);	
		System.out.println(res.toString());
		System.out.println("---------------------------------------------------\n");
	}

}
