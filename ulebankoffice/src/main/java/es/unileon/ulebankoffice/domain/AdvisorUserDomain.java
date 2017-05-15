/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection="AdvisorUsers")
public class AdvisorUserDomain {
	
	@Id
	private String id;
	private String email;
	private boolean realizadoTest;
	private double resultadoTest;
	private List<SolicitudFinancialAdvisorDomain> solicitudes;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRealizadoTest() {
		return realizadoTest;
	}
	public void setRealizadoTest(boolean realizadoTest) {
		this.realizadoTest = realizadoTest;
	}
	public double getResultadoTest() {
		return resultadoTest;
	}
	public void setResultadoTest(double resultadoTest) {
		this.resultadoTest = resultadoTest;
	}
	public List<SolicitudFinancialAdvisorDomain> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<SolicitudFinancialAdvisorDomain> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public String getId() {
		return id;
	}
	
	

}
