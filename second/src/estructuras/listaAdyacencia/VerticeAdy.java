/**
 *  VerticeAdy.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package estructuras.listaAdyacencia;

import estructuras.Lista;

public class VerticeAdy {
	String nombre;
	int numeroVertice;
	Lista lad;

	public VerticeAdy(String x) {
		this.nombre = x;
		this.numeroVertice = -1;
		this.lad = new Lista();
	}

	public String nombreVertice() {
		return nombre;
	}

	public boolean equals(VerticeAdy v) {
		return nombre.equals(v.nombre);
	}

	public void asignarVertice(int n) {
		this.numeroVertice = n;
	}

	public String toString() {
		return nombre;
	}
}
