package es.unileon.ulebankoffice.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.ClienteDomain;
import es.unileon.ulebankoffice.repository.ClienteRepository;
import es.unileon.ulebankoffice.service.Cliente;



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
