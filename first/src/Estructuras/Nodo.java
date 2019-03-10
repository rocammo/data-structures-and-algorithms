/**
 *  Nodo.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Estructuras;

public class Nodo {
	public Object dato;
	public Nodo siguiente;

	public Nodo(Object x) {
		this(x, null);
	}

	public Nodo(Object x, Nodo sig) {
		this.dato = x;
		this.siguiente = sig;
	}
}
