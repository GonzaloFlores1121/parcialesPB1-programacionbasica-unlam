package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Cumple {
	private int cuantosCumple;
	private String tematica;
	private Invitado[] invitados;

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */

	/****
	 * El constructor debe realizar todas las acciones necesarias para garantizar el
	 * correcto funcionamiento
	 * 
	 * @param cuantosCumple Esto es un valor num�rico que identifica los a�os que se
	 *                      celebran en el presente cumplea�os
	 * @param tematica      Esto es una variable de tipo String que denota la
	 *                      tem�tica del cumplea�os.
	 */
	public Cumple(int cuantosCumple, String tematica) {
		this.cuantosCumple = cuantosCumple;
		this.tematica = tematica;
		this.invitados = new Invitado[100];
	}

	/***
	 * Agrega un nuevo invitado a la lista de invitados del cumplea�os
	 * 
	 * @param nuevo - El invitado a agregar
	 * @return Devuelve true si se pudo agregar al nuevo invitado o false en caso
	 *         contrario.
	 */
	public boolean agregarInvitado(Invitado nuevo) {
		for (int i = 0; i < invitados.length; i++) {
			if (invitados[i] == null) {
				invitados[i] = nuevo;
				i = invitados.length;
				return true;
			}
		}
		return false;
	}

	/***
	 * Este m�todo busca un invitado en la lista de invitados a partir de su nombre.
	 * 
	 * @param nombre Nombre del invitado a buscar.
	 * @return Devuelve true si encuentra al invitado o false en caso contrario.
	 */
	public Invitado buscar(String nombre) {
		Invitado encontrado=null;
		for(int i=0;i<invitados.length;i++) {
			if(invitados[i] !=null && invitados[i].getNombre().equals(nombre)) {
				encontrado=invitados[i];
			}
		}
		return encontrado;
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el
	 * estado del objeto Cumple.
	 */
	@Override
	public String toString() {
		return "El cumpleañero festeja su cumpleaños "+cuantosCumple+"\n La tematica es de "+tematica;
				
	}

	public int getCuantosCumple() {
		return cuantosCumple;
	}

	public void setCuantosCumple(int cuantosCumple) {
		this.cuantosCumple = cuantosCumple;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Invitado[] getInvitados() {
		return invitados;
	}

	public void setInvitados(Invitado[] invitados) {
		this.invitados = invitados;
	}

	
}
