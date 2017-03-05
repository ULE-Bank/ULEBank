package es.unileon.ulebankoffice.domain;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Authenticator {
	
	/*
	private static Authenticator authenticator;
	
	public static Authenticator getAuthenticator() {
		if(authenticator == null)
			authenticator = new Authenticator();
		
		return authenticator;
	}
	*/
	
	public boolean isAuthenticated(HttpServletRequest request) {
		return request.getUserPrincipal() != null;
	}
	
	public String login(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		
		return "redirect:" + userService.createLoginURL(request.getRequestURI());
		//return "redirect:/login";
	}
	
	public String logout() {
		UserService userService = UserServiceFactory.getUserService();
		
		return "redirect:" + userService.createLogoutURL("/");
	}
	
	public String getUserEmail(HttpServletRequest request) {
		return request.getUserPrincipal().getName();
	}
	
	public boolean isAdmin(HttpServletRequest request) {
		//System.out.println("Esto es lo que devuelve el request -> [" + request.getUserPrincipal().getName() + "]" );
		return Datastore.getDatastore().queryForExists("Admins", "Email", request.getUserPrincipal().getName());
	}
}
