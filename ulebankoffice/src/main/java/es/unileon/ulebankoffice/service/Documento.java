package es.unileon.ulebankoffice.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection="Documentos") //El nombre de la colección tal vez no sea el más apropiado
public class Documento {
	
	@Id
	private String id;
	
	private String name;
	
	
	private String ruta;
	
	
	private String solicitudId; //La solicitud de la ID a la que está asociado
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getSolicitudId() {
		return solicitudId;
	}
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}
	
	
	
}
