package ar.edu.unlam.pb1;

import java.util.Arrays;



public class Cumpleaniero {
	private String nombreCumpleanero;
	private Cumple[] listaCumpleanios;

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */

	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el
	 * correcto funcionamiento
	 * 
	 * @param nombre - Este es el nombre del cumplea�iero
	 */
	public Cumpleaniero(String nombre) {
		this.nombreCumpleanero = nombre;
		this.listaCumpleanios = new Cumple[100];
	}

	/***
	 * Este m�todo agrega un nuevo cumplea�os a la lista de cumplea�os del
	 * cumplea�ero.
	 * 
	 * @param cuantosCumple Este par�metro identifica un�vocamente al cumplea�os y
	 *                      representa los a�os que cumple.
	 * @param tematica      Este par�metro es un string de texto libre que
	 *                      identifica la tem�tica del cumplea�os.
	 * @return true si se pudo agregar y false en caso contrario.
	 */
	public boolean nuevoCumple(int cuantosCumple, String tematica) {
		Cumple nuevoCumple = new Cumple(cuantosCumple, tematica);
		for (int i = 0; i < listaCumpleanios.length; i++) {
			if (!yaSeHizoElCumple(cuantosCumple) && listaCumpleanios[i] == null) {
				listaCumpleanios[i] = nuevoCumple;
				i = listaCumpleanios.length;
				return true;
			}
		}
		return false;
	}

	private boolean yaSeHizoElCumple(int cuantosCumple) {
		for (int i = 0; i < listaCumpleanios.length; i++) {
			if (listaCumpleanios[i] != null && listaCumpleanios[i].getCuantosCumple() == cuantosCumple) {
				return true;
			}
		}
		return false;
	}

	/***
	 * Agrega un nuevo invitado a un cumplea�os determinado. Es importante recordar
	 * que primero se debe generar el c�digo de invitaci�n para asociarlo al nuevo
	 * invitado.
	 * 
	 * @param aQueCumple - Determina a qu� cumplea�os se agrega el nuevo invitado
	 * @param nombre     - Es el nombre del invitado
	 * @param esAdulto   - Indica si el invitado es adulto o no
	 * @return Devuelve el c�digo de invitaci�n asociado al nuevo invitado. Si no se
	 *         pudo agregar al invitado al cumplea�os se devuelve -1
	 */
	public int agregarInvitado(int aQueCumple, String nombre, boolean esAdulto) {
		int codigoInv = -1;

		for (int i = 0; i < listaCumpleanios.length; i++) {
			if (listaCumpleanios[i] != null && listaCumpleanios[i].getCuantosCumple() == aQueCumple) {
				codigoInv = calcularCodigoInvitacion();
				Invitado nuevo = new Invitado(nombre, esAdulto, codigoInv);
				listaCumpleanios[i].agregarInvitado(nuevo);

			}
		}
		return codigoInv;
	}

	/***
	 * Este algoritmo debe generar un c�digo de invitaci�n aleatorio entre 1 y 1000.
	 * El c�digo se puede repetir entre un invitado y otro, pero no se puede
	 * anticipar el c�digo generado
	 * 
	 * @return Devuelve el c�digo de invitaci�n generado.
	 */
	public int calcularCodigoInvitacion() {
		int codigoInv = (int) (Math.random() * 1000 + 1);

		return codigoInv;
	}

	/***
	 * Este m�todo primero debe buscar al invitado en el cumplea�os al que desea
	 * confirmar su asistenica. Si lo encuentra, confirma su asistencia.
	 * 
	 * @param cumpleAlQueConfirma Cumplea�os al que un invitado confirma su
	 *                            asistencia.
	 * @param nombre              Nombre del invitado que env�a la confirmaci�n
	 * @return Devuelve true para el caso que se haya confirmado la invitaci�n y
	 *         false en caso contrario
	 */
	public boolean confirmar(int cumpleAlQueConfirma, String nombre) {
		for (int i = 0; i < listaCumpleanios.length; i++) {
			if (listaCumpleanios[i] != null && listaCumpleanios[i].getCuantosCumple() == cumpleAlQueConfirma) {
				Invitado invitados = listaCumpleanios[i].buscar(nombre);
				if (invitados != null) {
					invitados.confirmar();
					return true;
				}
			}
		}
		return false;
	}

	/****
	 * Este m�todo primero debe buscar al invitado en el cumplea�os al que desea
	 * asistir. Si lo encuentra, debe verificar que el invitado haya confirmado su
	 * asistencia y que el c�digo recibido coincida con el generado al momento de
	 * enviar la invitaci�n.
	 * 
	 * @param cumpleAlQueAsiste - Cumplea�os al que el invitado est� asistiendo
	 * @param nombre            - Nombre del invitado
	 * @param codigoAsistencia  - C�digo de asistencia con el que el invitado desea
	 *                          ingresar al sal�n.
	 * @return Devuelve true si el invitado puede asistir o false para los
	 *         siguientes casos: * Si el invitado no existe en el cumplea�os * Si el
	 *         invitado no hab�a confirmado previamente su asistencia * Si el c�digo
	 *         de invitaci�n no concide con el generado inicialmente
	 */
	public boolean asistir(int cumpleAlQueAsiste, String nombre, int codigoAsistencia) {

		for (int i = 0; i < listaCumpleanios.length; i++) {

			if (listaCumpleanios[i] != null && listaCumpleanios[i].getCuantosCumple() == cumpleAlQueAsiste) {
				Invitado invitados = listaCumpleanios[i].buscar(nombre);
				if (invitados != null && invitados.getConfirmo() == true && invitados.asistir(codigoAsistencia)==true) {
					return true;

				}
			}

		}
		return false;
	}

	/****
	 * Devuelve un objeto Cumple asociado al n�mero recibido por par�metro
	 * 
	 * @param numero N�mero de cumplea�os que se debe retornar
	 * @return El cumplea�os recibido por par�metro
	 */
	public Cumple getCumpleanios(int numero) {
		Cumple cumple = null;
		for (int i = 0; i < listaCumpleanios.length; i++) {
			if (listaCumpleanios[i] != null && listaCumpleanios[i].getCuantosCumple() == numero) {
				cumple = listaCumpleanios[i];
			}
		}
		return cumple;
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el
	 * estado del objeto cumplea�ero.
	 */
	@Override
	public String toString() {
	    String cumpleanios = "";
	    boolean hayCumpleanios = false; // Variable para controlar si hay cumpleaños realizados

	    for (int i = 0; i < listaCumpleanios.length; i++) {
	        if (listaCumpleanios[i] != null) {
	            cumpleanios += listaCumpleanios[i];
	            hayCumpleanios = true; // Se encontró al menos un cumpleaños realizado
	        }
	    }

	    if (hayCumpleanios) {
	        return "\nLos cumpleaños de " + nombreCumpleanero + " son los siguientes:\n" + cumpleanios;
	    } else {
	        return "No se han realizado cumpleaños aún para " + nombreCumpleanero;
	    }
	}
}
	
