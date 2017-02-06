package es.unileon.ulebankoffice.service;

import java.util.List;

import es.unileon.ulebankoffice.domain.User;

/**
 * @author Razvan Raducu Tratando de hacer una primera aproximación al
 *         login/logout mediante interfaces y listas (nade de base de datos o
 *         persistencia) 06.02.2017
 */
public interface UserManager {

	public void registrarUsuario(User usuario);
	
	public List<User> getUsuarios();
	
	public boolean usuarioYaRegistrado(String email);
	
	public User obtenerUsuario(String email);
}
