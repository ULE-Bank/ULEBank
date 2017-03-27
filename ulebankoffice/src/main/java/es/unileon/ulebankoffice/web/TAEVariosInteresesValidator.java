/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.unileon.ulebankoffice.service.InteresVariable;
import es.unileon.ulebankoffice.service.TAEVariosIntereses;

/**
 * @author Razvan Raducu
 *
 */
public class TAEVariosInteresesValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return TAEVariosIntereses.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		int i = 0;
		TAEVariosIntereses tae = (TAEVariosIntereses) target;
		
		for (InteresVariable interes : tae.getIntereses()) {
			double interesAux = interes.getInteres();
			if(interesAux < 0 ){
				errors.rejectValue("intereses[" + i + "].interes", "fieldIsLessThanZero");
				System.out.println("he llegado en el less tan zero");
			} 
			i++;
		}
		
		
		
	}

}
