package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
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

	private String name, lastname, email, nacionalidad;

	private Date fechaNacimiento, fechaDeAlta;

	@Indexed(unique = true)
	private Handler dni;

	private List<DireccionDomain> direcciones;

	@Transient
	private Documentos documentos;

	private List<String> idDocumentos;

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
			List<DireccionDomain> direcciones, List<String> idDocumentos, String nacionalidad)
			throws ParseException, DNIException {
		
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		setDni(dni);
		this.direcciones = direcciones;
		this.idDocumentos = idDocumentos;
		this.documentos = new Documentos();		
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
			List<DireccionDomain> direcciones, String nacionalidad, List<String> idDocumentos) throws ParseException, DNIException {
		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		Date userDate = df.parse(fechaNacimiento);

		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.fechaNacimiento = userDate;
		setDni(dni);
		this.direcciones = direcciones;
		this.nacionalidad = nacionalidad;
		this.idDocumentos = idDocumentos;
		this.documentos = new Documentos();
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

	public void addDocumento(DocumentoAdjuntoDomain documento) {
		// Se deben guardar las ids de los documentos que pertenecen a este
		// cliente en su atributo idDocumentos. Para obtener esta ID que es
		// automáticamente generada por MongoDB se debe hacer lo siguiente: 1-
		// Guardar el documento en el repositorio. 2- Obtener la ID después de
		// que se haya producido el guardado. Los TESTS dirán la verdad
		documentos.addDocumento(documento);
		idDocumentos.add(documento.getId());
	}

	public List<DocumentoAdjuntoDomain> getDocumentos() {
		return documentos.getDocumentos(this.idDocumentos);
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	@Override
	public String toString() {
		return "ClienteDomain [name=" + name + ", lastname=" + lastname + ", email=" + email + ", nacionalidad="
				+ nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", fechaDeAlta=" + fechaDeAlta + ", dni="
				+ dni + ", direcciones=" + direcciones + ", documentos=" + documentos + ", idDocumentos=" + idDocumentos
				+ "]";
	}

}
