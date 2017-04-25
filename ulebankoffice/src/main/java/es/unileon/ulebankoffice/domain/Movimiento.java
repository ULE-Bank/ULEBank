/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.Date;

/**
 * @author Razvi Razvan Raducu
 *
 */
public interface Movimiento {
	
	
	/**
	 * Cantidad del movimiento sea ingreso o extracto
	 * @return cantidad
	 */
	public Double getCantidad();
	
	
	/**
	 * Concepto del movimiento
	 * @return concepto
	 */
	public String getConcepto();
	
	
	/**
	 * Emisor (creador, titular, prestamista, etc...) del movimiento
	 * @return Nombre del emisor
	 */
	public String getEmisor();
	
	
	/**
	 * Fecha en la que se realiza el movimiento
	 * @return fecha
	 */
	public Date getDate();
	
	
	/**
	 * Receptor (titular, prestatario, etc...) del movimiento
	 * @return Nombre del receptor
	 */
	public String getReceptor();
}
