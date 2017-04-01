/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection="documents")
public class DocumentoAdjuntoDomain {

	@Id
	private String id;
	
	private String ruta;
	private Handler dni;
//	private String solicitudId;
//	private String productoFinancieroId;
	
	public DocumentoAdjuntoDomain(String ruta, String dni) throws DNIException{
		this.ruta = ruta;
		this.dni = new DNIHandler(dni);
	}
	
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
//	public String getSolicitudId() {
//		return solicitudId;
//	}
//	public void setSolicitudId(String solicitudId) {
//		this.solicitudId = solicitudId;
//	}
//	public String getProductoFinancieroID() {
//		return productoFinancieroId;
//	}
//	public void setProductoFinancieroID(String productoFinancieroID) {
//		this.productoFinancieroId = productoFinancieroID;
//	}

	public Handler getDni() {
		return dni;
	}

	public void setDni(Handler dni) {
		this.dni = dni;
	}
	
	
	
}
