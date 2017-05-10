package es.unileon.ulebankoffice.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	 * <b>>Edit</b 10.05.2017 (dd-MM-yy). He cambiado lo que reotnra la función
	 * para que redondee siempre a las 3 cifras. Se debe usar BigDecimal ya que
	 * tanto double como float son inexactos al tratarse de muchos decimales.
	 * También se evita la notación científica al usar este método.
	 * 
	 * @param r
	 * @return El argumento double redondeado
	 */
	public double redondear(double r) {
		return BigDecimal.valueOf(Math.rint(r * 100) / 100).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

}
