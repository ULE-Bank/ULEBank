/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "Solicitudes")
public class SolicitudDomain {

	@Id
	private String id;
	
	private String estado;
	private Date fechaApertura;
	private Date fechaResolucion;
	private List<DocumentoAdjuntoDomain> documentos;
	
	@Autowired
	DateFormat dateFormat;
	
	public SolicitudDomain(String estado, String fechaApertura) throws ParseException{
		this.fechaApertura = dateFormat.parse(fechaApertura);
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public List<DocumentoAdjuntoDomain> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoAdjuntoDomain> documentos) {
		this.documentos = documentos;
	}
	
	public void addDocument(DocumentoAdjuntoDomain documento){
		this.documentos.add(documento);
	}
	
	
}
