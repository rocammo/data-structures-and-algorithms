/**
 *  TablaDispersa.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   08 ene. 2019
*/

package estructuras;

import biblioteca.Libro;

public class TablaDispersa {

	public static final int TAM_BIBLIOTECA = 100;
	private int numElementos;
	private double factorCarga;
	private Libro[] biblioteca;

	public TablaDispersa() {
		// se inicializa la biblioteca y sus elementos a NULL
		this.biblioteca = new Libro[TAM_BIBLIOTECA];
		for (int i = 0; i < TAM_BIBLIOTECA; i++) {
			this.biblioteca[i] = null;
		}
		// se inicializan los atributos a 0
		this.numElementos = 0;
		this.factorCarga = 0;
	}

	// devuelve la posicion o indice de la biblioteca libre para insertar
	public int direccion(long clave) {
		int i = 0, p;

		// aplica aritmetica modular para obtener la direccion base
		p = (int)(clave % TAM_BIBLIOTECA);

		// bucle de exploracion cuadratica
		while (biblioteca[p] != null && biblioteca[p].getNumero() != clave) {
			i++;
			p = p + i*i;
			p = p % TAM_BIBLIOTECA; // considera el array como circular
		}

		return p;
	}

	public void insertar(Libro libro) {
		int posicion = direccion(libro.getNumero());
		biblioteca[posicion] = libro;
		numElementos++;

		factorCarga = (double)(numElementos) / TAM_BIBLIOTECA;
		if (factorCarga > 0.5) {
			System.out.println("\n#### EL FACTOR DE CARGA SUPERA EL 50%, conviene aumentar la dimension");
		}
	}

	public void eliminar(long clave) {
		int posicion = direccion(clave);
		if (biblioteca[posicion] != null) {
			biblioteca[posicion] = null;
		}
	}

	// devuelve una referencia a un elemento si lo encuentra en la biblioteca y devuelve NULL si no lo encuentra o fue dado de baja
	public Libro buscar(long clave) {
		int posicion = direccion(clave);
		Libro pr = biblioteca[posicion];

		return pr;
	}

	// obtiene todos los libros disponibles (no prestados)
	public Libro[] obtenerTodos() {
		Libro[] libros = new Libro[TAM_BIBLIOTECA];
		for (int i = 0, j = 0; i < TAM_BIBLIOTECA; i++) {
			if (biblioteca[i] != null && !biblioteca[i].isPrestado()) {
				libros[j] = biblioteca[i];
				j++;
			}
		}

		return libros;
	}
}
