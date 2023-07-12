package ar.edu.unlam.pb1.dominio;

public class Actividad {
	private static int siguienteId = 1;
	private int id;
	private String nombre;
	private int duracion;
	private double caloriasQueQuema;
	private TipoActividad tipoActividad;
	
	public Actividad(String nombre, int duracion, double caloriasQueQuema, TipoActividad tipoActividad) {
		this.id = siguienteId++;
		this.nombre=nombre;
		this.duracion=duracion;
		this.caloriasQueQuema=caloriasQueQuema;
		this.tipoActividad=tipoActividad;
		
	}

	public static int getSiguienteId() {
		return siguienteId;
	}

	public static void setSiguienteId(int siguienteId) {
		Actividad.siguienteId = siguienteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getCaloriasQueQuema() {
		return caloriasQueQuema;
	}

	public void setCaloriasQueQuema(double caloriasQueQuema) {
		this.caloriasQueQuema = caloriasQueQuema;
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", caloriasQueQuema="
				+ caloriasQueQuema + ", tipoActividad=" + tipoActividad + "]";
	}
	
}
