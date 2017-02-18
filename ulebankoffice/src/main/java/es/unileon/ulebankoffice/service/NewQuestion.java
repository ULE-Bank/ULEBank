package es.unileon.ulebankoffice.service;
import javax.validation.constraints.NotNull;

public class NewQuestion {
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellidos; 
	
	@NotNull
	private String claseSocial; 
	
	@NotNull
	private String estadoCivil; 
	
	@NotNull
	private String cargas; 
	
	@NotNull
	private String titulo;
	
	@NotNull
	private String url;
	
	@NotNull
	private String comentarios;
	
	@NotNull
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getClaseSocial() {
		return claseSocial;
	}
	public void setClaseSocial(String claseSocial) {
		this.claseSocial = claseSocial;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCargas() {
		return cargas;
	}
	public void setCargas(String cargas) {
		this.cargas = cargas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
