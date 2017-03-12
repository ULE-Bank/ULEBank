/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa el documento ExpedienteElectronico dentro de la base de
 * datos. También es el atributo que se manejará desde el modelo. Contiene
 * anotaciones de Spring Data y de Hibernate Validator
 * 
 * @author Razvan Raducu
 *
 */
@Document(collection="ExpedientesElectronicos")
public class ExpedienteElectronico {
	
	@Id
	private String id;
	
//	private List<ProductoFinanciero> productosActivos, historialProductos;
	@NotEmpty @NotBlank @Past
	private Date fechaDeApertura;
	
	private Date fechaDeCierre;
	
	@NotEmpty @NotBlank
	private String dni;
//	private Handler dni;
	
//	public ExpedienteElectronico(String dni){
//		this.dni = dni;
//	}
	
//	public List<ProductoFinanciero> getProductosActivos() {
//		return productosActivos;
//	}
//
//	public void setProductosActivos(List<ProductoFinanciero> productosActivos) {
//		this.productosActivos = productosActivos;
//	}
//
//	public List<ProductoFinanciero> getHistorialProductos() {
//		return historialProductos;
//	}
//
//	public void setHistorialProductos(List<ProductoFinanciero> historialProductos) {
//		this.historialProductos = historialProductos;
//	}

	public Date getFechaDeApertura() {
		return fechaDeApertura;
	}

	public void setFechaDeApertura(Date fechaDeApertura) {
		this.fechaDeApertura = fechaDeApertura;
	}

	public Date getFechaDeCierre() {
		return fechaDeCierre;
	}

	public void setFechaDeCierre(Date fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

//	public Handler getDni() {
//		return dni;
//	}
//
//	public void setDni(Handler dni) {
//		this.dni = dni;
//	}

	
	
}
