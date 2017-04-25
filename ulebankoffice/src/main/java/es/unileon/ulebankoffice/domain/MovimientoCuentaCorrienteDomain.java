/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.Date;

/**
 * @author Razvan Raducu
 *
 */
public class MovimientoCuentaCorrienteDomain implements Movimiento {

	private Double cantidad;
	private String concepto;
	private String emisor;
	private String receptor;
	private int temporalidad;
	private Date fecha;

	
	/**
	 * Recibe la fecha en formato Date.
	 * 
	 * @param cantidad
	 * @param concepto
	 * @param emisor
	 * @param receptor
	 * @param fecha
	 */
	public MovimientoCuentaCorrienteDomain(Double cantidad, String concepto, String emisor, String receptor,
			Date fecha) {
		this.cantidad = cantidad;
		this.concepto = concepto;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
	}

	@Override
	public Double getCantidad() {
		return cantidad;
	}

	@Override
	public String getConcepto() {
		return concepto;
	}
	
	
	public int getTemporalidad() {
		return temporalidad;
	}

	@Override
	public String getEmisor() {
		return emisor;
	}

	@Override
	public Date getDate() {
		return fecha;
	}

	@Override
	public String getReceptor() {
		return receptor;
	}

	public void setTemporalidad(int temporalidad) {
		this.temporalidad = temporalidad;
	}


	public void setDate(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
