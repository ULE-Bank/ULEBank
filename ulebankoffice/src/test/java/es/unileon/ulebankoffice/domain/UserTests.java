/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class UserTests {
	
	
	private User user;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		user = new User();
	}
	
	

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#User()}.
	 */
	@Test
	public void testUserConstructorVacio() {
		//assertNull(user.getEmail());
		assertNull(user.getLastname());
		assertNull(user.getName());
		assertNull(user.getPassword());
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#User(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserConstructorConParametros() {
		user = new User("Razvan", "Raducu", "admin@ulebankoffice.com", "Contraseña ejemplo");
		assertEquals(user.getEmail(), "admin@ulebankoffice.com");
		assertEquals(user.getName(), "Razvan");
		assertEquals(user.getLastname(), "Raducu");
		assertEquals(user.getPassword(), "Contraseña ejemplo");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#getName()}.
	 */
	@Test
	public void testGetName() {
		user.setName("Razvan");
		assertEquals(user.getName(), "Razvan");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		user.setName("Razvan");
		assertEquals(user.getName(), "Razvan");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		user.setEmail("admin@ulebankoffice.com");
		assertEquals(user.getEmail(), "admin@ulebankoffice.com");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmail() {
		user.setEmail("admin@ulebankoffice.com");
		assertEquals(user.getEmail(), "admin@ulebankoffice.com");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		user.setPassword("Contraseña ejemplo");
		assertEquals(user.getPassword(), "Contraseña ejemplo");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		user.setPassword("Contraseña ejemplo");
		assertEquals(user.getPassword(), "Contraseña ejemplo");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#getLastname()}.
	 */
	@Test
	public void testGetLastname() {
		user.setLastname("Raducu");
		assertEquals(user.getLastname(), "Raducu");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#setLastname(java.lang.String)}.
	 */
	@Test
	public void testSetLastname() {
		user.setLastname("Raducu");
		assertEquals(user.getLastname(), "Raducu");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.User#toString()}.
	 */
	@Test
	public void testToString() {
		user.setEmail("1");
		user.setName("2");
		user.setLastname("3");
		user.setPassword("4");
		assertEquals(user.toString(), "El usuario: 2 3 está asociado al e-mail 1 y su contraseña es 4");
	}

}
