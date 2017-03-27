package es.unileon.ulebankoffice.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Irr;

import es.unileon.ulebankoffice.service.InteresVariable;

/**
 * @author Razvan Raducu
 *
 */
public class TAEVariosInteresesDomain extends Operacion{

	private double cantidad;
	private int periodo;
	private List<InteresVariable> intereses;

	public TAEVariosInteresesDomain(double cantidad, int periodo, List<InteresVariable> intereses) {
		this.cantidad = cantidad;
		this.periodo = periodo;
		this.intereses = intereses;
	}

	public List<List<String>> calcular() {

		// Hay que sumar 1 puesto que la cantidad ha de introducirse en los
		// flujos
		double[] flujos = new double[periodo + 1];

		flujos[0] = -cantidad;
		for (int i = 0; i < periodo; i++) {
			// income[i] = intereses.get(i).getInteres();
			// System.out.println(income[i]);

			flujos[i + 1] = Double.valueOf((intereses.get(i).getInteres() / (100)) * cantidad / periodo);

		}

		// Hay que sumar de nuevo la cantidad inicial
		flujos[flujos.length - 1] += cantidad;

		new Irr();
		double irr = Irr.irr(flujos, 0.1d);

		double TAE = (Math.pow((1.0 + irr), periodo) - 1.0) * 100;

		List<List<String>> tabla = new ArrayList<List<String>>();
		List<String> itemTabla;

		// Añado en primer lugar una fila vacía para mostrar la cantidad inciial
		// como el flujo negativo
		itemTabla = new ArrayList<String>();
		itemTabla.add("");
		itemTabla.add("");
		itemTabla.add(Double.toString(flujos[0]));
		tabla.add(itemTabla);

		for (int i = 0; i < periodo; i++) {
			itemTabla = new ArrayList<String>();
			itemTabla.add(Integer.toString(i + 1)); // El número de la columna
													// periodo
			itemTabla.add(intereses.get(i).getInteres() + " %"); // El interes
																	// de ese
																	// priodo
			//Tras hacer las operaciones hago redondeo a los flujos. Para ello se usa Bigdecimal.
			itemTabla.add(new BigDecimal(Double.toString(flujos[i+1])).setScale(2,BigDecimal.ROUND_HALF_UP).toString());

			tabla.add(itemTabla);
		}
		
		//Después de hacer todas las operaciones y antes de añadir a la tabla, redondeo sus valores.
		TAE = redondear(TAE);
		
		// En las últimas dos posiciones de la tabla se encuentra el IRR y el
		// TAE, resultado final. Estas posiciones se borrarán para imprimir la
		// tabla en la vista con un foreach, de esto se encarga el controlador.
//		itemTabla = new ArrayList<String>();
//		itemTabla.add(Double.toString(irr*100) + " %");
//		tabla.add(itemTabla);

		itemTabla = new ArrayList<String>();
		itemTabla.add(Double.toString(TAE) + " %");
		tabla.add(itemTabla);

		return tabla;
	}

}
