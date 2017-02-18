package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class FrancesDomain extends Prestamo {
	
	private double tipoInteres, capInicial;
	private int periodos, tipoPeriodo;
	
	public FrancesDomain(double i, double C0, int k, int p) {
		this.tipoInteres = i / 100.0;
		this.capInicial = C0;
		this.periodos = k;
		this.tipoPeriodo = p;
	}
	
	public List<List<String>> calcular() {
		int numFilas = periodos * tipoPeriodo + 1;
		
		double[] anualidad = new double[numFilas];
		double[] interes = new double[numFilas];
		double[] amortizacion = new double[numFilas];
		double[] capitalPendiente = new double[numFilas];
		
		double Ani = (1 - Math.pow((1+tipoInteres/tipoPeriodo), (periodos*(-1)*tipoPeriodo))) / (tipoInteres/tipoPeriodo);
		double anualidadCons = capInicial / Ani;
		
		anualidad[0] = 0;
		interes[0] = 0;
		amortizacion[0] = 0;
		capitalPendiente[0] = capInicial;
		
		List<List<String>> tabla = new ArrayList<List<String>>();
		
		for(int i=1; i<numFilas; i++) {
			anualidad[i] = anualidadCons;
			interes[i] = capitalPendiente[i-1] * tipoInteres / tipoPeriodo;
			amortizacion[i] = anualidad[i] - interes[i];
			capitalPendiente[i] = capitalPendiente[i-1] - amortizacion[i];
		}
		
		List<String> itemTabla;
		for(int i=0; i<numFilas; i++) {
			itemTabla = new ArrayList<String>();
			
			itemTabla.add(Integer.toString(i));
			itemTabla.add(Double.toString(redondear(anualidad[i])));
			itemTabla.add(Double.toString(redondear(interes[i])));
			itemTabla.add(Double.toString(redondear(amortizacion[i])));
			itemTabla.add(Double.toString(redondear(capitalPendiente[i])));
			
			tabla.add(itemTabla);
		}
		
		return tabla;
	}
	
	public List<String> getTableHeader() {
		List<String> header = new ArrayList<String>();
		
		header.add("Periodo");
		header.add("Anualidad");
		header.add("Interés");
		header.add("Amortización");
		header.add("Capital pendiente");
		
		return header;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres / 100.0;
	}

	public double getCapInicial() {
		return capInicial;
	}

	public void setCapInicial(double capInicial) {
		this.capInicial = capInicial;
	}

	public int getPeriodos() {
		return periodos;
	}

	public void setPeriodos(int periodos) {
		this.periodos = periodos;
	}

	public int getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(int tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}
}
