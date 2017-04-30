package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Razvan Raducu
 *
 */
public class Direccion {

	@NotEmpty @NotBlank
	private String calle;
	
	@NotEmpty
	private String numero;
	
	@NotEmpty @Min(0)
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal
				+ ", localidad=" + localidad + ", comunidadAutonoma=" + comunidadAutonoma + ", dni=" + dni + "]";
	}	
	
}
