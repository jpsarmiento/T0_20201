package view;

import model.data_structures.ArregloDinamico;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Crear Arreglo Dinamico de elementos");
			System.out.println("2. Agregar elemento");
			System.out.println("3. Buscar elemento");
			System.out.println("4. Eliminar elemento");
			System.out.println("5. Imprimir el Arreglo");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
			ArregloDinamico data = modelo.darDatos();
			String rta = "";
			for(int i = 0; i < data.darTamano(); i++)
			{
				data.darElemento(i);
			}
		}
}
