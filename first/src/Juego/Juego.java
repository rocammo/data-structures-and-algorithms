/**
 *  Juego.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Juego;

import java.util.Random;
import java.util.Scanner;

import Estructuras.ColaPrioridad;
import Estructuras.ListaEnlazadaCircular;

@SuppressWarnings({"unused", "resource"})
public class Juego {
	private String nombre;

	private ColaPrioridad cola;
	private ListaEnlazadaCircular lista;

	private int[][] panel;
	private final int AGUA = 0, TIERRA = 1;
	private int turno = 0;
	private boolean ganador = false;

	public Juego(String nombre) {
		this.nombre = nombre;				 // nombre del juego

		cola = new ColaPrioridad(20); 		 // recibe los jugadores
		lista = new ListaEnlazadaCircular(); // contiene los jugadores

		panel = new int[5][5]; 				 // panel de juego

		System.out.println(nombre + " ha sido creado.");
	}

	public void recibirJugador(Jugador jugador, int prioridad) {
		cola.agregar(jugador, prioridad);	 // esperando jugadores...
	}

	public void iniciar() {
		/*
		 * van entrando a la partida los jugadores siguiendo el siguiente orden de preferencia:
		 * 	1. orden de prioridad
		 * 	2. orden de llegada
		 * conforme los jugadores entran en la partida, la cola se va liberando
		 */
		while (!cola.todasVacias()) {
			lista.agregar(cola.obtener());
			cola.liberar();
		}

		System.out.println("\n** Se inicia el juego\n\n");
		generarPanel();
		System.out.println("Rango de filas/columnas de 1 a 5");
		while (!ganador) {
			jugar();
		}
		System.out.println("\n*** Fin del juego. El ganador es " + lista.obtener(0).getNombre() +
							" con " + lista.obtener(0).getPuntos() + " puntos.");
		lista.liberar();
	}

	private void jugar() {
		if (!(lista.numeroJugadores() > 1)) {
			ganador = true;
			return;
		}

		int x, y;
		do {
			System.out.print("\nTurno de " + lista.obtener(turno).getNombre() +
							   ". Escribe la posicion x,y del panel: ");

			String[] entrada = new Scanner(System.in).next().split(",");
			x = Integer.valueOf(entrada[0]);
			y = Integer.valueOf(entrada[1]);

			if ((x > 5 || x < 1) || (y > 5 || y < 1)) {
				System.out.println("Error: La posicion no corresponde al panel.");
			}
		} while ((x > 5 || x < 1) || (y > 5 || y < 1));


		if (panel[x-1][y-1] == TIERRA) {
			System.out.println("La posicion [" + x +", " + y + "] contiene tierra, " + lista.obtener(turno).getNombre() + " +1 punto.");
			panel[x-1][y-1] = AGUA;
			lista.obtener(turno).sumarPunto();
			turno++;
		} else {
			System.out.println("La posicion [" + x +", " + y + "] contiene agua, " + lista.obtener(turno).getNombre() + " se va.");
			lista.liberar(lista.obtener(turno));
		}

		if (turno == lista.numeroJugadores()) {
			turno = 0;
		}
	}

	private void generarPanel() {
		Random r = new Random();
		for (int i = 0; i < panel.length; i++) {
			for (int j = 0; j < panel[0].length; j++) {
				panel[i][j] = r.nextInt(2 - 0) + 0;
			}
		}
	}
}
