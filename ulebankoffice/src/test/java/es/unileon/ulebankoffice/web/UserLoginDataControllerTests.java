package es.unileon.ulebankoffice.web;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.User;
import es.unileon.ulebankoffice.service.SimpleUserManager;

/**
 * 
 */

/**
 * @author Razvi Razvan Raducu
 *
 */
public class UserLoginDataControllerTests {
	private UserLoginDataController uldc;
	private SimpleUserManager usuariosManager;
	
	/**
	 * Test method for {@link es.unileon.ulebankoffice.web.UserLoginDataController#paginaDeLogin(java.lang.String, java.lang.String)}.
	 */
	
	@Before
	public void setup(){
		uldc = new UserLoginDataController();
		ArrayList<User> userList = new ArrayList<>();
		userList.add(new User("admin", "admin","admin@ulebankoffice.com","password"));
		userList.add(new User("nombre", "apellido","nombre@ulebankoffice.com","password"));
		userList.add(new User("Ejemplo1", "Ejemplo1","Ejemplo1@ulebankoffice.com","password"));
		usuariosManager = new SimpleUserManager();
		usuariosManager.setUsuarios(userList);
		uldc.setUsuariosManager(usuariosManager);
	}
	
	@Test
	public void testPaginaDeLoginUsuarioNoExiste() {
		ModelAndView model = uldc.paginaDeLogin("emailquenoexiste", "password");
		assertEquals("usuarios", model.getViewName());
		Map<String, Object> map = (Map<String, Object>) model.getModel().get("model");
		String value = (String) map.get("mensajeEnFuncionDeMetodo");
		assertEquals(value, "El usuario no existe");
	}
	
	@Test
	public void testPaginaDeLoginContrasenaIncorrecta() {
		ModelAndView model = uldc.paginaDeLogin("admin@ulebankoffice.com", "passwordincorrecta");
		assertEquals("usuarios", model.getViewName());
		Map<String, Object> map = (Map<String, Object>) model.getModel().get("model");
		String value = (String) map.get("mensajeEnFuncionDeMetodo");
		assertEquals("Contraseña incorrecta", value);
	}
	
	
	@Test
	public void testPaginaDeLogin() {
		ModelAndView model = uldc.paginaDeLogin("admin@ulebankoffice.com", "password");
		Map<String, Object> map = (Map<String, Object>) model.getModel().get("model");
		assertEquals("usuarios", model.getViewName());
		assertNotNull(map.get("mensajeEnFuncionDeMetodo"));
		assertNotNull(map.get("todosLosUsuarios"));
		String value = (String) map.get("mensajeEnFuncionDeMetodo");
		assertEquals(value, "El usuario: admin admin está asociado al e-mail admin@ulebankoffice.com y su contraseña es password");
		ArrayList<User> todosLosUsuarios = (ArrayList<User>) map.get("todosLosUsuarios");
		assertEquals("admin", todosLosUsuarios.get(0).getName());
		assertEquals("nombre", todosLosUsuarios.get(1).getName());
		assertEquals("Ejemplo1", todosLosUsuarios.get(2).getName());
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.web.UserLoginDataController#paginaDeRegistro(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPaginaDeRegistroUsuarioYaExistente() {
		ModelAndView model = uldc.paginaDeRegistro("admin@ulebankoffice.com", "password", "admin", "admin");
		String value  =  (String) model.getModel().get("mensaje");
		assertEquals("registrousuarios", model.getViewName());
		assertNotNull(value);
		assertEquals("Error. El usuario ya existe.", value);
	}
	
	@Test
	public void testPaginaDeRegistro() {
		ModelAndView model = uldc.paginaDeRegistro("emailquenoexiste", "password", "admin", "admin");
		String value  =  (String) model.getModel().get("mensaje");
		assertEquals("registrousuarios", model.getViewName());
		assertNotNull(value);
		assertEquals(value,"Usuario registrado correctamente.");
	}

}
