package ar.edu.unlam.pb1.dominio;

public class Juego {
	Jugador jugadores[];
	public static int idJugadores = 0;

	public Juego() {
		this.jugadores = new Jugador[100];

	}

	public static int obtenerSiguienteId() {
		idJugadores++;
		return idJugadores;
	}

	public Jugador jugar(Jugador jugadorUno, Jugador jugadorDos, int rondas) {
		// Jugar la cantidad de rondas especificada
		// Determinar el ganador
		// Acumular los puntos al jugador ganador
		// Actualizar los puntos del ganador en el array de ganadores
		int iniciadorRonda = 0;
		int ganadorRonda = 0;
		int acumulador = 1;
		int rondasGanadasJugador1[] = new int[1];
		int rondasGanadasJugador2[] = new int[1];
		Jugador ganador = null;
		// Si da 0 se le suma la ronda al jugadorUno.Si da 1 se le suma la ronda al
		// jugadorDos
		while (iniciadorRonda != rondas) {
			ganadorRonda = (int) (Math.random() * 2);
			if (ganadorRonda == 0) {
				rondasGanadasJugador1[0] += acumulador;
			}
			if (ganadorRonda == 1) {
				rondasGanadasJugador2[0] += acumulador;
			}
			iniciadorRonda++;
		}
		if (rondasGanadasJugador1[0] > rondasGanadasJugador2[0]) {
			ganador = jugadorUno;
			actualizarPuntos(jugadorUno);

		} else if (rondasGanadasJugador1[0] < rondasGanadasJugador2[0]) {
			ganador = jugadorDos;
			actualizarPuntos(jugadorDos);
		}

		return ganador;
	}

	private void actualizarPuntos(Jugador ganador) {
		// Buscar el jugador por id. En caso de existir, asignar al jugador del array
		// los puntos del ganador
		// En caso de no existir, agregar el jugador al array
		int acumular10pts = 10;
		Jugador existeJugadorID = existeJugador(ganador);

		if (existeJugadorID == null) {
			agregarJugador(ganador);
			ganador.setPuntosAcumulados(acumular10pts);

		} else if (existeJugadorID != null) {
			existeJugadorID.setPuntosAcumulados(acumular10pts);
		}

	}

	private Jugador existeJugador(Jugador ganador) {
		Jugador encontrado = null;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null && jugadores[i].getId() == ganador.getId()) {
				encontrado = jugadores[i];
			}
		}
		return encontrado;
	}

	public static boolean validarRondas(int rondas) {
		boolean esUnoOMayor = false;
		boolean esImpar = true;

		if (rondas >= 1) {
			esUnoOMayor = true;
		}
		if (rondas % 2 == 0) {
			esImpar = false;
		}

		if (esUnoOMayor && esImpar) {
			return true;
		}
		return false;
	}

	private void agregarJugador(Jugador ganador) {
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] == null) {
				jugadores[i] = ganador;
				i=jugadores.length;
			}
		}
	}

	public Jugador obtenerPorNombre(String nombreJugador) {
		Jugador encontrado = null;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null && jugadores[i].getNombre().equals(nombreJugador)) {
				encontrado = jugadores[i];
			}
		}
		return encontrado;
	}

	public Jugador[] obtenerJugadoresOrdenadosPorPuntajeDescendente() {
		// Ordenar los jugadores en el array por puntos de manera descendente
		Jugador[] ordenarPuntajes = new Jugador[jugadores.length];
		Jugador aux;
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores.length - 1; j++) {
				if (jugadores[j] != null && jugadores[j + 1] != null) {
					if (jugadores[j].getPuntosAcumulados() < jugadores[j + 1].getPuntosAcumulados()) {
						aux = jugadores[j];
						jugadores[j] = jugadores[j + 1];
						jugadores[j + 1] = aux;
					}
				}
			}
		}
		ordenarPuntajes = jugadores;

		return ordenarPuntajes;
	}

	public double obtenerPromedioPuntaje() {
		// Calcula el promedio de puntaje de los jugadores y lo devuelve
		double cantidadDDeJugadores = 0.0;
		double puntajesAcumulados = 0;
		double resultado = 0.0;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null) {
				puntajesAcumulados += jugadores[i].getPuntosAcumulados();
				cantidadDDeJugadores++;
			}
		}
		resultado = puntajesAcumulados / cantidadDDeJugadores;
		return resultado;
	}

}
