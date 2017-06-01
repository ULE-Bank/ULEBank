package es.unileon.ulebankoffice.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Authenticator {
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
	public boolean isAuthenticated(HttpServletRequest request) {
		logger.debug("Se está comrpobando si alguien que está deseando entrar en el consultor financiero está logeado ya.");
		return request.getUserPrincipal() != null;
	}
	
	public String login(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		
		return "redirect:" + userService.createLoginURL(request.getRequestURI());
		
	}
	
	public String logout() {
		UserService userService = UserServiceFactory.getUserService();
		
		return "redirect:" + userService.createLogoutURL("/");
	}
	
	public String getUserEmail(HttpServletRequest request) {
		return request.getUserPrincipal().getName();
	}
	
	public boolean isAdmin(HttpServletRequest request) {
		return Datastore.getDatastore().queryForExists("Admins", "Email", request.getUserPrincipal().getName());
	}
}
