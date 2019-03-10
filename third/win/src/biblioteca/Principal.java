/**
 *  Principal.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   08 ene. 2019
*/

package biblioteca;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	private static boolean running = true;

	private static Biblioteca biblioteca;

	public static void main(String[] args) throws IOException {
		biblioteca = new Biblioteca("EDA-library", "Universidad San Jorge");

		while (running) {
			new Principal().run();
		}
	}

	private void run() throws IOException {
		// MENU


		System.out.println("\n\n** BIBLIOTECA");
		System.out.println("    \u0b9f 1. A�adir libro.");
		System.out.println("    \u0b9f 2. Registrar pr�stamo.");
		System.out.println("    \u0b9f 3. Registrar devoluci�n.");
		System.out.println("    \u0b9f 4. Borrar libro.");
		System.out.println("    \u0b9f 5. Imprimir t�tulos disponibles.");
		System.out.println("    \u0b9f 6. Salir.");
		System.out.println();   // salto de linea


		// SELECCION
		int seleccion;

		do {
			System.out.print("$ ");
			seleccion = entrada().nextInt();

			if (seleccion < 1 || seleccion > 6) {
				System.out.println("�ATENCI�N! (1 ~ 6)");
			}
		} while (seleccion < 1 || seleccion > 6);

		switch(seleccion) {
			case 1: // Añadir libro
				biblioteca.insertarLibro();
				break;
			case 2: // Registrar prestamo
				biblioteca.registrarPrestamo();
				break;
			case 3: // Registrar devolucion
				biblioteca.registrarDevolucion();
				break;
			case 4: // Borrar libro
				biblioteca.eliminarLibro();
				break;
			case 5: // Imprimir titulos disponibles
				biblioteca.imprimirTitulosDisponibles();
				break;
			case 6: // Salir
				running = false;
				System.out.println("\n�Hasta pronto!");
				break;
		}
	}

	public static Scanner entrada() {
		return new Scanner(System.in);
	}
}
