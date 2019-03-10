/**
 *  Biblioteca.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   08 ene. 2019
*/

package biblioteca;

import estructuras.TablaDispersa;

import estructuras.QuickSort;
import estructuras.Lista;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private TablaDispersa almacen;

	private int numeroTitulos;
	private Lista titulosDisponibles;

	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.almacen = new TablaDispersa();

		this.numeroTitulos = 0;
		this.titulosDisponibles = new Lista();

		System.out.println(nombre + " ha sido creado");
	}

	/**
	 * El sistema solicita por pantalla los datos del libro y si los datos se
	 * han introducido correctamente, el libro se guarda en la biblioteca.
	 * Se mostrará un aviso por pantalla si el número del libro añadido ya existe
	 * previamente en la biblioteca. En este caso, el libro no se almacena en
	 * la biblioteca.
	 * */
	public void insertarLibro() {
		long numero;
		do {
			System.out.print("Introduzca, por favor, el ISBN del libro (6 d�gitos): ");
			numero = Principal.entrada().nextInt();
		} while ((int)(Math.log10(numero) + 1) != 6);
		if (almacen.buscar(numero) != null) {
			System.err.println("�AVISO! El libro '" + almacen.buscar(numero).getTitulo() + "' ya est� en la biblioteca.");
			return;
		}

		System.out.print("Introduzca, por favor, el t�tulo del libro: ");
		String titulo = Principal.entrada().nextLine();

		almacen.insertar(new Libro(numero, titulo));
		System.out.println("El libro '" + almacen.buscar(numero).getTitulo() + "' ha sido a�adido con �xito.");
	}

	/**
	 * El sistema solicita por pantalla el numero del libro a prestar. Si el libro
	 * esta en la biblioteca, el atributo prestado del libro cambiara a prestado.
	 * Se mostrara un aviso por pantalla si el numero de libro no se encuentra
	 * en la biblioteca o si ya esta prestado.
	 * */
	public void registrarPrestamo() {
		System.out.print("Introduzca, por favor, el ISBN del libro: ");
		long numero = Principal.entrada().nextInt();
		if (almacen.buscar(numero) == null) {
			System.err.println("�AVISO! El libro que intentas prestar no se encuentra actualmente en la biblioteca.");
			return;
		} else if (almacen.buscar(numero).isPrestado()) {
			System.err.println("�AVISO! El libro '" + almacen.buscar(numero).getTitulo() + "' est� prestado actualmente.");
			return;
		}

		almacen.buscar(numero).setPrestado(true);
		System.out.println("El libro '" + almacen.buscar(numero).getTitulo() + "' ha sido prestado con �xito.");
	}

	/**
	 * El sistema solicita por pantalla el numero del libro a devolver. Si el libro
	 * esta en la biblioteca, el atributo prestado del libro cambiara a no prestado.
	 * Se mostrara un aviso por pantalla si el numero de libro no se encuentra
	 * en la biblioteca o no estaba prestado.
	 * */
	public void registrarDevolucion() {
		System.out.print("Introduzca, por favor, el ISBN del libro: ");
		long numero = Principal.entrada().nextInt();
		if (almacen.buscar(numero) == null) {
			System.err.println("�AVISO! El libro que intentas devolver nunca ha sido prestado por la biblioteca.");
			return;
		} else if (!almacen.buscar(numero).isPrestado()) {
			System.err.println("�AVISO! El libro '" + almacen.buscar(numero).getTitulo() + "' no estaba prestado.");
			return;
		}

		almacen.buscar(numero).setPrestado(false);
		System.out.println("El libro '" + almacen.buscar(numero).getTitulo() + "' ha sido devuelto con �xito.");
	}

	/**
	 * El sistema solicita por pantalla el numero del libro a borrar. Si el libro
	 * esta en la biblioteca, se elimina.
	 * Se mostrara un aviso por pantalla si el libro a borrar no existe en la biblioteca.
	 * */
	public void eliminarLibro() {
		System.out.print("Introduzca, por favor, el ISBN del libro: ");
		long numero = Principal.entrada().nextInt();
		if (almacen.buscar(numero) == null) {
			System.err.println("�AVISO! El libro que intentas borrar no est� en la biblioteca.");
			return;
		}

		System.out.println("El libro '" + almacen.buscar(numero).getTitulo() + "' ha sido borrado con �xito.");
		almacen.eliminar(numero);
	}

	/**
	 * Imprime por pantalla el titulo de los libros disponibles (no prestados)
	 * ordenados de manera alfabetica ascendente (A-Z).
	 * */
	public void imprimirTitulosDisponibles() {
		// Ordenacion utilizando el algoritmo QuickSort
		Libro[] libros = almacen.obtenerTodos();
		numeroTitulos = 0;
		while (libros[numeroTitulos] != null) {
			numeroTitulos++;
		}
		QuickSort.quickSort(libros, 0, numeroTitulos - 1);

		// Guarda los titulos disponibles en la lista enlazada simple
		if (!titulosDisponibles.esVacia()) {
			titulosDisponibles.anula();
		}
		for (int i = 0; libros[i] != null; i++) {
			titulosDisponibles.insertarFinal(libros[i]);
		}
		if (titulosDisponibles.esVacia()) System.out.println("No hay ning�n libro disponible actualmente.");

		// Imprime el titulo de cada libro incluido en la lista usando recursion
		mostrarLibro(0);
	}

	private void mostrarLibro(int indice) {
		if (titulosDisponibles.obtener(indice) == null) {
			return;
		}

		System.out.println((indice + 1) + ". " + ((Libro)titulosDisponibles.obtener(indice)).getTitulo() + " (ISBN: "
											   + ((Libro)titulosDisponibles.obtener(indice)).getNumero() + ")");
		mostrarLibro(indice + 1);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
