package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "Clientes")
public class ClienteDomain {
	
	@Id
	private String id;
	
	private String name, lastname, email;
	
	private Date fechaNacimiento;
	
	@Indexed(unique = true)
	private Handler dni;
	
	private List<DireccionDomain> direcciones;
	
	public ClienteDomain(){}
	
//	public ClienteDomain(String name, String lastname, String dni) throws DNIException{
//		this.name = name;
//		this.lastname = lastname;
//		this.dni = new DNIHandler(dni);
//	}
	
	public ClienteDomain(String name, String lastname, String email, String fechaNacimiento, String dni) throws ParseException, DNIException {
		
		//SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println("Date format i received -> " + fechaNacimiento);
		
		DateFormat userDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		DateFormat mongoDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//		
//		Date userDate = userDateFormat.parse(fechaNacimiento);
//		Date mongoDate = mongoDateFormat.parse(mongoDateFormat.format(userDate));
//		System.out.println("----------------------");
//		System.out.println(userDate.toString()); //Mon Dec 05 00:00:00 CET 1994
//		System.out.println("........................");
//		System.out.println(mongoDateFormat.format(userDate).toString()); //lun dic 05 00:00:00 CET 1994
//		System.out.println("........................");
//		System.out.println(userDateFormat.format(mongoDate).toString()); //05.12.1994
		
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		//this.fechaNacimiento = df.parse(fechaNacimiento);
		this.fechaNacimiento = userDateFormat.parse(fechaNacimiento);
		setDni(dni);
		
	}
	
	
	
	@Override
	public String toString() {
		return "ClienteDomain [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + ", direcciones=" + direcciones + "]";
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

	public Handler getDni() {
		return dni;
	}

	public void setDni(String dni) throws DNIException {
		this.dni = new DNIHandler(dni);
	}
	
	public void setDni(Handler dni) throws DNIException {
		this.dni = dni;
	}

	public List<DireccionDomain> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<DireccionDomain> direcciones) {
		this.direcciones = direcciones;
	}

		
}
