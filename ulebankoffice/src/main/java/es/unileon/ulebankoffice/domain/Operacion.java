package es.unileon.ulebankoffice.domain;

import java.util.List;

/**
 * Clase que abstrae el comportamiento común a los distintos movimientos que se
 * pueden realizar en los distintos productos finacnieros.
 * 
 * @author Razvan Raducu, Alexis Gutierrez
 *
 */
public abstract class Operacion {

	/**
	 * Calcula la tabla de los movimientos y sus distintos intereses
	 * 
	 * @return La lista de todos los movimintos.
	 * 
	 */
	public abstract List<List<String>> calcularTabla();

	/**
	 * Returns the double value that is closest in value to the argument and is
	 * equal to a mathematical integer.
	 * 
	 * @param r
	 * @return El argumento double redondeado
	 */
	public double redondear(double r) {
		return Math.rint(r * 100) / 100;
	}

}
