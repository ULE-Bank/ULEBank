package es.unileon.ulebankoffice.configuration;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BCrypTest {

	@Autowired 
	private BCryptPasswordEncoder bcrypt;
	
	@Before
	public void before(){
		bcrypt = new BCryptPasswordEncoder();
	}
	
	@Test
	public void test() {
		String password = "passwordEjemeplo";
		for (int i = 0; i < 3; i++) {
			String encoded = bcrypt.encode(password);
			assertTrue("Coinciden",bcrypt.matches(password, encoded));
		}
		

	}

}
