package jcolonia.daw2021.mayo;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Clase que contiene los metodos necesarios para listar con diferentes formatos
 * el contenido del conjunto de numeros decimales almacenados en una variable de tipo{@link ListaNúmeros},
 * mostrado sus valores o mostrado la operacion por defecto que contiene la suma total de todos sus valores.
 * 
 * @versión 2022.5.13
 * @author <a href="joaquinj.oviher@educa.jcyl.es">Joaquin J. Oviedo</a>
 */
public class VistaListadoBásico {
	
	/**
	 * Variable que almacena la entrada de datos por defecto.
	 */
	private Scanner sc;
	
	/**
	 * Constructor de la clase {@link VistaListadoBásico} que asigna la entrada de datos por defecto utlizada
	 * en el resto del programa a una varible de tipo {@link Scanner}.
	 * 
	 * @param sc La variable correspondiente.
	 */
	public VistaListadoBásico(Scanner sc) {
		this.sc =sc;
	}
	
	/**
	 * Muesta la totalidad de los valores almacenados dentro de la 
	 * variable de tipo {@link ListaNúmeros}.
	 * 
	 * <pre>
	 * 		   ┌----------------------┐
	 * 		   |  Valores almacenados |
	 * 		   └----------------------┘
	 * 		┌--------------┬------------------┐
	 * 		│   Posicion   │  NumeroGuardado  │
	 * 		├--------------┼------------------┤
	 * 		│       1      │   0.5000         │
	 * 		│       2      │   1.0000         │
	 * 		│       3      │   2.2500         │
	 * 		└--------------┴------------------┘
	 * </pre>
	 * 
	 * @param conjunto La variable correspondiente.
	 */
	public void listadoSumados(ListaNúmeros conjunto) {
		out.println();
		out.printf("\t   ┌----------------------┐%n");
		out.printf("\t   |  Valores almacenados |%n");
		out.printf("\t   └----------------------┘%n");
		out.printf("\t┌--------------┬------------------┐%n");
		out.printf("\t│   Posicion   │  NumeroGuardado  │%n");
		out.printf("\t├--------------┼------------------┤%n");
		
		
		for(int i = 0; i < conjunto.toListaString().size(); i++)
		{
			out.printf("\t│      %2d      │  %-15s │%n", (i + 1), conjunto.toListaString().get(i));
		}
		out.printf("\t└--------------┴------------------┘%n");
	}
	
	/**
	 * Muestra el contenido de la varible de tipo {@link ListaNúmeros}, con el formato
	 * por defecto generado automaticamente dentro de la misma clase {@link ListaNúmeros}, mostrado
	 * no solo los valores almacenados sino tambien la suma total de dichos valores.
	 * 
	 * @param conjunto La variable que contiene el conjunto de numero en coma flotante.
	 */
	public void listarSuma(ListaNúmeros conjunto) {
		out.println();
		out.printf("   ┌----------┐%n");
		out.printf("   |   Suma   |%n");
		out.printf("   └----------┘%n");
		out.println(conjunto.toString());
		out.println();
	}
	
}