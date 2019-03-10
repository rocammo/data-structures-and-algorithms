/**
 *  Principal.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package principal;

import estructuras.listaAdyacencia.GrafoAdcia;

public class Principal {
	public static void main(String[] args) throws Exception {
		GrafoAdcia grafo = new GrafoAdcia(6);

		grafo.nuevoVertice("Huesca");
		grafo.nuevoVertice("Zaragoza");
		grafo.nuevoVertice("Barcelona");
		grafo.nuevoVertice("Madrid");
		grafo.nuevoVertice("Valencia");
		grafo.nuevoVertice("Alicante");

		grafo.nuevaArista("Huesca", "Zaragoza", 100);
		grafo.nuevaArista("Zaragoza", "Barcelona", 300);
		grafo.nuevaArista("Madrid", "Zaragoza", 300);
		grafo.nuevaArista("Madrid", "Valencia", 300);
		grafo.nuevaArista("Valencia", "Alicante", 200);

		grafo.recorrerProfundidad("Madrid");

		grafo.conectadas("Valencia", "Madrid");
		grafo.conectadas("Madrid", "Alicante");
	}
}
