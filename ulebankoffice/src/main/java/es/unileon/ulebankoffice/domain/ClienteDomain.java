package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
	
	@Autowired
	DateFormat dateFormat;
	
	public ClienteDomain(String name, String lastname, String email, String fechaNacimiento, String dni) throws ParseException, DNIException {
		
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.fechaNacimiento = dateFormat.parse(fechaNacimiento);
		this.dni = new DNIHandler(dni);
	}
}
