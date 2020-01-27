package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private String elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new String[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( String dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			String [ ] copia = elementos;
			elementos = new String[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}


	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	public String darElemento(int i) 
	{
		// TODO implementar
		if(i<=tamanoAct)
		{
			System.out.println("El elemento en la posicion " + i + " es: " + elementos[i]);
			return elementos[i];
		}
		else
		{
			System.out.println("No hay ningun elemento en la posicion" + i);
			return null;
		}
	}


	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */
	public String buscar(String dato) 
	{
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		int i = 0;
		while(i< tamanoAct)
		{
			if(elementos[i]!= null && dato.compareTo(elementos[i])==0)
				return elementos[i];
			else
				i++;
		}
		return null;
	}


	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */
	public String eliminar(String dato) 
	{
		for (int i = 0; i < elementos.length; i++) 
		{
			if (elementos[i]!= null && elementos[i].compareTo(dato)==0)
			{
				String eliminado = elementos[i];
				for (int j = i; j < elementos.length - 1; j++) 
				{
					elementos[j] = elementos[j+1];
				}
				String[] nuevo = new String[elementos.length];
				for(int v = 0; v < nuevo.length-1; v++)
				{
					nuevo[v] = elementos[v];
				}
				elementos = nuevo;
				tamanoAct = tamanoAct-1;
				return eliminado;
			}
		}
		return null;
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
	}

}
