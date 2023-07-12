package ar.edu.unlam.pb1.dominio;

public class Transaccion {
	public static int idUnico=0;
	private TipoTransaccion tipo;
	private double cantidad;
	private double monto;
	public Transaccion(TipoTransaccion tipoTransaccion, double cantidad, double monto) {
		this.tipo=tipoTransaccion;
		this.cantidad=cantidad;
		this.monto=monto;
	}

	private static int obtenerSiguienteId() {
		// Devuelve el siguiente id consecutivo al anterior
		idUnico++;
		return idUnico;
	}

	public static int getIdUnico() {
		return idUnico;
	}

	public static void setIdUnico(int idUnico) {
		Transaccion.idUnico = idUnico;
	}

	public TipoTransaccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransaccion tipo) {
		this.tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
}
