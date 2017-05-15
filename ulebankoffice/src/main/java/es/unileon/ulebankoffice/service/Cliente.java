package es.unileon.ulebankoffice.service;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */

public class Cliente {

	@NotBlank
	private String name; 
	@NotBlank
	private String lastName; 
	@NotBlank
	private String email;

	@NotBlank
	private String fechaNacimiento;

	@NotBlank
	private String dni;
	
	@NotBlank
	private String nacionalidad;
	
	private List<Direccion> direccion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	/**
	 * Añadre una dirección a la lista de direcciones.
	 * 
	 * @param direccion. Instancia POJO
	 */
	public void addDireccion(Direccion direccion) {
		this.direccion.add(direccion);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	@Override
	public String toString() {
		return "Cliente [name=" + name + ", lastname=" + lastName + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + ", direccion=" + direccion + "]";
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
