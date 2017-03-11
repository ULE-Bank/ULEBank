package es.unileon.ulebankoffice.service;

import java.util.Date;
import java.util.List;

/**
 * @author Razvan Raducu
 *
 */
public class Cliente {
	
	private String name, lastname, email;
	private Date nacimiento;
	private ExpedienteElectronico expedienteElectronico;
	private Handler dni;
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
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public ExpedienteElectronico getExpedienteElectronico() {
		return expedienteElectronico;
	}
	public void setExpedienteElectronico(ExpedienteElectronico expedienteElectronico) {
		this.expedienteElectronico = expedienteElectronico;
	}
	public Handler getDni() {
		return dni;
	}
	public void setDni(Handler dni) {
		this.dni = dni;
	}
	public List<Direccion> getDireccion() {
		return direccion;
	}
	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}
	
	public void addDireccion(Direccion direccion){
		this.direccion.add(direccion);
	}
	
	
	
}
