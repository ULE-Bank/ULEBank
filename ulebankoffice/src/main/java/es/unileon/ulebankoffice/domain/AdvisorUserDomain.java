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
@Document(collection = "AdvisorUsers")
public class AdvisorUserDomain {

	@Id
	private String id;
	private String email;
	/* Primitivo, por defecto se inicializa a false */
	private boolean realizadoTest;

	/* Primitivo, por defecto se inicializa a 0.0 */
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

	/**
	 * Método usada para añadir una soliciutd a las uqe ya tiene este
	 * determinado cliente
	 * 
	 * @param soliciutd
	 */
	public void addSolicitud(SolicitudFinancialAdvisorDomain soliciutd) {
		this.solicitudes.add(soliciutd);
	}

	public String getId() {
		return id;
	}

}
