package ar.edu.unlam.pb1.dominio;

public class Usuario {
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasenia;
	private Juego[] juegosAdquiridos;

	public Usuario(String nombre, String apellido, String correo, String contrasenia) {
		// Daremos un espacio de 1000 juegos a cada nuevo usuario
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.juegosAdquiridos = new Juego[1000];
	}

	public boolean agregarAMisJuegos(Juego juego) {
		// TODO: Verificar no tener el juego adquirido ( Ver el metodo tengoElJuegoDe())
		// En caso de no tenerlo, se agrega el juego suministrado a los juegos del
		// usuario

		if (tengoElJuegoDe(juego.getId()) == false) {
			for (int i = 0; i < juegosAdquiridos.length; i++) {
				if (juegosAdquiridos[i] == null) {
					juegosAdquiridos[i] = juego;
					i = juegosAdquiridos.length;
					return true;
				}
			}
		}

		return false;

	}

	public boolean tengoElJuegoDe(int id) {
		// TODO: Verifica si tengo un juego con el id suministrado en mis juegos
		// Devuelve verdadero en caso de poseer el juego.
		for (int i = 0; i < juegosAdquiridos.length; i++) {
			if (juegosAdquiridos[i] != null && juegosAdquiridos[i].getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Juego obtenerJuegoMasJugadoPorCategoria(Categoria categoria) {
		// TODO: Revisa los juegos que cumplen con la categoria suministrada y obtiene
		// el
		// juego mas jugado de dicha categoria
		// Si no existe un juego para esa categoria, devuelve null
		Juego masJugado = null;
		Juego[] juegoMasJugadoCategoria = new Juego[juegosAdquiridos.length];
		int posicion = 0;
		for (int i = 0; i < juegosAdquiridos.length; i++) {
			if (juegosAdquiridos[i] != null && juegosAdquiridos[i].getCategoria().equals(categoria)) {
				juegoMasJugadoCategoria[posicion++] = juegosAdquiridos[i];
			}
		}
		Juego aux;
		for (int i = 0; i < juegoMasJugadoCategoria.length; i++) {
			for (int j = 0; j < juegoMasJugadoCategoria.length - 1; j++) {
				if (juegoMasJugadoCategoria[j] != null && juegoMasJugadoCategoria[j+1] != null) {
					if (juegoMasJugadoCategoria[j].getHorasJugadas() < juegoMasJugadoCategoria[j + 1].getHorasJugadas()) {
						aux = juegoMasJugadoCategoria[j];
						juegoMasJugadoCategoria[j]=juegoMasJugadoCategoria[j+1];
						juegoMasJugadoCategoria[j+1]=aux;

					}
				}
			}
		}
		masJugado=juegoMasJugadoCategoria[0];
		return masJugado;
	}

	public Juego[] obtenerJuegosOrdenadosPorCategoria() {
		// TODO: Obtiene los juegos del usuario ordenados por categoria.
		Categoria []categoriasJuegos=Categoria.values();
		Juego [] ordenadosPorCategorias=new Juego[juegosAdquiridos.length];
		int posicion=0;
		for(int i=0;i<categoriasJuegos.length;i++) {
			for(int j=0;j<juegosAdquiridos.length;j++) {
				if(juegosAdquiridos[j]!=null && juegosAdquiridos[j].getCategoria().equals(categoriasJuegos[i])) {
					ordenadosPorCategorias[posicion++]=juegosAdquiridos[j];
				}
			}
		}
		return ordenadosPorCategorias;
	}

	public void jugarAlJuegoDe(int id) {
		// TODO: Revisa entre los juegos si alguno tiene el id suministrado. Si lo
		// encuentra, le agrega 1 hora y media (1.5) a la cantidad de horas jugadas.
		// Siempre deberia encontrar el juego con el id que llega como parametro
		
		
		for(int i=0;i<juegosAdquiridos.length;i++) {
			if(juegosAdquiridos[i]!=null && juegosAdquiridos[i].getId()==id) {
				juegosAdquiridos[i].setHorasJugadas(juegosAdquiridos[i].getHorasJugadas()+1.5);
				break;
			}
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Juego[] getJuegosAdquiridos() {
		return juegosAdquiridos;
	}

}
