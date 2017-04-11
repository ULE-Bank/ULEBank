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
	private String productId;
	
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
			List<DocumentoAdjuntoDomain> documentos, String productId) {
		this.estado = estado;
		this.fechaApertura = fechaApertura;
		this.fechaResolucion = fechaResolucion;
		this.documentos = documentos;
		this.productId = productId;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "SolicitudDomain [id=" + id + ", estado=" + estado + ", fechaApertura=" + fechaApertura
				+ ", fechaResolucion=" + fechaResolucion + ", documentos=" + documentos + ", productId=" + productId
				+ "]";
	}
	
	
}
