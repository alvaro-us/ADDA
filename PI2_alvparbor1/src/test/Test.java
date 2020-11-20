package test;

import java.util.List;

import ejercicio1.Ejercicio1;
import ejercicio2.Ejercicio2;
import ejercicio3.Ejercicio3;
import utiles.Utiles;

/*
*
* Autor: Alvaro Paradas Borrego
* Fecha de creacion : Nov 10, 2020
*/
public class Test {

	public static void main(String[] args) {
		System.out.println("----------------------EJERCICIO 1 TEST-------------------------");
		test1();		
		System.out.println("---------------------------------------------------------------");
		System.out.println("----------------------EJERCICIO 2 TEST-------------------------");
		test2();
		System.out.println("---------------------------------------------------------------");
		System.out.println("----------------------EJERCICIO 3 TEST-------------------------");
		test3();
		System.out.println("---------------------------------------------------------------");

	}

	private static void test3() {
		List<String> lineas = Utiles.leeFichero(".\\Ficheros\\PI2Ej3DatosEntrada.txt");
		int i = 0;
		while(i < lineas.size()) {
			String linea = lineas.get(i);
			String[] trozos = linea.split(",");
			long a = Long.parseLong(trozos[0].trim());
			Integer n = Integer.parseInt(trozos[1].trim());
			System.out.println(linea.toString());
			long resIterativo = Ejercicio3.potenciaEnteraIterativo(n, a);
			long resRF = Ejercicio3.potenciaEnteraRecursivaFinal(n, a);
			long resRnF = Ejercicio3.potenciaEnteraRecursivaNoFinal(n, a);
			long resF = Ejercicio3.potenciaEnteraFuncional(n, a);
			System.out.println("1. Iterativo: " + resIterativo);
			System.out.println("2. Recursivo final: " + resRF);
			System.out.println("3. Recursivo no final: " + resRnF);
			System.out.println("4. Funcional: " + resF);
			i++;
		}
		
	}

	private static void test2() {
		List<String> lineas = Utiles.leeFichero(".\\Ficheros\\PI2Ej2DatosEntrada.txt");
		int i = 0;
		while(i < lineas.size()) {
			String linea = lineas.get(i);
			String[] trozos = linea.split(",");
			Integer a = Integer.parseInt(trozos[0].trim());
			Integer b = Integer.parseInt(trozos[1].trim());
			System.out.println(linea.toString());
			boolean resI = Ejercicio2.esMultiploIterativa(a, b);
			boolean resRf = Ejercicio2.esMultiploRecursivaFinal(a, b);
			boolean resF = Ejercicio2.esMultiploFuncional(a, b);
			System.out.println("1. Iterativa (while): " + resI);
			System.out.println("2. Recursiva final: " + resRf);
			System.out.println("3. Recursiva Funcional: " + resF);
			System.out.println("\n");
			i++;
		}
		
	}

	private static void test1() {
		List<String> fichero = Utiles.leeFichero(".\\Ficheros\\PI2Ej1DatosEntrada.txt");
		int i = 0;
		while(i < fichero.size()) {
			String linea = fichero.get(i);
			String trozo[] = linea.split("#");
			String cadenaA = trozo[0];
			String cadenaB = trozo[1];
			System.out.println(cadenaA + ", " + cadenaB);
			int iterativa = Ejercicio1.getPosicionDiferenteIterativo(cadenaA, cadenaB, 0, cadenaB.length()-1);
			int recursiva = Ejercicio1.getPosicionDiferenteRecursivoF(cadenaA, cadenaB, 0, cadenaB.length()-1);
			int funcional = Ejercicio1.getPosicionDiferenteFuncional(cadenaA, cadenaB);
			System.out.println("1. iterativa (while): " + iterativa);
			System.out.println("2. recursiva: " + recursiva);
			System.out.println("3. funcional: " + funcional);
			System.out.println("\n");
			i++;
		}
		
	}

}
