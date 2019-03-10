/**
 *  Libro.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   08 ene. 2019
*/

package biblioteca;

public class Libro {
	private long numero;
	private String titulo;
	private boolean prestado;

	public Libro(long numero, String titulo) {
		this.numero = numero;
		this.titulo = titulo;
		this.prestado = false;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
}
