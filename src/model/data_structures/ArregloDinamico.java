package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable <T>> implements IArregloDinamico<T> {
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
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico(int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}
	
	@Override
	public T darElemento(int i) 
	{
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
	
	@Override
	public void agregar(T dato) 
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}



	@Override
	public T buscar(T dato)
	{
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


	@Override
	public T eliminar(T dato)
	{
		for (int i = 0; i < elementos.length; i++) 
		{
			if (elementos[i]!= null && elementos[i].compareTo(dato)==0)
			{
				T eliminado = elementos[i];
				for (int j = i; j < elementos.length - 1; j++) 
				{
					elementos[j] = elementos[j+1];
				}
				T[] nuevo = (T[]) new Comparable[elementos.length];
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
	}



}
