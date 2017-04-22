/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import es.unileon.ulebankoffice.domain.Movimiento;

/**
 * @author Razvan Raducu
 *
 */
public class MovimientoCuentaCorriente {

	@NotBlank
	private Double cantidad;
	@NotBlank
	private String concepto;
	@NotBlank
	private String emisor;
	@NotBlank
	private String receptor;
	@NotBlank
	private String date;
	private String temporalidad;

	public Double getCantidad() {
		return cantidad;
	}
	
	public String getConcepto() {
		return concepto;
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

	public String getEmisor() {
		return emisor;
	}

	public String getDate() {
		return date;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
