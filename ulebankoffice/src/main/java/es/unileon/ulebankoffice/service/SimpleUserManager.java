package es.unileon.ulebankoffice.service;

import java.util.List;

import es.unileon.ulebankoffice.domain.User;

/**
 * @author Razvan Raducu
 *
 */
public class SimpleUserManager implements UserManager{
	
	private List<User> usuarios;

	@Override
	public void registrarUsuario(User usuario) {
		usuarios.add(usuario);
		
	}

	@Override
	public List<User> getUsuarios() {
		return usuarios;
	}
	
	@Override
	public boolean usuarioYaRegistrado(String email){
		for (User user : usuarios) {
			if (user.getEmail().equals(email)){
				return true;
			}
		}
		return false;
	}

	@Override
	public User obtenerUsuario(String email) {
		for (User user : usuarios) {
			if (user.getEmail().equals(email)){
				return user;
			}
		}
		return null;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (User user : usuarios) {
			buffer.append(user.toString()+"\n");
		}
		
		return buffer.toString();
	}
	
	
	
}
