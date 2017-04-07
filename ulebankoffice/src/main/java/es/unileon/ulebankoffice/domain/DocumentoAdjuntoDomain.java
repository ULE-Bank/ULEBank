/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection="Documents")
public class DocumentoAdjuntoDomain {

	@Id
	private String id;
	
	private String ruta;
	private List<Handler> dni;
//	private String solicitudId;
//	private String productoFinancieroId;
	private List<String> productId;
	
	
	@PersistenceConstructor
	public DocumentoAdjuntoDomain(String ruta, List<Handler> dni, List<String> productId) {
	super();
	this.ruta = ruta;
	this.dni = dni;
	this.productId = productId;
}

	public DocumentoAdjuntoDomain(String ruta) throws DNIException{
		this.ruta = ruta;
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

	public List<Handler> getDni() {
		return dni;
	}

	public void setDni(List<Handler> dni) {
		this.dni = dni;
	}
	
	public void addDni(String dni) throws DNIException{
		this.dni.add(new DNIHandler(dni));
	}

	public List<String> getRelevanciaEnIds() {
		return productId;
	}

	public void setRelevanciaEnIds(List<String> relevanciaEnIds) {
		this.productId = relevanciaEnIds;
	}
	
	public void addRelevanicaEnId(String id){
		this.productId.add(id);
	}
	
}
