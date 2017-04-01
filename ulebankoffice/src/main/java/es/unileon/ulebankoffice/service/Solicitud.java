package es.unileon.ulebankoffice.service;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */


public class Solicitud {

	@NotBlank @NotEmpty 
	private String estado; //Se seleccionará estado de entre varios predefinidos
//	private List<Documento> documents;
	
	@NotBlank @NotEmpty @Past 
	private String fechaApertura;
//	private Handler id;
	
	@NotBlank @NotNull
	private String dni;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
//	public List<Documento> getDocuments() {
//		return documents;
//	}
//	public void setDocuments(List<Documento> documents) {
//		this.documents = documents;
//	}
	public String getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
//	public Handler getId() {
//		return id;
//	}
//	public void setId(Handler id) {
//		this.id = id;
//	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
