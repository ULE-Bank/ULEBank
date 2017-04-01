/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import es.unileon.ulebankoffice.service.MovimientoCuentaCorriente;

/**
 * @author Razvan Raducu
 *
 */
public class MovimientoCuentaCorrienteDomain {
	
	private Double cantidad;
	private String concepto;
	private String autor;
	private int temporalidad;
	
	public MovimientoCuentaCorrienteDomain(Double cantidad, String concepto, String autor){
		this.cantidad = cantidad;
		this.concepto = concepto;
		this.autor = autor;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getTemporalidad() {
		return temporalidad;
	}

	public void setTemporalidad(int temporalidad) {
		this.temporalidad = temporalidad;
	}
	
	
	
}
