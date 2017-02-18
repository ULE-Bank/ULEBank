package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

public class AlemanDomain extends Prestamo {
	
	private double capInicial, tipoInteres;
	private int periodos, tipoPeriodo;
	
	public AlemanDomain(double C0, double i, int k, int p) {
		this.capInicial = C0;
		this.tipoInteres = i / 100.0;
		this.periodos = k;
		this.tipoPeriodo = p;
	}

	public List<List<String>> calcular() {
		int numFilas = (periodos * tipoPeriodo) + 1;
		
		double[] anualidad = new double[numFilas];
		double[] amortizacion = new double[numFilas];
		double[] interes = new double[numFilas];
		double[] capitalPendiente = new double[numFilas];
		
		interes[0] = capInicial * tipoInteres / tipoPeriodo;
		
		anualidad[0] = interes[0];
		
		double anualidadCons = capInicial * (tipoInteres/tipoPeriodo) / (1-(Math.pow((1-(tipoInteres/tipoPeriodo)), (periodos*tipoPeriodo))));
		
		for(int i=1; i<anualidad.length; i++)
			anualidad[i] = anualidadCons;
		
		amortizacion[numFilas-1] = anualidadCons;
		amortizacion[0] = 0;
		
		for(int i=amortizacion.length-2; i>0; i--)
			amortizacion[i] = amortizacion[i+1] * (1 - (tipoInteres/tipoPeriodo));
		
		for(int i=1; i<interes.length; i++)
			interes[i] = anualidad[i] - amortizacion[i];
		
		capitalPendiente[0] = capInicial;
		
		for(int i=1; i<capitalPendiente.length; i++)
			capitalPendiente[i] = capitalPendiente[i-1] - amortizacion[i];
		
		List<List<String>> tabla = new ArrayList<List<String>>();
		
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
	
	public double getCapInicial() {
		return capInicial;
	}
	
	public void setCapInicial(double capInicial) {
		this.capInicial = capInicial;
	}
	
	public double getTipoInteres() {
		return tipoInteres;
	}
	
	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres / 100.0;
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
