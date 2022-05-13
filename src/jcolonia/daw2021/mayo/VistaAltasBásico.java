package jcolonia.daw2021.mayo;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Clase que contiene los metodos necesarios para agregar nuevos numeros
 * de coma flotante que despues se almacenaran en un conjunto de numeros
 * almacenados en una variable de tipo {@link ListaNúmeros}.
 * 
 * @versión 2022.5.13
 * @author <a href="joaquinj.oviher@educa.jcyl.es">Joaquin J. Oviedo</a>
 */
public class VistaAltasBásico{
	
	/**
	 * Variable que almacena la entrada de datos por defecto.
	 */
	private Scanner sc;
	
	/**
	 * Constructor de la clase {@link VistaAltasBásico} que asigna la entrada de datos por defecto utlizada
	 * en el resto del programa a una varible de tipo {@link Scanner}.
	 * 
	 * @param sc La variable correspondiente.
	 */
	public VistaAltasBásico(Scanner sc) {
		this.sc =sc;
	}
	
	/**
	 * Pide al usuario que introduzca un nuevo valor numerico que sera almacenado
	 * al conjunto de numero que contiene una variable de tipo {@link ListaNúmeros}.
	 * 
	 * @param conjunto La variable correspondiente de tipo {@link ListaNúmeros}.
	 */
	public void pedirNuevoValor(ListaNúmeros conjunto) {
		String línea = "";
		boolean exit = false;
		
		out.println();
		out.printf("\t   ┌----------------┐%n");
		out.printf("\t   |  Agregar valor |%n");
		out.printf("\t   └----------------┘%n");
		
		while(!exit)
		{
			out.println();
			out.printf("> Introduzca un nuevo valor:");
			línea = sc.nextLine();
			
			try {
				conjunto.add(línea);
				exit = true;
			} catch (SumatorioNumberException e) {
				// TODO Bloque catch generado automáticamente
				out.printf("Excepcion capturada:  %s%n", e.getLocalizedMessage());
				out.printf("\t El Valor introducido debe de ser un numero flotante y sin superar el numeros maximo de decimales permitidos.%n");
			}
		}
	}
	
}	