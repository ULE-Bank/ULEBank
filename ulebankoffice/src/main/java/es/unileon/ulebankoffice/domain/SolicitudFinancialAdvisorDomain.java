/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import org.springframework.data.annotation.Id;

/**
 * @author Razvan Raducu
 *
 */
public class SolicitudFinancialAdvisorDomain {
	
	@Id
	private String idSolicitud;
	private String textoOferta;
	private String enlaceOferta;
	private String rutaOferta;
	
	
	public String getTextoOferta() {
		return textoOferta;
	}
	public void setTextoOferta(String textoOferta) {
		this.textoOferta = textoOferta;
	}
	public String getEnlaceOferta() {
		return enlaceOferta;
	}
	public void setEnlaceOferta(String enlaceOferta) {
		this.enlaceOferta = enlaceOferta;
	}
	public String getRutaOferta() {
		return rutaOferta;
	}
	public void setRutaOferta(String rutaOferta) {
		this.rutaOferta = rutaOferta;
	}
	public String getIdSolicitud() {
		return idSolicitud;
	}
	
	

}
