/**
 * 
 */
package es.unileon.ulebankoffice.service;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebankoffice.domain.User;

/**
 * @author Razvi Razvan Raducu
 *
 */
public class SimpleUserManagerTests {

	private SimpleUserManager sum;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sum = new SimpleUserManager();
		sum.setUsuarios(new ArrayList<User>());
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.service.SimpleUserManager#registrarUsuario(es.unileon.ulebankoffice.domain.User)}.
	 */
	@Test
	public void testRegistrarUsuario() {
		sum.registrarUsuario(new User("Razvan", "Raducu","email","password"));
		assertEquals(sum.obtenerUsuario("email").getName(), "Razvan");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.service.SimpleUserManager#getUsuarios()}.
	 */
	@Test
	public void testGetUsuarios() {
		sum.registrarUsuario(new User("Razvan", "Raducu","email","password"));
		sum.registrarUsuario(new User("Razvan2", "Raducu","email","password"));
		sum.registrarUsuario(new User("Razvan3", "Raducu","email","password"));
		
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("Razvan", "Raducu","email","password"));
		userList.add(new User("Razvan2", "Raducu","email","password"));
		userList.add(new User("Razvan3", "Raducu","email","password"));
		
		
		assertEquals(sum.getUsuarios().get(0).getName(), userList.get(0).getName());
		assertEquals(sum.getUsuarios().get(1).getName(), userList.get(1).getName());
		assertEquals(sum.getUsuarios().get(2).getName(), userList.get(2).getName());
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.service.SimpleUserManager#usuarioYaRegistrado(java.lang.String)}.
	 */
	@Test
	public void testUsuarioYaRegistrado() {
		sum.registrarUsuario(new User("Razvan", "Raducu","email","password"));
		assertTrue(sum.usuarioYaRegistrado("email"));
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.service.SimpleUserManager#obtenerUsuario(java.lang.String)}.
	 */
	@Test
	public void testObtenerUsuario() {
		sum.registrarUsuario(new User("Razvan", "Raducu","email","password"));
		assertEquals(sum.obtenerUsuario("email").getPassword(), "password");
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.service.SimpleUserManager#setUsuarios(java.util.List)}.
	 */
	@Test
	public void testSetUsuarios() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("Razvan", "Raducu","email","password"));
		userList.add(new User("Razvan2", "Raducu","email","password"));
		userList.add(new User("Razvan3", "Raducu","email","password"));
		
		sum.setUsuarios(userList);
		assertEquals(sum.getUsuarios(), userList);
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.service.SimpleUserManager#toString()}.
	 */
	@Test
	public void testToString() {
		sum.registrarUsuario(new User("Razvan", "Raducu","email","password"));
		assertEquals(sum.toString(), "El usuario: Razvan Raducu está asociado al e-mail email y su contraseña es password");
	}

}
