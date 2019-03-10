/**
 *  ListaEnlazadaCircular.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   9 nov. 2018
*/

package Estructuras;

import Juego.Jugador;

public class ListaEnlazadaCircular
{
	private Nodo ultimo;
	private int dimension;

	public ListaEnlazadaCircular()
	{
		this.ultimo = null;
		this.dimension = 0;
	}

	public void agregar(Jugador jugador) {
		Nodo nuevo = new Nodo(jugador);

		if (ultimo == null) {
			nuevo.siguiente = nuevo;
			ultimo = nuevo;
		} else {
			nuevo.siguiente = ultimo.siguiente;
			ultimo.siguiente = nuevo;
		}

		dimension++;
	}

	public void liberar() {
		if (ultimo.siguiente == ultimo) {
			ultimo = null;
		} else {
			ultimo.siguiente = ultimo.siguiente.siguiente;
		}

		dimension--;
	}

	public void liberar(Jugador jugador)
	{
		Nodo puntero = ultimo;
		do {
			if (puntero.siguiente.dato == jugador) {
				if (puntero.siguiente == ultimo) {
					puntero.siguiente = puntero.siguiente.siguiente;
					ultimo = puntero;
				} else {
					puntero.siguiente = puntero.siguiente.siguiente;
				}
			} else {
				puntero = puntero.siguiente;
			}
		} while (puntero != ultimo);

		dimension--;
	}

	public boolean vacia() {
		return (ultimo == null);
	}

	public int numeroJugadores() {
		return dimension;
	}

	public Jugador obtener(int referencia) {
        if (ultimo == null) {
        	return null;
        }

		Nodo puntero = ultimo;
        Jugador[] jugadores = new Jugador[dimension];
        int it = 0;

        do {
            jugadores[it] = ((Jugador) puntero.siguiente.dato);
            puntero = puntero.siguiente;
            it++;
        } while (puntero != ultimo);

    	// invierte el vector
        for (int i = 0; i < jugadores.length / 2; i++) {
        	  Jugador temp = jugadores[i];
        	  jugadores[i] = jugadores[jugadores.length -i -1];
        	  jugadores[jugadores.length -i -1] = temp;
        }

        return jugadores[referencia];
	}
}
