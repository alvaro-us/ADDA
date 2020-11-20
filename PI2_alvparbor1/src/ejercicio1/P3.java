package ejercicio1;
/*
*
* Autor: Alvaro Paradas Borrego
* Fecha de creacion : Nov 20, 2020
*/
public class P3 {
	int i;
	int j;
	int k;
	
	public static P3 of(int i, int j){
		return new P3(i,j);
	}
	
	private P3(int i, int j){
		this.i = i;
		this.j = j;
		this.k = (i+j)/2;
	}

}
