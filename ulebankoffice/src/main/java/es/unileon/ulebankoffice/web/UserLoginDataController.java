/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.User;
import es.unileon.ulebankoffice.service.UserManager;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
public class UserLoginDataController {
	
	@Autowired
	private UserManager usuariosManager;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, params={"login"})
	public ModelAndView paginaDeLogin(@RequestParam("email") String email, @RequestParam("password") String password){
		
		
//		 Map<String, Object> myModel = new HashMap<>();
//	        myModel.put("now", now);
//	        myModel.put("products", productManager.getProducts());
	        
	        
//		User usuarioAuxiliar = null;
//		for (User user : usuarios.getUsuarios()) {
//			if(user.getEmail().equals(email)){
//				usuarioAuxiliar = user;
//			}
//		}
		

		Map<String, Object> myModel = new HashMap<>();
		
		User usuarioAuxiliar = usuariosManager.obtenerUsuario(email);
		if(usuarioAuxiliar == null){
			myModel.put("mensajeEnFuncionDeMetodo", "El usuario no existe");
			return new ModelAndView("usuarios","model",myModel);
		}
		
		
		if(!usuarioAuxiliar.getPassword().equals(password)){
			myModel.put("mensajeEnFuncionDeMetodo", "Contraseña incorrecta");
			return new ModelAndView("usuarios","model",myModel);
		}
		
		myModel.put("mensajeEnFuncionDeMetodo", usuarioAuxiliar.toString());
		if(usuarioAuxiliar.getEmail().equals("admin@ulebankoffice.com")){
			myModel.put("todosLosUsuarios", usuariosManager.getUsuarios());
		}
		System.out.println("Alguien ha iniciado sesión con el usuario: ->" + usuarioAuxiliar.toString());
		return new ModelAndView("usuarios","model",myModel);
		
		
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, params={"signup"})
	public ModelAndView paginaDeRegistro(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("lastname") String lastname){
		
		if(usuariosManager.usuarioYaRegistrado(email)){
			return new ModelAndView("registrousuarios","mensaje","Error. El usuario ya existe.");
		}
		
		User nuevoUsuario = new User(name, lastname, email, password);
		
		usuariosManager.registrarUsuario(nuevoUsuario);
		System.out.println("Alguien ha registrado el usuario: ->" + nuevoUsuario.toString());
		return new ModelAndView("registrousuarios","mensaje","Usuario registrado correctamente.");
		
	}
	
}
