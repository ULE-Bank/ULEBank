/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.unileon.ulebankoffice.domain.AdvisorUserDomain;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;

/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping(value="/offersconsulting/queryok")
public class QueryOKController {
	
	@Autowired
	private AdvisorUserRepository repo;

	@GetMapping
	public String controllerVacio(ModelMap model, 	Principal principal){
		
		String emailUsuario = principal.getName();
		
		AdvisorUserDomain user = repo.findByEmail(emailUsuario);
		
		if(user.getResultadoTest() <= 0.0){
			model.addAttribute("testPendiente", 1);
			model.addAttribute("emailUsuario", emailUsuario);
		}
		
		return "question-verification";
	}
	
}
