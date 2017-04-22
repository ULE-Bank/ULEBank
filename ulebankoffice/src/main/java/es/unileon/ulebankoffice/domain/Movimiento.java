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

	public Double getCantidad();
	public String getConcepto();
	public String getEmisor();
	public Date getDate();
	public String getReceptor();
}
