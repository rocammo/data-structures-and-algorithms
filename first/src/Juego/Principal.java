/**
 *  Principal.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Juego;

public class Principal {
	public static void main(String[] args) {
		Juego laIsla = new Juego("La isla EDA"); // crea el juego con nombre: La isla EDA

		laIsla.recibirJugador(new Jugador("Pedro", 19), 0); // recibe al jugador con nombre Pedro, prioridad normal
		laIsla.recibirJugador(new Jugador("Mario", 20), 0); // recbie al jugador con nombre Mario, prioridad normal
		laIsla.recibirJugador(new Jugador("Elena", 17), 1); // recibe al jugador con nombre Elena, prioridad premium

		laIsla.iniciar(); // inicia el juego
	}
}
