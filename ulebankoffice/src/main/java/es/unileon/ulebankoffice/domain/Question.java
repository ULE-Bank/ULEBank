package es.unileon.ulebankoffice.domain;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;

public class Question {
	
	private String[] propertiesValues;
	
	private String id;
	
	private Logger logger = Logger.getLogger("ulebankLogger");
	
	private Datastore datastore;
	
	public Question(String[] propertiesValues, Datastore datastore) {
		this.propertiesValues = propertiesValues;
		this.datastore = datastore;
	}
	
	public Question(String id, Datastore datastore) {
		this.id = id;
		this.datastore = datastore;
	}
	
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
		properties[10] = "state";
		properties[11] = "respuesta";
		
		datastore.insertEntity("Question", properties, propertiesValues);
	}
	
	public void reply(String reply, String userMail) {
		String[] propertiesToUpdate = new String[2];
		propertiesToUpdate[0] = "state";
		propertiesToUpdate[1] = "respuesta";
		
		String[] values = new String[2];
		values[0] = "Resuelta";
		values[1] = reply;
		
		try {
			datastore.updateEntity("Question", id, propertiesToUpdate, values);
		} catch (NumberFormatException | EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			logger.error("Error en :" + e1.getMessage() + this.getClass() + e1);
		}
		
		Email email = new Email(userMail, reply);
		
		try {
			email.send();
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			logger.error("Error en :" + e.getMessage() + this.getClass() + e);
		}
	}
	
	public String[] getQuestion() {
		String[] question = new String[7];
		
		Entity result = datastore.query("Question", id);
    	
    	question[0] = (String) result.getProperty("nombre");
    	question[1] = (String) result.getProperty("apellidos");
    	question[2] = (String) result.getProperty("titulo");
    	question[3] = (String) result.getProperty("url");
    	question[4] = (String) result.getProperty("comentarios");
    	question[5] = (String) result.getProperty("state");
    	question[6] = (String) result.getProperty("respuesta");
    	
    	return question;
	}
}
