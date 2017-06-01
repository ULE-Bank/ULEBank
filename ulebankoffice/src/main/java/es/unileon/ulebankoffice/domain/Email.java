package es.unileon.ulebankoffice.domain;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	private static final String FROMEMAIL = "mywebapp-1114@appspot.gserviceaccount.com";
	private static final String FROM = "Administrador ULe-Bank";
	private String toEmail;
	private static final String TO = "Estimado usuario";
	private static final String SUBJECT = "Respuesta a su consulta en ULe-Bank";
	private String answer;
	
	public Email(String toEmail, String answer) {
		this.toEmail = toEmail;
		this.answer = answer;
	}
	
	public void send() throws UnsupportedEncodingException, MessagingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		 Message msg = new MimeMessage(session);
		 
		 msg.setFrom(new InternetAddress(FROMEMAIL, FROM));
		 msg.addRecipient(Message.RecipientType.TO,
				 new InternetAddress(toEmail, TO));
		 msg.setSubject(SUBJECT);
		 msg.setText(answer);
		 
		 Transport.send(msg);
	}
}
