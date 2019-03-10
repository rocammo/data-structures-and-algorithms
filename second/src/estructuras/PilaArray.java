/**
 *  PilaArray.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   13 ene. 2019
*/

package estructuras;

public class PilaArray
{
	private int cima;

	public int TAM_PILA = 32;
	private Object listaPila[];

	public PilaArray()
	{
		this.cima = -1;
		this.listaPila = new Object[TAM_PILA];
	}


	/* Implementacion de las operaciones */

	public void insertar(Object elemento) throws Exception
	{
		if (llena())
			throw new Exception("La pila esta completa. Desbordamiento.");

		// incrementar puntero cima y copia elemento
		cima++;
		listaPila[cima] = elemento;
	}

	public Object quitar() throws Exception
	{
		if (vacia())
			throw new Exception("La pila esta vacia.");

		Object temp = listaPila[cima];

		cima--;

		return temp;
	}

	public boolean vacia()
	{
		return cima == -1;
	}

	public boolean llena()
	{
		return cima == (TAM_PILA - 1);
	}

	public void limpiar()
	{
		this.cima = -1;
	}

	public int cima()
	{
		return cima;
	}

	public int dimension()
	{
		return TAM_PILA;
	}

	public String mostrar() throws Exception
	{
		String datos = "";

		if (vacia())
			throw new Exception("La pila esta vacia.");

		for (int i = 0; i <= cima; i++) {
			datos += listaPila[i] + ", ";
		} datos = datos.substring(0, datos.length() - 2);


		return ("{ " + datos + " }");
	}
}
