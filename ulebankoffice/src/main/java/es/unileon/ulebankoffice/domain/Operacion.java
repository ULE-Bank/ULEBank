package es.unileon.ulebankoffice.domain;

import java.util.List;

public abstract class Operacion {
	
	public abstract List<List<String>> calcular();
	
	public double redondear(double r) {
		return Math.rint(r*100) / 100;
	}

}
