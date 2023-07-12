package ar.edu.unlam.pb1;

public class Invitado {

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	private String nombre;
	private boolean esAdulto;
	private	int codigoInvitaacion;
	private boolean asistencia;
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre Nombre del invitado
	 * @param esAdulto Si es adulto o no
	 * @param codigoInvitacion C�digo de invitaci�n que permitir� confirmar que el invitado es leg�timo a la hora de asistir al sal�n
	 */
	public Invitado(String nombre, boolean esAdulto, int codigoInvitacion) {
		this.nombre=nombre;
		this.esAdulto=esAdulto;
		this.codigoInvitaacion=codigoInvitacion;
		this.asistencia=false;
	}

	/***
	 * Devuelve el nombre del invigtado
	 * @return Nombre del invitado
	 */
	public String getNombre() {
		return nombre;
	}

	/***
	 * Actualiza el nombre del invitado
	 * @param nombre El nuevo nombre del invitado
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	

	/****
	 * Devuelve si el invitado es un adulto
	 * @return True si es adulto o false en caso contrario
	 */
	public boolean esAdulto() {
		return esAdulto;
	}

	/***
	 * Actualiza el estado del invitado, confirmando su asistencia.
	 */
	public void confirmar() {
		this.asistencia=true;
	}
	
	/***
	 * Devuelve el estado de confirmaci�n del invitado
	 * @return true si confirmo su asistencia y false en caso contrario
	 */
	public boolean getConfirmo() {
		return asistencia;
	}
	
	/***
	 * Actualiza el estado de asistencia de un invitado
	 * @param codigoInvitacion al evento
	 * @return true si se pudo confirmar su asistencia o false en caso contrario (cuando el c�digo de asistencia no coincide con el definido inicialmente)
	 */
	public boolean asistir(int codigoInvitacion) {
		if(this.codigoInvitaacion==codigoInvitacion) {
			return true;
		}
		return false;
	}
	

	

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto Invitado.
	 */
	@Override
	public String toString() {
		return "Nombre del invitado "+this.nombre+". \nEs adulto "+this.esAdulto
				+"\n Su codigo de invitacion es:  "+this.codigoInvitaacion+
				"\n Asistió al cumpleaños ?"+asistencia;
	}
}
