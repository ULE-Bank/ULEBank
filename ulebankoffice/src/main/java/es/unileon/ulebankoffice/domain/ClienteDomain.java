package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
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

	// public ClienteDomain(String name, String lastname, String dni) throws
	// DNIException{
	// this.name = name;
	// this.lastname = lastname;
	// this.dni = new DNIHandler(dni);
	// }

	/**
	 * Constructor por defecto utilizado para instanciar objetos de esta clase
	 * cuando se obtiene el DBObject a través de mongo repository. La
	 * anotación @PersistanceConstructor indica que sea este el constructor que
	 * ha de usarse para tal acción. <b>Ver también:</b>
	 * http://docs.spring.io/spring-data/data-mongo/docs/1.1.0.RELEASE/reference
	 * /html/#mapping-chapter
	 * 
	 * @param name
	 * @param lastname
	 * @param email
	 * @param fechaNacimiento
	 * @param dni
	 * @param direcciones
	 * @throws ParseException
	 * @throws DNIException
	 */
	@PersistenceConstructor
	public ClienteDomain(String name, String lastname, String email, Date fechaNacimiento, Handler dni,
			List<DireccionDomain> direcciones) throws ParseException, DNIException {

		this.name = name;
		this.lastname = lastname;
		this.email = email;
		// this.fechaNacimiento = df.parse(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
		setDni(dni);
		this.direcciones = direcciones;

	}

	/**
	 * Constructor usado para instanciar manualmente objetos de la clase
	 * ClienteDomain. Recibe como parámetros de tipo String la fecha y el dni
	 * para que sea más fácul su declaración. Se comprueba si estos parámetros
	 * son adecuados sintáctica y semánticamente.
	 * 
	 * @param name
	 * @param lastname
	 * @param email
	 * @param fechaNacimiento
	 * @param dni
	 * @param direcciones
	 * @throws ParseException
	 * @throws DNIException
	 */
	public ClienteDomain(String name, String lastname, String email, String fechaNacimiento, String dni,
			List<DireccionDomain> direcciones) throws ParseException, DNIException {
		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		Date userDate = df.parse(fechaNacimiento);
		
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.fechaNacimiento = userDate;
		setDni(dni);
		this.direcciones = direcciones;
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

	public void addDireccion(DireccionDomain direccion) {
		this.direcciones.add(direccion);
	}

}
