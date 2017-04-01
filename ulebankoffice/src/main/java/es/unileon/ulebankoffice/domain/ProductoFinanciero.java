package es.unileon.ulebankoffice.domain;

import java.util.Date;

/**
 * @author Razvan Raducu
 *
 */
public interface ProductoFinanciero<T> {
	public Date getFechaSolicitud();
	public Date getFechaResolucion();
	public Date getFechaFinalizacion();
	public String getEstado();
	public T getDni();
	
}
