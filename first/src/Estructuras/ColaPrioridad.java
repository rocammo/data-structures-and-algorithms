/**
 *  ColaPrioridad.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Estructuras;

import Estructuras.Cola;
import Juego.Jugador;

public class ColaPrioridad {
	private Cola arrayPrioridad[];

	public ColaPrioridad(int dimension) {
		arrayPrioridad = new Cola[dimension];

		for (int i = 0; i < arrayPrioridad.length; i++) {
			arrayPrioridad[i] = new Cola();
		}
	}

	public void agregar(Jugador jugador, int prioridad) {
		arrayPrioridad[prioridad].encolar(jugador);

		System.out.println("Llegada de " + jugador.getNombre() + ", prioridad " + tipoPrioridad(prioridad));
	}

	public Jugador obtener() {
		Jugador objetoObtenido = null;
		for (int i = 0; i < arrayPrioridad.length; i++) {
			if (!arrayPrioridad[i].vacia()) {
				objetoObtenido = (Jugador) arrayPrioridad[i].obtenerPrimero();
			}
		}
		return objetoObtenido;
	}

	public void liberar() {
		for (int i = arrayPrioridad.length - 1; i >= 0; i--) {
			if (!arrayPrioridad[i].vacia()) {
				arrayPrioridad[i].quitar();
				break;
			}
		}
	}

	public boolean todasVacias() {
		boolean todasVacias = true;

		for (int i = 0; i < arrayPrioridad.length; i++) {
			if (!arrayPrioridad[i].vacia()) {
				todasVacias = false;
			}
		}

		return todasVacias;
	}

	private String tipoPrioridad(int prioridad) {
		boolean b = (prioridad != 0);
		String tipoPrioridad = b ? "premium" : "normal"; // 1: prioridad premium, 0: prioridad normal
		return tipoPrioridad;
	}
}
