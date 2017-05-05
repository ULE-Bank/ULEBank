package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * @author Razvan Raducu
 *
 */
@Controller
public class OfficeIndexController {

	/*Opcional para desplegar en el servidor de producción. Así los usuarios no tienen acceso a la DB
	 * hasta que no esté to-do implementado*/
	@RequestMapping(value= "/o", method = RequestMethod.GET)
	public String comingSoon(){
		return "coming-soon-1";
	}
	
	
}
