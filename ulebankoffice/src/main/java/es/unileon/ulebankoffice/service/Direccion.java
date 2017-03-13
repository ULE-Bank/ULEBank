package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection="Direcciones")
public class Direccion {
	
	@Id
	private String id;
	
	@NotEmpty @NotBlank
	private String calle;
	
	@NotEmpty @NotBlank @Min(0)
	private int numero;
//	private Handler dni;
	
	@NotEmpty @NotBlank @Min(0)
	private int codigoPostal;
	
	@NotEmpty @NotBlank
	private String localidad;
	
	@NotEmpty @NotBlank
	private String comunidadAutonoma;
	
	@NotEmpty @NotBlank
	private String dni;
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	
//	public Handler getDni() {
//		return dni;
//	}
//
//	public void setDni(Handler dni) {
//		this.dni = dni;
//	}

	
	
	
}
