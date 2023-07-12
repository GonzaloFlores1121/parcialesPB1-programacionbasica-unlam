package ar.edu.unlam.pb1.dominio;

public class Gimnasio {

	private Actividad[] actividades;
	private Cliente[] clientes;
	private String nombre;

	public Gimnasio(String nombre) {
		// TODO: se debe adminitar hasta 10000 clientes
		this.nombre = nombre;
		this.clientes = new Cliente[1000];
		this.actividades = new Actividad[20];
		this.agregarActividades(); // :O
	}

	public boolean iniciarSesion(int dni, String contrasenia) {
		// TODO: obtiene un cliente por su dni y, si existe, verifica que la contrasenia
		// sea la suministrada. Devuelve verdadero en caso de que las credenciales sean
		// validas.
		Cliente existe=buscarClientePorDni(dni);
		if(existe!=null) {
			if(existe.getContrasenia().equals(contrasenia)) {
				return true;
			}
		}
		return false;
	}

	public boolean registrarCliente(Cliente cliente) {
		// TODO: se debe registrar el cliente, agregandolo a los clientes del gimnasio,
		// solo en caso de que el dni del cliente suministrado no exista entre los
		// clientes actuales. Devuelve verdadero en caso de exito.
		if (buscarClientePorDni(cliente.getDni()) == null) {
			for (int i = 0; i < clientes.length; i++) {
				if (clientes[i] == null) {
					clientes[i] = cliente;
					i=clientes.length;
					return true;
				}
			}
		}
		return false;
	}

	public Actividad buscarActividadPorId(int id) {
		// TODO: Buscar entre las actividades del gimnasio alguna que aplique con el id
		// suministrado y devolverla

		Actividad encontrada = null;

		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] != null && actividades[i].getId() == id) {
				encontrada = actividades[i];
			}
		}
		return encontrada;
	}

	public Cliente buscarClientePorDni(int dni) {
		// TODO: Revisa entre los clientes del gimnasio, si algun posee el dni indicado
		// y lo devuelve.
		Cliente encontrado = null;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null && clientes[i].getDni() == dni) {
				encontrado = clientes[i];
			}

		}
		return encontrado;
	}

	public boolean validarContrasenia(String contrasenia) {
		// TODO: Devuelve verdadero en caso de que la contrasenia contenga: 2 o mas
		// mayusculas, un largo minimo de 8 caracteres y, si tiene numeros y estan
		// juntos, no pueden
		// ser consecutivos. Ejemplo valido: PassWord77 - Ejemplos invalidos:
		// PassWord123 o PassWord234 o PassWord345
		// -> notar que los numeros consecutivos son: 1 y 2 o 2 y 3, etc.
		int contadorMayus = 0;
		boolean numerosConsecutivos = false;
		for (int i = 0; i < contrasenia.length(); i++) {
			char caracter = contrasenia.charAt(i);
			if (Character.isUpperCase(caracter)) {
				contadorMayus++;
				if (i > 0 && i < contrasenia.length() - 1) {
					char anterior = contrasenia.charAt(i - 1);
					char siguiente = contrasenia.charAt(i + 1);

					if (Character.isDigit(anterior) && Character.isDigit(siguiente) && (caracter - anterior == 1)
							&& (siguiente - caracter == 1)) {

						numerosConsecutivos = true;
					}
				}
			}
		}
		if (contadorMayus >= 2 && contrasenia.length() >= 8 && !numerosConsecutivos) {
			return true;
		}
		return false;
	}

	public Cliente obtenerElClienteQueMenosActividadesRealizo() {
		// TODO: devuelve el cliente que menos actividades realizo
		Cliente aux;
		Cliente menorActividades=clientes[0];
		for(int i=0;i<clientes.length-1;i++){
			if(clientes[i]!=null && clientes[i+1]!=null) {
				
				if(menorActividades.obtenerCantidadDeActividadesRealizadas() > clientes[i+1].obtenerCantidadDeActividadesRealizadas()) {
					menorActividades=clientes[i+1];
				}
			}
		}
		return menorActividades;
	}
	

	public Actividad[] obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente() {
		// TODO: Ordenar las actividades de forma descendente por la cantidad de
		// calorias que se queman y devolverlas
		for(int i=0;i<actividades.length;i++) {
			for(int j=0;j<actividades.length-1;j++) {
				if(actividades[j]!=null && actividades[j+1]!=null) {
					if(actividades[j].getCaloriasQueQuema() < actividades[j+1].getCaloriasQueQuema()) {
						Actividad aux=actividades[j];
						actividades[j]=actividades[j+1];
						actividades[j+1]=aux;
					}
				}
			}
		}
		return this.actividades;
	}

	private void agregarActividades() {
		String nombre = "";
		TipoActividad tipoActividad;
		int valor = this.actividades.length / TipoActividad.values().length;
		int duracion = 30;
		double calorias = 400;

		for (int i = 0; i < this.actividades.length; i++) {

			if (i < valor) {
				nombre = TipoActividad.AEROBICO.toString();
				tipoActividad = TipoActividad.AEROBICO;
			} else if (i < (valor * 2)) {
				nombre = TipoActividad.FUNCIONAL.toString();
				tipoActividad = TipoActividad.FUNCIONAL;
				duracion = 60;
				calorias = 281;
			} else {
				nombre = TipoActividad.PESAS.toString();
				tipoActividad = TipoActividad.PESAS;
				duracion = 20;
				calorias = 450;
			}

			nombre += " " + (i + 1);

			this.actividades[i] = new Actividad(nombre, duracion, calorias, tipoActividad);
		}

	}

	public Actividad[] getActividades() {
		return actividades;
	}

	public void setActividades(Actividad[] actividades) {
		this.actividades = actividades;
	}

}
