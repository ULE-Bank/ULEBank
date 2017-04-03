/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "ExpedientesElectronicos")
public class ExpedienteElectronicoDomain {

	@Id
	private String id;

	// Con esto se asegura que en la base de datos sólo habrá un expediente
	// elctrónico por DNI
	@Indexed(unique = true)
	private Handler dni;

	private Date fechaDeApertura, fechaDeCierre;

	@Autowired
	SimpleDateFormat dateFormat;

	public ExpedienteElectronicoDomain(String dni) throws DNIException, ParseException {
		this.dni = new DNIHandler(dni);
		this.fechaDeApertura = dateFormat.parse(new Date().toString());
	}

	public Handler getDni() {
		return dni;
	}

	public void setDni(Handler dni) {
		this.dni = dni;
	}

	public Date getFechaDeApertura() {
		return fechaDeApertura;
	}

	public void setFechaDeApertura(Date fechaDeApertura) {
		this.fechaDeApertura = fechaDeApertura;
	}

	public Date getFechaDeCierre() {
		return fechaDeCierre;
	}

	public void setFechaDeCierre(Date fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

}
