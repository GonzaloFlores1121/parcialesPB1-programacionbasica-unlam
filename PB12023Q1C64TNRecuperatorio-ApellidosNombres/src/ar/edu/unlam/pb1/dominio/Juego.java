package ar.edu.unlam.pb1.dominio;

public class Juego {
	// TODO: Completar la clase con lo necesario para garantizar el correcto funcionamiento
	private int id;
	private String nombre;
	private double horasJugadas;
	private  Categoria categoria;
	public Juego(int id, String nombre, Categoria categoria) {
		this.id=id;
		this.nombre=nombre;
		this.horasJugadas=0.0;
		this.categoria=categoria;
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
	public double getHorasJugadas() {
		return horasJugadas;
	}
	public void setHorasJugadas(double horasJugadas) {
		this.horasJugadas = horasJugadas;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", horasJugadas=" + horasJugadas + ", categoria=" + categoria
				+ "]";
	}

}
