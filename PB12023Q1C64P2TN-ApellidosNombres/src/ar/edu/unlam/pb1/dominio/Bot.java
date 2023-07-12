package ar.edu.unlam.pb1.dominio;

public class Bot {
private String nombre;
private double saldo;
private double cantidadCrypro;

	public Bot(String nombre, double saldo, double cantidadCrypto) {
		this.nombre=nombre;
		this.saldo=saldo;
		this.cantidadCrypro=cantidadCrypto;
	}

	public boolean puedeVender(double cantidadCrypto) {
		// Indica si el bot tiene la cantidad de crypto solicitada para la venta
		boolean puedeVender=false;
		if(this.cantidadCrypro >= cantidadCrypto) {
			puedeVender=true;
		}else {
			puedeVender=false;
		}
		return puedeVender;
	}

	public boolean puedeComprar(double cantidadTransaccion, double valorCrypto) {
		// Indica si el saldo es suficiente para comprar la cantidad de crypto al valor
		// suministrado
		double valorCryptoTotal= cantidadTransaccion*valorCrypto;
		
		boolean puedeComprar=false;
		if(saldo >= valorCryptoTotal) {
			puedeComprar=true;
		}else {
			puedeComprar=false;
		}
		return puedeComprar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getCantidadCrypro() {
		return cantidadCrypro;
	}

	public void setCantidadCrypro(double cantidadCrypro) {
		this.cantidadCrypro = cantidadCrypro;
	}

	@Override
	public String toString() {
		return "Bot [nombre=" + nombre + ", saldo=" + saldo + ", cantidadCrypro=" + cantidadCrypro + "]";
	}
	
}
