package es.unileon.ulebankoffice.web;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.appengine.repackaged.com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class TokenSignInController {
	
	private String REDIRECT_URI = "http://localhost:8080";
	
	@RequestMapping(value="/tokensignin")
	public void verificarUsuario(HttpServletRequest request){
		// (Receive authCode via HTTPS POST)
				
		
		if (request.getHeader("X-Requested-With") == null) {
		  System.err.println("No se ha encontrado cabecera xrequestedwith");
		}
		
	
		
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new HttpTransport() {
			
			@Override
			protected LowLevelHttpRequest buildRequest(String arg0, String arg1) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		}, new JacksonFactory())
			    .setAudience(Collections.singletonList("412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com"))
			    // Or, if multiple clients access the backend:
			    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
			    .build();
		
		String idTokenString = request.getParameter("idtoken");
		System.out.println("El idtoken recibido es: " + idTokenString);
		
		
		GoogleIdToken idToken;
		try {
			idToken = verifier.verify(idTokenString);
			if (idToken != null) {
				  Payload payload = idToken.getPayload();

				  // Print user identifier
				  String userId = payload.getSubject();
				  System.out.println("User ID: " + userId);

				  // Get profile information from payload
				  String email = payload.getEmail();
				  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
				  String name = (String) payload.get("name");
				  String pictureUrl = (String) payload.get("picture");
				  String locale = (String) payload.get("locale");
				  String familyName = (String) payload.get("family_name");
				  String givenName = (String) payload.get("given_name");

				  // Use or store profile information
				  // ...

				} else {
				  System.out.println("Invalid ID token.");
				}
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
 	

}
