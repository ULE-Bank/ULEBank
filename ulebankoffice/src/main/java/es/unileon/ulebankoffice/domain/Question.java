package es.unileon.ulebankoffice.domain;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;

/**
 * Clase originalmente diseñada para poder añadir consultas a la página. A fecha
 * de hoy 23.04.2017 es 100% dependiente, altísimo acoplamiento, de la clase
 * Datastore de GAE. En cuanto se produzca la migración de GAE, esta clase
 * dejará de funcionar.
 * 
 * @author Razvan Raducu, Alexis Gutierrez
 *
 * 
 *
 */
public class Question {

	private String[] propertiesValues;

	private String id;

	private Logger logger = Logger.getLogger("ulebankLogger");

	private Datastore datastore;

	private String state = "state";
	private String respuesta = "respuesta";
	private String questionString = "Question";
	
	/**
	 * @param propertiesValues
	 * @param datastore
	 */
	public Question(String[] propertiesValues, Datastore datastore) {
		this.propertiesValues = propertiesValues;
		this.datastore = datastore;
	}

	/**
	 * @param id
	 * @param datastore
	 */
	public Question(String id, Datastore datastore) {
		this.id = id;
		this.datastore = datastore;
	}

	/**
	 * Método utilizado para popular
	 */
	public void insertQuestion() {
		String[] properties = new String[12];
		properties[0] = "email";
		properties[1] = "nombre";
		properties[2] = "apellidos";
		properties[3] = "edad";
		properties[4] = "claseSocial";
		properties[5] = "estadoCivil";
		properties[6] = "cargasFamiliares";
		properties[7] = "titulo";
		properties[8] = "comentarios";
		properties[9] = "url";
		properties[10] = state;
		properties[11] = respuesta;

		datastore.insertEntity(questionString, properties, propertiesValues);
	}

	/**
	 * Método utilizado para crear la respuesta
	 * 
	 * @param reply
	 * @param userMail
	 */
	public void reply(String reply, String userMail) {
		String[] propertiesToUpdate = new String[2];
		propertiesToUpdate[0] = state;
		propertiesToUpdate[1] = respuesta;

		String[] values = new String[2];
		values[0] = "Resuelta";
		values[1] = reply;

		try {
			datastore.updateEntity(questionString, id, propertiesToUpdate, values);
		} catch (NumberFormatException | EntityNotFoundException e1) {
			logger.error("Error en :" + e1.getMessage() + this.getClass() + e1);
		}

		Email email = new Email(userMail, reply);

		try {
			email.send();
		} catch (UnsupportedEncodingException | MessagingException e) {
			logger.error("Error en :" + e.getMessage() + this.getClass() + e);
		}
	}

	public String[] getQuestion() {
		String[] questions = new String[7];

		Entity result = datastore.query(questionString, id);

		questions[0] = (String) result.getProperty("nombre");
		questions[1] = (String) result.getProperty("apellidos");
		questions[2] = (String) result.getProperty("titulo");
		questions[3] = (String) result.getProperty("url");
		questions[4] = (String) result.getProperty("comentarios");
		questions[5] = (String) result.getProperty(state);
		questions[6] = (String) result.getProperty(respuesta);

		return questions;
	}
}
