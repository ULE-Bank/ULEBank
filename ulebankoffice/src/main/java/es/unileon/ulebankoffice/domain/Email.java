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
	
	private final String fromEmail = "mywebapp-1114@appspot.gserviceaccount.com";
	private final String from = "Administrador ULe-Bank";
	private String toEmail;
	private final String to = "Estimado usuario";
	private final String subject = "Respuesta a su consulta en ULe-Bank";
	private String answer;
	
	public Email(String toEmail, String answer) {
		this.toEmail = toEmail;
		this.answer = answer;
	}
	
	public void send() throws UnsupportedEncodingException, MessagingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		 Message msg = new MimeMessage(session);
		 
		 msg.setFrom(new InternetAddress(fromEmail, from));
		 msg.addRecipient(Message.RecipientType.TO,
				 new InternetAddress(toEmail, to));
		 msg.setSubject(subject);
		 msg.setText(answer);
		 
		 Transport.send(msg);
	}
}
