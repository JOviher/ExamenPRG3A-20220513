package jcolonia.daw2021.mayo;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Clase que contiene los metodos necesarios para crear y mostrar un 
 * menu de opciones, que se capaz de pedir al usuario entrada de datos.
 * 
 * @versión 2022.5.13
 * @author <a href="joaquinj.oviher@educa.jcyl.es">Joaquin J. Oviedo</a>
 */
public class VistaMenúBásico {
	
	/**
	 * Variable que almacena la entrada de datos por defecto.
	 */
	private Scanner sc;
	
	/**
	 * Conjunto de textos que comprenden las diferentes opciones del Menu a crear.
	 */
	private String[] arrayOpcionesMenu;
	
	/**
	 * Texto que contiene el nombre que se le quiere dar a dicho Menu.
	 */
	private String tituloMenu;
	
	/**
	 * Numero entero que corresponde a la eleccion realizado por el usuario de dicho Menu.
	 */
	private int opciónElegida;
	
	/**
	 * Constructor de la clase {@link VistaMenúBásico} que almacena el titulo del menu,
	 * la entrada de datos por defecto de todo el programa, y el conjunto de opciones del Menu ha crear.
	 * 
	 * @param titulo Titulo de dicho Menu
	 * @param sc Entrada por defecto utilizada en el resto del programa.
	 * @param textoOpciones Conjunto de cadenas de texto que describen la opciones de las que dispone el Menu.
	 */
	public VistaMenúBásico(String titulo, Scanner sc, String[] textoOpciones) {
		this.sc=sc;
		this.tituloMenu = titulo;
		
		arrayOpcionesMenu = new String[textoOpciones.length];
		for(int i = 0; i < textoOpciones.length; i++)
		{
			arrayOpcionesMenu[i]= textoOpciones[i];
		}
	}
	
	/**
	 * Imprime por pantalla el contenido de la variable {@link #tituloMenu} que corresponde
	 * al titulo del Menu creado, con el primer formato por defecto de salida.
	 * 
	 * <pre>
	 *                       ┌──────────────────────────┐
	 * ══════════════════════┤  Titulo Correspondiente  ├══════════════════════
	 *                       └──────────────────────────┘
	 * </pre>
	 */
	public void mostrarTítulo1() {
		out.printf("                      ┌───────────────────────┐%n");
		out.printf("══════════════════════┤ %-20s  ├══════════════════════%n", tituloMenu);
		out.printf("                      └───────────────────────┘%n%n");
	}
	
	/**
	 * Imprime por pantalla el contenido de la variable {@link #tituloMenu} que corresponde
	 * al titulo del Menu creado, con el segundo formato por defecto de salida.
	 * 
	 * <pre>
	 * \\
	 * ----- Titulo Correspondiente
	 * //
	 * </pre>
	 */
	public void mostrarTítulo2() {
		out.printf("%n%n\\\\%n");
		out.printf("-----   %-16s%n", tituloMenu);
		out.printf("//%n%n");
	}
	
	/**
	 * Muestra el texto proporcianado por la consola de texto.
	 * 
	 * @param texto Cadena de texto correspondiente que se desea imprimir por pantalla.
	 */
	public final void mostrarTexto(String texto) {
		out.println(texto);
	}
	
	/**
	 * Lista todas la opciones almacenadas en el conjunto de cadenas de texto de la variable {@link #arrayOpcionesMenu}
	 * precediendolas de un nuemero que representara dicha opcion.
	 * 
	 * <pre>
	 * 			  ┌--------------┐
	 * 			  |  Opciones    |
	 * 		   ┌--┴--------------┴------------------------┐
	 * 		   │                                          │
	 * 		   │   1.- «Opcion1»                          │
	 * 		   │                                          │
	 * 		   │   2.- «Opcion2»                          │
	 * 		   │                                          │
	 * 		   │   3.- «Opcion3»                          │
	 * 		   │                                          │
	 * 		   ╚══════════════════════════════════════════╝
	 * </pre>
	 */
	public void mostrarOpciones() {
		out.printf("\t   ┌--------------┐%n");
		out.printf("\t   |  Opciones    |%n");
		out.printf("\t┌--┴--------------┴------------------------┐%n");
		out.printf("\t│                                          │%n");
		for(int i=0; i<arrayOpcionesMenu.length; i++)
		{
			out.printf("\t│  %2d.- «%-32s  │%n", (i+1), arrayOpcionesMenu[i] + "»");
			
			out.printf("\t│                                          │%n");
		}
		out.printf("\t╚══════════════════════════════════════════╝%n");
		out.println();
	}
	
	/**
	 * Pide al usuario que introduzca un numero entero que corresponde a las opciones
	 * mostradas previamente en {@link #mostrarOpciones()} si este valor no es correcto o supera
	 * el numero de opciones disponibles pedira al usuario una nueva entrada hasta que esta sea valida.
	 * 
	 * @return Dicho valor numerico que hacer referencia a una de las opciones disponibles.
	 */
	public int pedirOpción() {
		String línea;
		boolean salir=false;
		
		while(!salir) {
			try {
				out.println();
				out.printf(" --> _");
				línea=sc.nextLine();
				opciónElegida=Integer.parseInt(línea);
				if(opciónElegida>arrayOpcionesMenu.length) {
					out.println("Esta opcion no es valida.");
				} else {
					salir=true;
				}
			} catch(NumberFormatException ex){
				out.printf("\tNo es una de las opciones validas <<%s>>%n", ex.getMessage());
			}
		}	
		
		return opciónElegida;
	}
	
	/**
	 * Para la ejecucion del programa hasta que el usuario presione la tecla Enter
	 * cuando este desee continuar.
	 */
	public void pedirContinuar() {
		String wait;
		try {
			out.printf("%nPresione Enter para continuar ....");
			wait=sc.nextLine();
		} catch(NumberFormatException ex) {}
	}
	
}
