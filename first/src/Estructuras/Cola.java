/**
 *  Cola.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Estructuras;

public class Cola {
	private Nodo primero, ultimo;

	public void encolar(Object o) {
		Nodo nuevoNodo = new Nodo(o);
		if (primero == null) {
			primero = nuevoNodo;
		} else {
			ultimo.siguiente = nuevoNodo;
		}
		ultimo = nuevoNodo;
	}

	public Object quitar() {
		if (primero != null) {
			Nodo eliminar = primero;
			primero = primero.siguiente;
			eliminar.siguiente = null;

			if (primero == null) {
				ultimo = null;
			}

			return eliminar.dato;
		}

		return null;
	}

	public Object obtenerPrimero() {
		if (primero == null) {
			return null;
		} else {
			return primero.dato;
		}
	}

	public Object obtenerUltimo() {
		if (primero == null) {
			return null;
		} else {
			return ultimo.dato;
		}
	}

	public boolean vacia() {
		return (primero == null);
	}
}
