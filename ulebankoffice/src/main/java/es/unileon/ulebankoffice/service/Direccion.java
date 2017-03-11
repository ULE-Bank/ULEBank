package es.unileon.ulebankoffice.service;

/**
 * @author Razvan Raducu
 *
 */
public class Direccion {
	
	private String calle, numero;
	private Handler dni;

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

	
	public Handler getDni() {
		return dni;
	}

	public void setDni(Handler dni) {
		this.dni = dni;
	}

	
	
	
}
