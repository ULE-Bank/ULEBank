/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * @author Razvi Razvan Raducu
 *
 */
public class User {

	private String name;
	private String lastname;
	private String email;
	private String password;

	public User(){
		
	}
	
	public User(String name, String lastname, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String toString() {
		return "El usuario: " + name + " " + lastname + " está asociado al e-mail " + email + " y su contraseña es "
				+ password;
	}

}
