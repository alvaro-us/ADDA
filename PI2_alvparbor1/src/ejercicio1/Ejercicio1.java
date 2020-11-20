package ejercicio1;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
*
* Autor: Alvaro Paradas Borrego
* Fecha de creacion : Nov 10, 2020
*/
public class Ejercicio1 {

	public static Integer getPosicionDiferenteIterativo(String cadenaA, String cadenaB, int i, int j) {
		int res = 0;
		/* busqueda binaria
		*  i -> posicion inicial
		*  j -> posicion final
		*  k -> posicion intermedia (i-j)/2
		*/
		if(cadenaA.length() == cadenaB.length()) { // condicion de que las dos cadenas tengan el mismo tamaño
			int k = (i + j) / 2;
			while(i < j) {
				// busqueda ls[i,k]
				if(cadenaA.charAt(k) == cadenaB.charAt(k)) {
					if(cadenaA.charAt(k+1) != cadenaB.charAt(k+1)) {
						res = k + 1;
						break;
					} else {
						i = k;
					}
				} else if(cadenaA.charAt(k) != cadenaB.charAt(k)) { // busqueda ls[k,j]
					if(cadenaA.charAt(k-1) == cadenaB.charAt(k-1)) {
						res = k;
						break;
					} else {
						j = k;
					}
				}
				k = (i + j) / 2;
			}
		} else {
			res = -1;
		}
		return res;
	}
	
	public static Integer getPosicionDiferenteRecursivoF(String cadenaA, String cadenaB, int i, int j) {
		return getPosicionDiferenteRecursivoFAux(cadenaA, cadenaB, i, j); // param (cadenaA, cadenaB, PosicionInicial, PosicionFinal)
	}

	private static Integer getPosicionDiferenteRecursivoFAux(String cadenaA, String cadenaB, int i, int j) {
		int res = -1;
		int k = (i + j) / 2;
		if(cadenaA.length() == cadenaB.length()) {
			// busqueda ls[i,k]
			if(cadenaA.charAt(k) == cadenaB.charAt(k)) {
				if(cadenaA.charAt(k+1) != cadenaB.charAt(k+1)) {
					res = k + 1;
				} else {
					res = getPosicionDiferenteRecursivoFAux(cadenaA, cadenaB, k, j);
				}
			} else if(cadenaA.charAt(k) != cadenaB.charAt(k)) { // busqueda ls[k,j]
				if(cadenaA.charAt(k-1) == cadenaB.charAt(k-1)) {
					res = k;
					
				} else {
					res = getPosicionDiferenteRecursivoFAux(cadenaA, cadenaB, i, k);
				}
			}
		} 
		return res;
	}

	public static Integer getPosicionDiferenteFuncional(String cadenaA, String cadenaB) {
		// funcion eleccion si ls[i,k] o ls[k,j]
		UnaryOperator<P3> next = p-> {if(cadenaA.charAt(p.k) == cadenaB.charAt(p.k))
											return (P3.of(p.k, p.j));
									 else
										 	return (P3.of(p.i, p.k));
									};
		// rando de operacion (0, tamaño cadena) / condicion para seguir generando secuencias / next
		Stream<P3> s = Stream.iterate(P3.of(0, cadenaA.length()), x-> ((P3)x).i <= ((P3)x).j-1, next);
		// filtro para ver que camino debe de coger:
		Optional<P3> r = s.filter(y->
								cadenaA.charAt(y.k) == cadenaB.charAt(y.k) &&
								cadenaA.charAt(y.k + 1) != cadenaB.charAt(y.k + 1) ||
								cadenaA.charAt(y.k) != cadenaB.charAt(y.k) &&
								cadenaA.charAt(y.k - 1) == cadenaB.charAt(y.k - 1))
					.findFirst();
		return r.isPresent()? 
					r.get().i>0 && r.get().i!=cadenaA.length()/2? 
					r.get().i+1: 
					r.get().i:-1;
	}
}
