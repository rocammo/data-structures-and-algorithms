/**
 *  GrafoAdcia.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package estructuras.listaAdyacencia;

import estructuras.Cola;
import estructuras.PilaArray;

public class GrafoAdcia {
	private int numVerts;
	private VerticeAdy[] vertices;

	public GrafoAdcia(int mx) {
		this.numVerts = 0;
		this.vertices = new VerticeAdy[mx];

		System.out.println("El grafo ha sido creado.\n");
	}

	public void nuevoVertice(String vs) {
		boolean esta = (numVertice(vs) >= 0);
		if(!esta) {
			VerticeAdy v = new VerticeAdy(vs);
			v.asignarVertice(numVerts);
			vertices[numVerts++] = v;
		}
	}

	public int numVertice(String vs) {
		// busca el vertice en el array, si no lo encuentra devuelve -1
		VerticeAdy v = new VerticeAdy(vs);
		boolean encontrado = false;
		int i = 0;

		while((i < numVerts) && !encontrado) {
			encontrado = vertices[i].equals(v);
			if(!encontrado) i++;
		}

		return (i < numVerts) ? i : -1;
	}

	public void nuevaArista(String desde, String hasta, int peso) throws Exception {
		int va, vb;
		va = numVertice(desde);
		vb = numVertice(hasta);

		if (va < 0 || vb < 0) throw new Exception ("!ERROR No existe vertice.");
		vertices[va].lad.insertarFinal(new Arista(vb, peso));
	}

	public boolean adyacente(String desde, String hasta) throws Exception {
		int va, vb;
		va = numVertice(desde);
		vb = numVertice(hasta);

		if (va < 0 || vb < 0) throw new Exception ("!ERROR No existe vertice.");

		for (int i = 0; vertices[va].lad.obtener(i) != null; i++) {
			if (((Arista) vertices[va].lad.obtener(i)).getDestino() == vb) {
				return true;
			}
		}

		return false;
	}

	public boolean existeArista(int va, int vb) throws Exception {
		if (va < 0 || vb < 0) throw new Exception ("!ERROR No existe vertice.");

		for (int i = 0; vertices[va].lad.obtener(i) != null; i++) {
			if (((Arista) vertices[va].lad.obtener(i)).getDestino() == vb) {
				return true;
			}
		}

		return false;
	}

	public int obtenerPeso(int va, int vb) throws Exception {
		if (va < 0 || vb < 0) throw new Exception ("!ERROR No existe vertice.");

		for (int i = 0; vertices[va].lad.obtener(i) != null; i++) {
			if (((Arista) vertices[va].lad.obtener(i)).getDestino() == vb) {
				return (int) ((Arista) vertices[va].lad.obtener(i)).getPeso();
			}
		}

		return 0;
	}

	public void conexiones(String desde) throws Exception {
		int v;
		v = numVertice(desde);

		if (v < 0) throw new Exception ("!ERROR No existe vertice.");

		for (int i = 0; vertices[v].lad.obtener(i) != null; i++) {
			System.out.println(v + "->" + vertices[v].lad.obtener(i));
		} System.out.println();   // salto de linea
	}

	public int distancia(String desde, String hasta) throws Exception {
		int va, vb;
		va = numVertice(desde);
		vb = numVertice(hasta);

		if (va < 0 || vb < 0) throw new Exception ("!ERROR No existe vertice.");

		if (existeArista(va, vb)) {
			return (int)((Arista)vertices[va].lad.obtener(vb)).getPeso();
		}

		int peso = 0;
		Cola cola = new Cola();
		Arista arista;
		int v = va;
		do {
			for (int i = 0; vertices[v].lad.obtener(i) != null; i++) {
				cola.encolar(vertices[v].lad.obtener(i));
			}

			if (existeArista(v, ((Arista)cola.obtenerCabeza()).getDestino())) {
				peso += ((Arista)cola.obtenerCabeza()).getPeso();
			}

			arista = ((Arista)cola.quitar());
			v = arista.getDestino();
		} while (!cola.vacia() && !existeArista(v, vb));

		if (existeArista(v, vb)) {
			peso += obtenerPeso(v,vb);
		} else {
			peso = -1;
		}

		return peso;
	}


	/**
	 * Imprime por pantalla los nombres de los vertices obtenidos como resultado
	 * de recorrer el grafo en profundidad.
	 * Como resultado, se obtiene imprimido por pantalla los nombres de los vertices
	 * en el orden que se han recorrido en el grafo.
	 * */
	public void recorrerProfundidad(String verticeOrigen) throws Exception {
		int v;
		v = numVertice(verticeOrigen);
		if (v < 0) throw new Exception("!ERROR No existe vertice de origen.");

		System.out.print("El resultado de recorrer en profundidad es: ");

		int w = v;
		int [] m = new int[numVerts];
		PilaArray pila = new PilaArray();

		// inicializa los vertices como no marcados
		for (int i = 0; i < numVerts; i++) {
			// se inicializan las posiciones m[i] al valor clave que expresa el v�rtice no marcado
			m[i] = 0;
		}
		m[v] = 1;

		pila.insertar(new Integer(v));
		System.out.print(verticeOrigen + " ");

		while (!pila.vacia()) {
			Integer cw;
			cw = (Integer) pila.quitar();
			w = cw.intValue();

			// inserta en la pila los adyacentes de w no marcados
			for (int u = 0; vertices[w].lad.obtener(u) != null; u++) {
				if ((m[(((Arista) vertices[w].lad.obtener(u)).getDestino())] == 0)) {
					//se marca vertice
					pila.insertar(new Integer((((Arista) vertices[w].lad.obtener(u)).getDestino())));
					m[(((Arista) vertices[w].lad.obtener(u)).getDestino())] = 1;
				}
			}
		}

		for (int i = 0; i < numVerts; i++) {
			if (m[i] == 1 && i != v) {
				System.out.print(vertices[i] + " ");
			}
		}

		System.out.println("\n");   // salto de linea
	}

	/**
	 * Imprime por pantalla si dos ciudades (origen y destino) estan conectadas
	 * de forma directa (son adyacentes) o estan conectadas mediante una ciudad.
	 * En caso de estar conectadas, tambien se imprimira por pantalla la distan-
	 * cia entre las ciudades.
	 * */
	public void conectadas(String desde, String hasta) throws Exception {
		if (distancia(desde, hasta) == -1) {
			System.out.println(desde + " y " + hasta + " no estan conectadas"
					+ "\n");
		} else {
			System.out.println(desde + " y " + hasta + " estan conectadas. "
				+ "Distancia: " + distancia(desde, hasta)
				+ "\n");
		}
	}
}
