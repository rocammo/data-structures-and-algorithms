/**
 *  Lista.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   08 ene. 2019
*/

package estructuras;

import biblioteca.Libro;

public class Lista {
	private class Nodo {
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

	private Nodo primero;
	private int dimension;

	public Lista()
	{
		this.primero = null;
		this.dimension = 0;
	}

	public boolean esVacia() {
		return primero == null;
	}

	public void insertarPrincipio(Object o) {
		Nodo nodo = new Nodo(o);
		nodo.siguiente = primero;
		primero = nodo;

		dimension++;
	}


	public void insertarFinal(Object o) {
		Nodo nodo = new Nodo(o);
		if (primero == null) {
			primero = nodo;
		} else {
			Nodo puntero = primero;
			while (puntero.siguiente != null) {
				puntero = puntero.siguiente;
			}
			puntero.siguiente = nodo;
		}

		dimension++;
	}

	public void insertar(Object n, Object o) {
		Nodo nodo = new Nodo(o);
		if (primero == null) {
			primero = nodo;
		} else {
			Nodo puntero = primero;
			while (puntero.dato != n) {
				puntero = puntero.siguiente;
			}
			nodo.siguiente = puntero.siguiente;
			puntero.siguiente = nodo;
		}

		dimension++;
	}

	public Object buscar(Object n) {
		Nodo puntero = primero;
		String posiciones = "[" + n + "]: ";

		if (primero != null) {
			for (int i = 0; i < dimension; i++) {
				if (puntero.dato == n) posiciones += "{" + i + "}";
				puntero = puntero.siguiente;
			}
		}

		return posiciones;
	}

	public boolean buscarIndice(Object n) {
		Nodo puntero = primero;

		if (primero != null) {
			for (int j = 0; j < dimension; j++) {
				if (puntero.dato == n) return true;
				puntero = puntero.siguiente;
			}
		}

		return false;
	}

	public Nodo buscarIndice(int i) {
		Nodo puntero = primero;

		if (primero != null) {
			for (int j = 0; j < dimension; j++) {
				if (j == (i - 1)) return puntero;
				puntero = puntero.siguiente;
			}
		}

		return null;
	}

	public void suprimir(Object n) {
		if (primero == null) return;

		if (buscarIndice(n)) {
			Nodo puntero = primero;
			if (puntero.dato == n) {
				primero = puntero.siguiente;
			} else {
				while (puntero.siguiente.dato != n &&
					   puntero.siguiente != null) {
					puntero = puntero.siguiente;
				}
				if (puntero.siguiente != null) {
					puntero.siguiente = puntero.siguiente.siguiente;
					dimension--;
				}
			}
		}
	}

	public Object anterior(Object n) {
		Nodo puntero = primero;

		if (primero == null || puntero.dato == n)
			return null;

		while (puntero.siguiente.dato != n &&
			   puntero.siguiente.siguiente != null) {
			puntero = puntero.siguiente;
		}

		return puntero.dato;
	}

	public Object primero() {
		if (primero == null)
			return null;

		return primero.dato;
	}

	public Object buscaUltimo() {
		Nodo puntero = primero;
		if (primero == null) {
			return null;
		} else {
			while (puntero.siguiente != null) {
				puntero = puntero.siguiente;
			}
		}

		return puntero.dato;
	}

	public void anula() {
		primero = null;
		dimension = 0;
	}

	public Object obtener(int n) {
		Nodo puntero = primero;

    	for (int i = 0; puntero != null; i++) {
            if (i == n) return puntero.dato;
            puntero = puntero.siguiente;
        }

		return null;
	}

	public String mostrar() {
        Nodo puntero = primero;
        String datos = "";

    	while(puntero != null) {
            datos += ((Libro) puntero.dato).getTitulo() + ", ";
            puntero = puntero.siguiente;
        }
        if (primero != null) datos = datos.substring(0, datos.length() - 2);

        String strLista = "{ " + datos + " }";

        return strLista;
	}
}
