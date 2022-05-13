package jcolonia.daw2021.mayo;

import java.util.Scanner;

/**
 * Gestión de números «decimales»: recogida y visualización de la suma.
 * 
 * @versión 2022.3.1
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 */
public class ControlSumatorio {
	/**
	 * Texto identificativo de las funciones de la aplicación que aparecerán en el
	 * menú principal.
	 */
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Agregar valor", "Mostrar valores", "Mostrar suma",
			"Restablecer", "SALIR" };

	/**
	 * Título de la aplicación. Se mostrará como encabezado del menú principal.
	 */
	private static final String TÍTULO_MENÚ_PRINCIPAL = "Sumatorio";

	/**
	 * Recurso asociado a la entrada estándar de la aplicación. Debe ser un objeto
	 * único a compartir con las diferentes vistas creadas.
	 */
	private Scanner entrada;

	/**
	 * Conjunto de numeros decimales a almacenar de tipo {@link ListaNúmeros}.
	 */
	private ListaNúmeros conjunto;

	/**
	 * Variable que almacena el acceso a la clase que proporciona el Menu Principal.
	 */
	private VistaMenúBásico menúPrincipal;

	/**
	 * Constructor de la clase control, que crea una nueva {@link ListaNúmeros},
	 * y guarda una entrada por defecto.
	 * 
	 * @param in
	 */
	public ControlSumatorio(Scanner in) {
		this.entrada = in;
		conjunto = new ListaNúmeros();
	}

	/**
	 * El Bucle Principal de la aplicacion que contiene todas
	 * las divisiones logicas para el corrector funcionamiento del programa.
	 */
	private void buclePrincipal() {
		int opciónElegida;
		boolean fin = false;

		menúPrincipal = new VistaMenúBásico(TÍTULO_MENÚ_PRINCIPAL, entrada, OPCIONES_MENÚ_PRINCIPAL);

		// Bucle general
		do {
			menúPrincipal.mostrarTítulo1();
			menúPrincipal.mostrarOpciones();
			opciónElegida = menúPrincipal.pedirOpción();
			switch (opciónElegida) {
			case 5: // SALIR
				fin = true;
				Vista.mostrarAviso("¡¡¡A-D-I-O-S!!");
				break;
			case 1: // Opción 1: Entrada datos
				cargarSumando();
				break;
			case 2: // Opción 2: Mostrar sumandos
				mostrarSumandos();
				menúPrincipal.pedirContinuar();
				break;
			case 3: // Opción 3: Mostrar suma
				mostrarSuma();
				menúPrincipal.pedirContinuar();
				break;
			case 4: // Opción 4: Reset
				restablecer();
				break;
			default: // Opción no esperada: abortar
				ejecutarGenérico(opciónElegida);
				System.err.println("Error interno de programa - operación pendiente de desarrollo");
				System.exit(1);
			}
		} while (!fin);
	}

	/**
	 * Llama a la clase {@link VistaAltasBásico}, para pedir al usuario
	 * que introduzca un nuevo valor decimal valido a la {@link ListaNúmeros} almacenada.
	 */
	private void cargarSumando() {
		VistaAltasBásico vAltas;
		vAltas = new VistaAltasBásico(entrada);
		
		vAltas.pedirNuevoValor(conjunto);
	}
	
	/**
	 * Llama a la clase {@link VistaListadoBásico}, con el fin de mostrar por la 
	 * consola de texto todos los valores almacenados en el conjunto {@link ListaNúmeros}.
	 */
	private void mostrarSumandos() {
		VistaListadoBásico vListado;
		vListado = new VistaListadoBásico(entrada);
		
		vListado.listadoSumados(conjunto);
	}
	
	/**
	 * Llama a la clase {@link VistaListadoBásico}, para mostrar por medio de la consola de texto
	 * la suma correspondiente de todos los valores almacenados en el conjunto {@link ListaNúmeros}
	 * siguiendo su formato de salida predefinido.
	 */
	private void mostrarSuma() {
		VistaListadoBásico vListado;
		vListado = new VistaListadoBásico(entrada);
		
		vListado.listarSuma(conjunto);
	}
	
	/**
	 * Crea y asigna una nueva {@link ListaNúmeros} a la variable {@link #conjunto},
	 * eliminando de esta forma todos los valores previamente almacenados.
	 */
	private void restablecer() {
		conjunto = new ListaNúmeros();
	}
	
	/**
	 * Si el metodo {@link #buclePrincipal()} no tiene ningun codigo preparado para la eleccion del usuario,
	 * este metodo ejecutara un codigo por defecto que mostrara la opcion del menu a la que corresponde dicha opcion.
	 * 
	 * @param id La opcion Elegida por el usuario que no se encuentra definida en el metodo {@link #buclePrincipal()}.
	 */
	private void ejecutarGenérico(int id) {
		String mensaje;
		mensaje = String.format("%n  Ha elegido la opción %d: «%s»", id, OPCIONES_MENÚ_PRINCIPAL[id - 1]);
		Vista.mostrarTexto(mensaje);
	}

	/**
	 * Metodo principal que establece un nuevo objeto {@link ControlSumatorio}, 
	 * y establece una entrada por defecto de tipo {@link Scanner}, llamando despues al metodo
	 * buclePrincipal que contiene la logica del Programa.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		ControlSumatorio control = new ControlSumatorio(entrada);
		control.buclePrincipal();
		entrada.close();
	}
}
