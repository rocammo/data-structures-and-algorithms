/**
 *  Cola.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package estructuras;

public class Cola {
	private Nodo cabeza;
	private Nodo ultimo;

	public void encolar(Object o) {
		Nodo nuevoNodo = new Nodo(o);
		if (cabeza == null) {
			cabeza = nuevoNodo;
		} else {
			ultimo.siguiente = nuevoNodo;
		}
		ultimo = nuevoNodo;
	}

	public Object quitar() throws Exception {
		Nodo eliminar;

		if(cabeza != null) {
			eliminar = cabeza;
			cabeza = cabeza.siguiente;
			eliminar.siguiente = null;
			if (cabeza == null) {
				ultimo = null;
			}
		} else throw new Exception("!ERROR Intentando quitar() de una cola vacia.");

		return eliminar.dato;
	}

	public Object obtenerCabeza() {
		if (cabeza == null) {
			return null;
		} else {
			return cabeza.dato;
		}
	}

	public Object obtenerUltimo() {
		if (cabeza == null) {
			return null;
		} else {
			return ultimo.dato;
		}
	}

	public boolean vacia() {
		return cabeza == null;
	}
}
