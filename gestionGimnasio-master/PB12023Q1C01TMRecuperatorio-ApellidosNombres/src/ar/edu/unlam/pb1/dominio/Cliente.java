package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

public class Cliente {
	private int dni;
	private String nombre;
	private String contrasenia;
	private Actividad[]actividades;
	public Cliente(int dni, String nombre, String contrasenia) {
		// TODO: El cliente podra realizar hasta 10000 actividades
		this.dni=dni;
		this.nombre=nombre;
		this.contrasenia=contrasenia;
		this.actividades=new Actividad[1000];
	}

	public void realizarActividad(Actividad actividad) {
		// TODO: Agrega una actividad a las actividades del cliente
		for(int i=0;i<actividades.length;i++) {
			if(actividades[i]==null) {
				actividades[i]=actividad;
				i=actividades.length;
			}
		}
	}

	public boolean eliminarActividadPorId(int id) {
		// TODO: busca una actividad por su id y en caso de existir, la elimina.
		for(int i=0;i<actividades.length;i++) {
			if(actividades[i]!=null && actividades[i].getId()==id) {
				actividades[i]=null;
				return true;
			}
		}
		return false;
	}

	public int obtenerCantidadDeActividadesRealizadas() {
		// TODO: revisar cuantas actividades realizo el cliente y devolver el valor
		// correspondiente
		int cantidadActividadesRealizadas=0;
		
		for(int i=0;i<actividades.length;i++) {
			if(actividades[i]!=null) {
				cantidadActividadesRealizadas++;
			}
		}
		return cantidadActividadesRealizadas;
	}

	public double obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(TipoActividad tipoActividad) {
		// TODO: Obtener la cantidad de calorias quemadas por el cliente al realizar
		// actividades de un tipo determinado
		double caloriasQuemadas=0.0;
		
		
		for(int i=0;i<actividades.length;i++) {
			if(actividades[i]!=null && actividades[i].getTipoActividad().equals(tipoActividad)) {
				caloriasQuemadas = actividades[i].getCaloriasQueQuema();
			}
		}
		return caloriasQuemadas;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Actividad[] getActividades() {
		return actividades;
	}

	public void setActividades(Actividad[] actividades) {
		this.actividades = actividades;
	}

	@Override
	public String toString() {
		String actividadesRealizadas="";
		for(int i=0;i<actividades.length;i++) {
			if(actividades[i]!=null) {
				actividadesRealizadas += actividades[i];
			}
		}
		return "Cliente [dni=" + dni + ", actividades=" + actividadesRealizadas + "]";
	}
	
}
