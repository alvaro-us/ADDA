package ejercicio3;

import java.util.stream.Stream;

/*
*
* Autor: Alvaro Paradas Borrego
* Fecha de creacion : Nov 18, 2020
*/
public class Ejercicio3 {
	public static Long potenciaEnteraIterativo(Integer n, long a) {
		long e = a;
		long b = 1;
		while(n > 0) {
			if(n%2 == 1) {
				b = b * e;
			}
			e = e * e;
			n = n/2;
		}
		return b;
	}
	
	public static Long potenciaEnteraRecursivaFinal(Integer n, long a) {
		// parametros: exponente / base / acumulador e / acumulador res
		return potenciaEnteraRecurvivaFAuxiliar(n, a, a, 1);
	}

	private static Long potenciaEnteraRecurvivaFAuxiliar(Integer n, long a, long e, long b) {
		if(n>0) {
			if(n%2 == 1) {
				return potenciaEnteraRecurvivaFAuxiliar(n/2, a, e*e, b * e);
			}
			return potenciaEnteraRecurvivaFAuxiliar(n/2, a, e*e, b);
		}
		return b;
	}
	
	public static Long potenciaEnteraRecursivaNoFinal(Integer n, long a) {
		// parametros: exponente / base / acumulador e / acumulador res
		return potenciaEnteraRecurvivaNfAuxiliar(n, a, a, 1);
	}

	private static Long potenciaEnteraRecurvivaNfAuxiliar(Integer n, long a, long e, long b) {
		if(n>0) {
			if(n %2 == 1) {
				return e * potenciaEnteraRecurvivaFAuxiliar(n/2, a, e*e, b);
			}
			return 1 * potenciaEnteraRecurvivaFAuxiliar(n/2, a, e*e, b);
		}
		return b;
	}
	
	public static Long potenciaEnteraFuncional(Integer n , Long a) {
		long[] res = {1};
		long[] b = {a};
		Stream.iterate(n, x -> x>0, x->x/2)
				.forEach(x->{
					if(x%2==1) {
						res[0]=res[0]*b[0];
					}
					b[0] = b[0]*b[0];
				});
		return res[0];
	}
	
}
