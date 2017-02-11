/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	private String email;
	private String password;
	
	public void setUsuariosManager(UserManager usuariosManager) {
		this.usuariosManager = usuariosManager;
	}

	@RequestMapping(value = "/usuarios", method = {RequestMethod.POST}, params={"login"})
	public ModelAndView paginaDeLogin(@RequestParam("email") String email, @RequestParam("password") String password){

		Map<String, Object> myModel = new HashMap<>();
		
		User usuarioAuxiliar = usuariosManager.obtenerUsuario(email);
		if(usuarioAuxiliar == null){
			myModel.put("mensajeEnFuncionDeMetodo", "El usuario no existe");
			return new ModelAndView("usuarios","model",myModel);
		}
		
		
		if(!usuarioAuxiliar.getPassword().equals(password)){
			myModel.put("mensajeEnFuncionDeMetodo", "Contraseña incorrecta");
			this.email = email;
			this.password= password; 
			return new ModelAndView("usuarios","model",myModel);
		}
		
		myModel.put("mensajeEnFuncionDeMetodo", usuarioAuxiliar.toString());
		if(usuarioAuxiliar.getEmail().equals("admin@ulebankoffice.com")){
			myModel.put("todosLosUsuarios", usuariosManager.getUsuarios());
		}
		System.out.println("Alguien ha iniciado sesión con el usuario: ->" + usuarioAuxiliar.toString());
		return new ModelAndView("usuarios","model",myModel);
		
		
	}
	
	@RequestMapping(value = "/usuarios", method = {RequestMethod.POST}, params={"signup"})
	public ModelAndView paginaDeRegistro(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("lastname") String lastname){
		
		if(usuariosManager.usuarioYaRegistrado(email)){
			return new ModelAndView("registrousuarios","mensaje","Error. El usuario ya existe.");
		}
		
		User nuevoUsuario = new User(name, lastname, email, password);
		
		usuariosManager.registrarUsuario(nuevoUsuario);
		System.out.println("Alguien ha registrado el usuario: ->" + nuevoUsuario.toString());
		return new ModelAndView("registrousuarios","mensaje","Usuario registrado correctamente.");
		
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView internacionalización(){
		Map<String, Object> myModel = new HashMap<>();
		if(email != null && password != null){
			
			
			User usuarioAuxiliar = usuariosManager.obtenerUsuario(email);
			myModel.put("mensajeEnFuncionDeMetodo", usuarioAuxiliar.toString());
			if(usuarioAuxiliar.getEmail().equals("admin@ulebankoffice.com")){
				myModel.put("todosLosUsuarios", usuariosManager.getUsuarios());
			}
		} else {
			myModel.put("mensajeEnFuncionDeMetodo", "FORBIDDEN");
		}
		
		return new ModelAndView("usuarios","model",myModel);
	}
}
