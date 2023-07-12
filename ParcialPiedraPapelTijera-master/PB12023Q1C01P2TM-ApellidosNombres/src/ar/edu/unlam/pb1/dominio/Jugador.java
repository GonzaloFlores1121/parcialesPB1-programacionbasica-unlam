package ar.edu.unlam.pb1.dominio;

public class Jugador {
	private int id;
	private String nombre;
	private int puntosAcumulados;
	
	public Jugador(int id, String nombre) {
		this.id=id;
		this.nombre=nombre;
		this.puntosAcumulados=0;
	}
	//Suma los puntos acumulados del parametro a los puntosacumulados que ya tenia el jugador.
	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados += puntosAcumulados;
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

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", puntosAcumulados=" + puntosAcumulados + "]";
	}

}
