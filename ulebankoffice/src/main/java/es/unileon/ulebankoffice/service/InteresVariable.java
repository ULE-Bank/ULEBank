/**
 * 
 */
package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */
public class InteresVariable {
	
	@NotNull @Min(0)
	private double interes;
	
	public InteresVariable(){}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	
	
}
