/**
 *  Nodo.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package estructuras;

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
