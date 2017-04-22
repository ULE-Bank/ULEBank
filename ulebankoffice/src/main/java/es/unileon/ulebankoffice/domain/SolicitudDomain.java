/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
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
	private String productId;
	
	@Transient
	private Documentos documentos;
	
	private List<String> idDocumentos;
	
	/**
	 * 
	 * @param estado
	 * @param fechaApertura
	 * @param fechaResolucion
	 * @param documentos
	 * @param productId
	 */
	@PersistenceConstructor
	public SolicitudDomain(String estado, Date fechaApertura, Date fechaResolucion,
			List<String> idDocumentos, String productId) {
		this.estado = estado;
		this.fechaApertura = fechaApertura;
		this.fechaResolucion = fechaResolucion;
		this.productId = productId;
		this.documentos = new Documentos();
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

	
	public void addDocument(DocumentoAdjuntoDomain documento){
		this.documentos.addDocumento(documento);
		this.idDocumentos.add(documento.getId());
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public void addDocumento(DocumentoAdjuntoDomain documento) {
		documentos.addDocumento(documento);
		this.idDocumentos.add(documento.getId());
	}

	public List<DocumentoAdjuntoDomain> getDocumentos() {
		return documentos.getDocumentos(this.idDocumentos);
	}
	
	@Override
	public String toString() {
		return "SolicitudDomain [id=" + id + ", estado=" + estado + ", fechaApertura=" + fechaApertura
				+ ", fechaResolucion=" + fechaResolucion + ", documentos=" + documentos + ", productId=" + productId
				+ "]";
	}
	
	
}
