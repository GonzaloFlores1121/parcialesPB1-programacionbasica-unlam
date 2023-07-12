package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner; 

import ar.edu.unlam.pb1.dominio.Categoria;
import ar.edu.unlam.pb1.dominio.Juego;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;
import ar.edu.unlam.pb1.dominio.MenuUsuario;
import ar.edu.unlam.pb1.dominio.Plataforma;
import ar.edu.unlam.pb1.dominio.Usuario;

public class PlataformaJuegos {
	private static final int SALIR = 99;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Plataforma plataforma = new Plataforma();
		MenuPrincipal opcionMenuPrincipal = null;
		int numeroIngresado = 0;

		do {
			mostrarPorPantalla("\nHola! Que deseas hacer en la plataforma de juegos?");
			mostrarMenuPrincipal();

			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case INICIAR_SESION:
				iniciarSesionEn(plataforma);
				break;
			case REGISTRARME:
				registrarme(plataforma);
				break;
			}

			// TODO: Complete la condicion para que el programa funcione correctamente
		} while (numeroIngresado !=SALIR);
	}

	private static void registrarme(Plataforma plataforma) {
		// TODO: Pide el ingreso de los datos necesarios para crear un usuario
		// Debe verificar que el correo sea valido y que no exista otro usuario
		// registrado en la plataforma con dicho correo (se sugiere buscar el usuario
		// por correo)
		// Una vez obtenidos los datos, se procede a registrar el usuario en la
		// plataforma mostrando un mensaje en caso de exito y otro en caso de error.
		String nombre;
		String apellido;
		String correo;
		String contrasenia;
		Usuario registrado;
		nombre=ingresarString("Ingrese su nombre");
		apellido=ingresarString("Ingrese su apellido .");
		correo=ingresarString("Ingrese su correo");
		contrasenia=ingresarString("Ingrese su contrasenia;");
		if(plataforma.esValidoEl(correo) && plataforma.buscarUsuarioConCorreo(correo)==null) {
			registrado=new Usuario(nombre,apellido,correo,contrasenia);
			plataforma.registrarUsuario(registrado);
			mostrarPorPantalla("Se pudo registrar al usuario.Bienvenido.");
		}else {
			mostrarPorPantalla("Error.Usuario ya existente o correo inválido.");
		}
	}

	private static void iniciarSesionEn(Plataforma plataforma) {
		mostrarPorPantalla("\n\nIniciemos sesion!");
		// TODO: Pide el ingreso de credenciales (usuario y contrasenia)
		// Verifica si con esas credenciales se puede iniciar sesion en la plataforma
		// Si el inicio de sesion es exitoso, se muestra un mensaje de exito y seguido el menu del usuario (metodo menuUsuario() ), caso
		// contrario, se muestra el mensaje de error: "Usuario y/o contrasenia invalido"
		String correo;
		String contrasenia;
		
		correo=ingresarString("Ingrese su correo de usuario.");
		contrasenia=ingresarString("Ingrese su contraseña");
		Usuario iniciado=plataforma.iniciarSesion(correo, contrasenia);
		if(iniciado!=null) {
			mostrarPorPantalla("Sesión iniciada.");
			menuUsuario(iniciado, plataforma);
		}else {
			mostrarPorPantalla("Datos invalidos.");
		}
	}

	private static void menuUsuario(Usuario usuario, Plataforma plataforma) {
		MenuUsuario opcionMenuUsuario = null;
		int numeroIngresado = 0;

		do {
			mostrarMenuUsuario();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			opcionMenuUsuario = obtenerOpcionDeMenuUsuario(numeroIngresado);
			int opcion = 0;

			switch (opcionMenuUsuario) {
			case MIS_JUEGOS:
				// TODO: Obtiene los juegos del usuario y los muestra.
				// Solicita el ingreso de un numero entero mostrando un mensaje. Dicho numero corresponde con el ID de algun juego.
				// Se debe jugar al juego ingresado. Si se ingresa 99 se sale del menu actual.
				do {
				Juego[] juegosUsuario=usuario.obtenerJuegosOrdenadosPorCategoria();
				mostrarJuegos(juegosUsuario);
				opcion=ingresarNumeroEntero("Ingrese el id del juego.\n O ingrese 99 para salir del menu actual.");
				
				usuario.jugarAlJuegoDe(opcion);
				}while(opcion!=99);
				break;
			case TIENDA:
				
				do {
					mostrarJuegos(plataforma.getJuegos());
					mostrarMenuTienda();
					
					opcion = ingresarNumeroEntero("\nIngrese opcion:");
					if(opcion!=99) {
						Juego elegido=plataforma.obtenerJuegoPorSuId(opcion-1);
						
						if(usuario.agregarAMisJuegos(elegido)==true) {
							mostrarPorPantalla("Juego adquirido por el usuario.");
						}else {
							mostrarPorPantalla("\"No fue posible agregar el juego, verifica que no lo hayas adquirido antes.\"");
						}
					}
					
					// TODO: Si el numero ingresado se encuentra entre 1 y 10 inclusive, entonces se
					// procede a adquirir el juego
					// Se sugiere obtener desde la plataforma el juego por su ID y luego agregarlo a los juegos del usuario
					// Es necesario mostrar un mensaje de exito en caso de adquirir el juego.
					// Si no se pudo adquirir el juego, entonces mostrar el mensaje: "No fue posible agregar el juego, verifica que no hayas adquirido antes."
					

				} while (opcion != SALIR);

				break;
			case JUEGO_MAS_JUGADO_POR_CATEGORIA:
				Juego masJugadoCategoria;
				// TODO: Mostrar un titulo que indique para que categoria se mostrara el juego mas jugado y luego mostrar el juego mas jugado de esa categoria.
				
				mostrarPorPantalla("El juego mas jugado de la categoria Depores es:");
				masJugadoCategoria=usuario.obtenerJuegoMasJugadoPorCategoria(Categoria.DEPORTES);
				mostrarJuego(masJugadoCategoria); 
				
				mostrarPorPantalla("El juego mas jugado de la categoria Accion es:");
				masJugadoCategoria=usuario.obtenerJuegoMasJugadoPorCategoria(Categoria.ACCION);
				mostrarJuego(masJugadoCategoria);
				
				mostrarPorPantalla("El juego mas jugado de la categoria Aventura es:");
				 masJugadoCategoria=usuario.obtenerJuegoMasJugadoPorCategoria(Categoria.AVENTURA);
				 mostrarJuego(masJugadoCategoria);
				break;
			case SALIR:
				break;
			}

		} while (!opcionMenuUsuario.equals(MenuUsuario.SALIR));

	}

	private static void mostrarJuego(Juego juego) {

		if (juego != null) {
			mostrarPorPantalla("\n" + juego.toString());
		} else {
			mostrarPorPantalla("\nSin juego");
		}
	}

	private static void mostrarJuegos(Juego[] juegos) {

		for (int i = 0; i < juegos.length; i++) {
			if (juegos[i] != null) {
				mostrarPorPantalla("\n" + juegos[i].toString());
			}
		}
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static MenuUsuario obtenerOpcionDeMenuUsuario(int numeroIngresado) {
		return MenuUsuario.values()[numeroIngresado - 1];
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.next();
	}
	
	private static void mostrarMenuTienda() {
		mostrarPorPantalla("\n\nIngrese el ID del juego que desea adquirir o 99 para salir:");
	}
	
	private static void mostrarMenuUsuario() {
		mostrarPorPantalla("\n\n1) Mis juegos\n2) Tienda\n3) Juego mas jugado por categoria\n4) Salir");
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla("\n\n1) Iniciar sesion\n2) Registrame");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
