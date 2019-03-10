/**
 *  Arista.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package estructuras.listaAdyacencia;

public class Arista {
	private int destino;
	private double peso;

	public Arista(int d) {
		this.destino = d;
	}

	public Arista(int d, double p) {
		this(d);
		this.peso = p;
	}

	public boolean equals(Object n) {
		Arista a = (Arista) n;
		return destino == a.destino;
	}

	public String toString() {
		return destino + "( "+ peso + " )";
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
