package es.unileon.ulebankoffice.service;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Razvan Raducu
 *
 */

public class Cliente {

	@NotEmpty
	@NotBlank
	private String name, lastname, email;

	@NotNull
	@Past
	private String fechaNacimiento;

	// private ExpedienteElectronico expedienteElectronico;

	// private Handler dni;

	@NotEmpty
	@NotBlank
	private String dni;

	private List<Direccion> direccion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	// public ExpedienteElectronico getExpedienteElectronico() {
	// return expedienteElectronico;
	// }
	// public void setExpedienteElectronico(ExpedienteElectronico
	// expedienteElectronico) {
	// this.expedienteElectronico = expedienteElectronico;
	// }
	// public Handler getDni() {
	// return dni;
	// }
	// public void setDni(Handler dni) {
	// this.dni = dni;
	// }
	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

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
		return "Cliente [name=" + name + ", \nlastname=" + lastname + ", \nemail=" + email
				+ ", \nfechaNacimiento=" + fechaNacimiento + ", \ndni=" + dni + ", \ndireccion=" + direccion + "]";
	}

}
