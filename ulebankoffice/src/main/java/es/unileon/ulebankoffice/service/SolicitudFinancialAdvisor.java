/**
 * 
 */
package es.unileon.ulebankoffice.service;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */
public class SolicitudFinancialAdvisor {
	
	@NotBlank
	private String textoOferta;

	private String urlOferta;
	
	public String getTextoOferta() {
		return textoOferta;
	}
	public void setTextoOferta(String textoOferta) {
		this.textoOferta = textoOferta;
	}
	
	public String getUrlOferta() {
		return urlOferta;
	}
	public void setUrlOferta(String urlOferta) {
		this.urlOferta = urlOferta;
	}

	
	

}
