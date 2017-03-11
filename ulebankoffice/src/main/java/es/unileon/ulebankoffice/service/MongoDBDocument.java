package es.unileon.ulebankoffice.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa el documento documento dentro de mongoDB
 * 
 * @author Razvan Raducu
 *
 */
@Document(collection="documents")
public class MongoDBDocument {

	
	@Id
	private String id;
	
	@NotNull @NotBlank @NotEmpty
	private String serie;
	@NotNull @NotBlank @NotEmpty
	private String name;
	@NotNull @NotBlank @NotEmpty
	private String DNI;
	@NotNull @NotBlank @NotEmpty
	private String ruta;
	

	public MongoDBDocument(){}
	
	public MongoDBDocument(String serie, String name, String DNI, String ruta){
		this.serie = serie;
		this.name = name;
		this.DNI = DNI;
		this.ruta = ruta;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
