package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Juego;
import ar.edu.unlam.pb1.dominio.Jugador;
import ar.edu.unlam.pb1.dominio.MenuAdministrador;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;

public class PiedraPapelTijera {
	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		mostrarPorPantalla("Piedra papel o tijera!");
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;
		Juego piedraPapelTijera = new Juego();

		do {
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEnteroValidado("Seleccione una opcion.", 1, 2);

			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case JUGAR:
				jugar(piedraPapelTijera);
				break;
			case STATS:
				gestionarEstadisticas(piedraPapelTijera);
				break;
			case SALIR:
				break;
			}

			// Completar la condicion para continuar
		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void jugar(Juego piedraPapelTijera) {
		// Ingrese la cantidad de rondas validando que sea al menos 1 y siempre impar
		// Ingresar el jugador uno
		// Ingresar el jugador dos
		// Jugar
		// Mostrar al ganador
		int rondas;
		Jugador jugadorUno;
		Jugador jugadorDos;
		Jugador ganador;
		String mensaje1 = "Ingrese la cantidad de rondas a jugar.";
		mostrarPorPantalla(mensaje1);
		rondas = teclado.nextInt();
		boolean validarRondas = Juego.validarRondas(rondas);
		if (validarRondas) {
			jugadorUno = ingresarJugador("Ingrese el jugador uno", piedraPapelTijera);
			jugadorDos = ingresarJugador("Ingrese el jugador dos", piedraPapelTijera);
			ganador = piedraPapelTijera.jugar(jugadorUno, jugadorDos, rondas);
			mostrarPorPantalla("El ganador del piedra,papel o tijera fue" + ganador.toString());
		} else {
			mostrarPorPantalla("Error rondas invalidas.");
		}
	}

	private static void gestionarEstadisticas(Juego piedraPapelTijera) {
		// Mostrar el menu de estadisticas
		// Ingresar un numero validado entre 1 y 3
		// En caso de seleccionar Tabla actual, mostrar la tabla de jugadores ordenados
		// por puntos de manera descendente
		// En caso de ver el promedio de puntajes, solicitarlo al juego y mostrarlo

		int opcion = 0;
		Jugador[] jugadoresOrdenados;
		double promedioPuntajeJugadores = 0.0;
		MenuAdministrador menuAdmin = null;
		String mensaje = "Seleccione una opcion\n 1-Ver tabla actual.\n 2-Ver el promedio de puntaje de los jugadores.\n 3-Volver";
		opcion = ingresarNumeroEnteroValidado(mensaje, 1, 3);
		menuAdmin = obtenerOpcionDeMenuAdministrador(opcion);
		switch (menuAdmin) {
		case VER_TABLA_ACTUAL:
			String mensaje2 = "El puntaje de los jugadores es el siguiente.";
			jugadoresOrdenados = piedraPapelTijera.obtenerJugadoresOrdenadosPorPuntajeDescendente();
			mostrarTablaJugadores(mensaje2, jugadoresOrdenados);
			break;
		case VER_PROMEDIO_PUNTAJES:
			promedioPuntajeJugadores = piedraPapelTijera.obtenerPromedioPuntaje();
			mostrarPorPantalla(
					"El promedio de puntajes de los jugadores es de " + promedioPuntajeJugadores + " puntos.");
			break;
		case VOLVER:

			break;
		}
	}

	private static void mostrarTablaJugadores(String mensaje, Jugador[] jugadores) {
		mostrarPorPantalla(mensaje);

		for (int i = 0; i < jugadores.length; i++) {

			if (jugadores[i] != null) {
				mostrarPorPantalla("\n" + jugadores[i].toString());
			}

		}
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// Obtener la opcion del menu correspondiente al valor ingresado
		MenuPrincipal main = MenuPrincipal.values()[numeroIngresado - 1];
		return main;
	}

	private static MenuAdministrador obtenerOpcionDeMenuAdministrador(int numeroIngresado) {
		// Obtener la opcion del menu correspondiente al valor ingresado
		MenuAdministrador menuAdmin = MenuAdministrador.values()[numeroIngresado - 1];
		return menuAdmin;
	}

	private static int ingresarNumeroEnteroValidado(String mensaje, int valorMinimo, int valorMaximo) {
		// Mostrar el mensaje por pantalla y validar el numero ingresado para que este
		// dentro de los parametros

		int opcion;
		do {
			mostrarPorPantalla(mensaje);
			opcion = teclado.nextInt();
		} while (opcion < valorMinimo && opcion > valorMaximo);
		return opcion;
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla("\n\n1 -> Jugar 1 vs 1\n2 -> Ver stats\n3 -> Salir");
	}

	private static void mostrarMenuStats() {
		mostrarPorPantalla("\n\n1 -> Tabla actual\n2 -> Promedio de puntaje\n3 -> Volver");
	}

	private static Jugador ingresarJugador(String mensaje, Juego piedraPapelTijera) {
		// Solicitar el nombre del jugador
		// Obtener el jugador mediante el metodo
		// piedraPapelTijera.obtenerPorNombre(nombreJugador)
		// Si el jugador no existe, entonces instanciar un nuevo jugador, solicitando el
		// proximo id al juego
		String nombre;
		Jugador encontrado = null;
		mostrarPorPantalla("Ingrese el nombre del jugador.");
		nombre = teclado.next();
		encontrado = piedraPapelTijera.obtenerPorNombre(nombre);

		if (encontrado == null) {
			mostrarPorPantalla("Jugador creado.");
			encontrado = new Jugador(Juego.obtenerSiguienteId(), nombre);
		} else if (encontrado != null) {
			mostrarPorPantalla("Jugador encontrado");
		}

		return encontrado;
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}
