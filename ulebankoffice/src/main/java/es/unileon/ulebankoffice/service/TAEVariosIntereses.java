/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Razvan Raducu
 *
 */
public class TAEVariosIntereses {
	
	
	private List<InteresVariable> intereses;
	
	private int periodo;
	
	@NotNull @Min(0)
	private Double cantidad;

	public List<InteresVariable> getIntereses() {
		return intereses;
	}

	public void setIntereses(List<InteresVariable> intereses) {
		this.intereses = intereses;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
