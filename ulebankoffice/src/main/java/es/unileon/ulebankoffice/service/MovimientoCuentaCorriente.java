/**
 * 
 */
package es.unileon.ulebankoffice.service;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import es.unileon.ulebankoffice.domain.Movimiento;

/**
 * @author Razvan Raducu
 *
 */
public class MovimientoCuentaCorriente implements Movimiento {

	@NotBlank
	private Double cantidad;
	@NotBlank
	private String concepto;
	@NotBlank
	private String autor;
	private String temporalidad;

	
	@Override
	public Double getCantidad() {
		return cantidad;
	}


	@Override
	public String getConcepto() {
		return concepto;
	}


	@Override
	public String getAutor() {
		return autor;
	}


	public String getTemporalidad() {
		return temporalidad;
	}


	public void setTemporalidad(String temporalidad) {
		this.temporalidad = temporalidad;
	}


	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
}
