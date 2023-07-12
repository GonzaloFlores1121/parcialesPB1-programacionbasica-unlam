package ar.edu.unlam.pb1.dominio;

public class Trading {
	private Bot[] bots;
	private Transaccion[] transacciones;
	private double valorCrpyto;

	public Trading(int cantidadBots, int cantidadTransacciones) {
		this.bots = new Bot[cantidadBots];
		this.transacciones = new Transaccion[cantidadTransacciones];
		this.valorCrpyto = 3.14;
	}

	public void agregarBot(Bot bot) {
		// Verificar que no exista el bot buscandolo por nombre con el metodo
		// buscarBotPorNombre()
		// En caso de no existir, entonces se debera agregar al array de bots
		if (buscarBotPorNombre(bot.getNombre()) == null) {
			for (int i = 0; i < bots.length; i++) {
				if (bots[i] == null) {
					bots[i] = bot;
					i = bots.length;
				}
			}
		}

	}

	private Bot buscarBotPorNombre(String nombre) {
		// Dado el nombre que llega como parametro, se debera buscar en el array de bots
		// Si no existe, se devuelve null
		Bot aux = null;
		for (int i = 0; i < bots.length; i++) {
			if (bots[i] != null && bots[i].getNombre().equals(nombre)) {
				aux = bots[i];
			}
		}
		return aux;
	}

	public void simularTransacciones() {

		// Genera transacciones con valores aleatorios. Se debe completar cada posicion
		// del array de transacciones

		// Debemos tener un bot vendedor y otro comprador obtenidos desde el array de
		// bots aleatoriamente, para poder transaccionar
		// El bot comprador no puede ser el mismo que el vendedor
		// La cantidad comprometida en la transaccion, debera ser aleatoria

		// Solo si el vendedor puede vender y el comprador, puede comprar, generaremos
		// transacciones     ((agregué como condición en el while de que pueda generar transacciones mientras haya espacio en el array de transacciones porque sino nunca saldria del bucle)) .
		
		
		// Se debera generar un transaccion para registrar la venta y otra para
		// registrar la compra consumiento el metodo generarTransaccion()
		Bot vendedor = null;
		Bot comprador = null;
		String mensaje;
		comprador = obtenerBotAleatorio();

		do{
			vendedor = obtenerBotAleatorio();
		}while(vendedor==comprador);
		
			double cantidadCrpyto = obtenerCantidadCryptoParaTransaccion();
			
			while (vendedor.puedeVender(cantidadCrpyto) && comprador.puedeComprar(cantidadCrpyto, valorCrpyto) && hayEspacioTransacciones()) {
			
				
				TipoTransaccion compra = TipoTransaccion.values()[0];
				TipoTransaccion venta = TipoTransaccion.values()[1];
				generarTransaccion(venta, cantidadCrpyto);
				generarTransaccion(compra, cantidadCrpyto);
		
			}
		}

//Si hay espacio en el array de transacciones se puede seguir agregando y el while se puede ejecutar
	//.Si no hay espacio no entra en el while del simularTransacciones.
	private boolean hayEspacioTransacciones() {
		boolean hayEspacio=false;
		for(int i=0;i<transacciones.length;i++) {
			if(transacciones[i]==null) {
				hayEspacio=true;
			}
		}
		return hayEspacio;
	}

	private void generarTransaccion(TipoTransaccion tipoTransaccion, double cantidadTransaccion) {
		// Es necesario saber cual es el monto de la transaccion
		// Una vez instanciada la transaccion, es necesario agregarla al array de
		// transacciones
	double montoTransaccion = valorCrpyto * cantidadTransaccion;
		Transaccion generada = new Transaccion(tipoTransaccion, cantidadTransaccion, montoTransaccion);
		for (int i = 0; i < transacciones.length; i++) {
			if (transacciones[i] == null) {
				transacciones[i] = generada;
				i = transacciones.length;
			}
			
		}

	}

	private Bot obtenerBotAleatorio() {
		// Devuelve un bot seleccionado de manera aleatoria, del array de bots
		Bot botObtenido = null;
		
		do {
			int numeroRandom = (int) (Math.random() * bots.length);
			botObtenido = bots[numeroRandom];
		} while (botObtenido == null);

		return botObtenido;
	}

	private double obtenerCantidadCryptoParaTransaccion() {
		// Devuelve un numero double aleatorio entre 1 y 5
		double cantidadCrpytoAleatorio = (Math.random() * 5) + 1;
		return cantidadCrpytoAleatorio;
	}

	public Bot[] obtenerBotsOrdenamosPorCryptoDescendiente() {
		// Ordena los bots de manera descendiente por la cantidad de crypto monedas que
		// tiene
		Bot[] obtenerBotsOrdenamosPorCryptoDescendiente = new Bot[bots.length];
		Bot aux;
		for (int i = 0; i < bots.length; i++) {
			for (int j = 0; j < bots.length - 1; j++) {
				if (bots[j] != null && bots[j + 1] != null) {
					if (bots[j].getCantidadCrypro() < bots[j + 1].getCantidadCrypro()) {
						aux = bots[j];
						bots[j] = bots[j + 1];
						bots[j + 1] = aux;
					}
				}
			}
		}
		obtenerBotsOrdenamosPorCryptoDescendiente = this.bots;
		return obtenerBotsOrdenamosPorCryptoDescendiente;
	}

	public double obtenerPromedioDeTransaccionesDeVenta() {
		// Obtiene el promedio del monto de todas las transacciones que sean de venta
		double cantidadTotalTransaccionesVenta = 0.0;
		double montoTotalTransaccionesVenta = 0.0;
		for (int i = 0; i < transacciones.length; i++) {
			if (transacciones[i] != null && transacciones[i].getTipo().equals(TipoTransaccion.VENTA)) {

				montoTotalTransaccionesVenta += transacciones[i].getMonto();
				cantidadTotalTransaccionesVenta++;
			}
		}
		return montoTotalTransaccionesVenta / cantidadTotalTransaccionesVenta;
	}

}
