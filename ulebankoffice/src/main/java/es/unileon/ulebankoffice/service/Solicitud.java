package es.unileon.ulebankoffice.service;

import java.util.Date;
import java.util.List;

/**
 * @author Razvan Raducu
 *
 */
public class Solicitud {
	
	private String estado;
	private List<Documento> documents;
	private Date fechaApertura;
	private Handler id;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Documento> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Documento> documents) {
		this.documents = documents;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Handler getId() {
		return id;
	}
	public void setId(Handler id) {
		this.id = id;
	}
	
	
	
}
