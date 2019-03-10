/**
 *  Jugador.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Juego;

public class Jugador {
	private String nombre; // nombre del jugador
	private int edad;	   // edad del jugador
	private int puntos;	   // puntos del jugador

	public Jugador(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.puntos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void sumarPunto() {
		this.puntos++;
	}
}
