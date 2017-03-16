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
@Document(collection = "Clientes")
public class Cliente {

	/*
	 * La propiedad ID no se puede acceder desde los beans o el modelo puesto
	 * que no tiene getters ni setters asignados
	 */
	@Id
	private String id;

	@NotEmpty
	@NotBlank
	private String name, lastname, email;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull
	@Past
	private Date fechaNacimiento;

	// private ExpedienteElectronico expedienteElectronico;

	// private Handler dni;

	@NotEmpty
	@NotBlank
	@Indexed(unique = true)
	private String dni;

	private List<Direccion> direccion;

	public Cliente() {
	}

	public Cliente(String name, String lastname, String email, Date fechaNacimiento, String dni) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
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
		return "Cliente [id=" + id + ", \nname=" + name + ", \nlastname=" + lastname + ", \nemail=" + email
				+ ", \nfechaNacimiento=" + fechaNacimiento + ", \ndni=" + dni + ", \ndireccion=" + direccion + "]";
	}

}
