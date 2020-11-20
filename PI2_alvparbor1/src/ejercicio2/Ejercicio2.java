package ejercicio2;

import java.util.stream.Stream;

/*
*
* Autor: Alvaro Paradas Borrego
* Fecha de creacion : Nov 12, 2020
*/
public class Ejercicio2 {
	
	public static boolean esMultiploIterativa(int a, int b) {
		boolean res = a == b;
		if(!res) {
			while(a > 0) {
				a = a - b;
			}
			res = a == 0;
		}
		return res;
	}
	
	public static boolean esMultiploRecursivaFinal(int a, int b) {
		return esMultiploRecursivaFinalAuxiliar(a, b);
	}

	private static boolean esMultiploRecursivaFinalAuxiliar(int a, int b) {
		if(a>=b) {
			return  esMultiploRecursivaFinalAuxiliar(a - b, b);			
		}
		return a == 0;
	}
	
	public static boolean esMultiploFuncional(int a, int b) {
		return Stream.iterate(a, x-> x>=0, x-> x-b)
					.parallel()
					.anyMatch(y-> y.equals(0));
	}
}
