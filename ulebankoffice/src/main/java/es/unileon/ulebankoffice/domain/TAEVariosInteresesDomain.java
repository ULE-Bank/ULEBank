package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Irr;

import es.unileon.ulebankoffice.service.InteresVariable;

/**
 * @author Razvan Raducu
 *
 */
public class TAEVariosInteresesDomain {

	private double cantidad;
	private int periodo;
	private List<InteresVariable> intereses;

	public TAEVariosInteresesDomain(double cantidad, int periodo, List<InteresVariable> intereses) {
		this.cantidad = cantidad;
		this.periodo = periodo;
		this.intereses = intereses;
	}

	public List<List<String>> calcular() {

		double[] flujos = new double[periodo];

		for (int i = 0; i < periodo; i++) {
			// income[i] = intereses.get(i).getInteres();
			// System.out.println(income[i]);

			flujos[i] = (intereses.get(i).getInteres()/(100*100)) * cantidad / periodo;
			System.out.println(flujos[i]);

		}
		new Irr();
		double irr = Irr.irr(flujos);
		System.out.println("irr" + irr);
		System.out.println(Math.pow((1.0 + irr), periodo));

		double TAE = Math.pow((1.0 + irr), periodo) - 1.0;
		System.out.println("TAE ->" + TAE);
		
		List<List<String>> tabla = new ArrayList<List<String>>();
		List<String> itemTabla;
		for (int i = 0; i < periodo; i++) {
			itemTabla = new ArrayList<String>();
			itemTabla.add(Integer.toString(i));
			itemTabla.add(intereses.get(i).getInteres() + " %");
			itemTabla.add(Double.toString(flujos[i]));
			
			tabla.add(itemTabla);
			System.out.println(itemTabla);
		}
		itemTabla = new ArrayList<String>();
		itemTabla.add(Double.toString(irr));
		tabla.add(itemTabla);
		System.out.println(tabla);
		return tabla;
	}

	private double getIRR(double[] cashFlows) {
		final int MAX_ITER = 20;
		double EXCEL_EPSILON = 0.0000001;

		double x = 0.1;
		int iter = 0;
		while (iter++ < MAX_ITER) {

			final double x1 = 1.0 + x;
			double fx = 0.0;
			double dfx = 0.0;
			for (int i = 0; i < cashFlows.length; i++) {
				final double v = cashFlows[i];
				final double x1_i = Math.pow(x1, i);
				fx += v / x1_i;
				final double x1_i1 = x1_i * x1;
				dfx += -i * v / x1_i1;
			}
			final double new_x = x - fx / dfx;
			final double epsilon = Math.abs(new_x - x);

			if (epsilon <= EXCEL_EPSILON) {
				if (x == 0.0 && Math.abs(new_x) <= EXCEL_EPSILON) {
					return 0.0; // OpenOffice calc does this
				} else {
					return new_x * 100;
				}
			}
			x = new_x;
		}
		return x;
	}

}
