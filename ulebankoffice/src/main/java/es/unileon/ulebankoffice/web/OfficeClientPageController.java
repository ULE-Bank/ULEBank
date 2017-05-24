/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.ClienteDomain;
import es.unileon.ulebankoffice.repository.ClienteRepository;
import es.unileon.ulebankoffice.repository.DireccionRepository;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
@RequestMapping("/u")
public class OfficeClientPageController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired 
	private DireccionRepository direccionesRepo;
	
	@RequestMapping(method = RequestMethod.GET, params = {"uin"})
	public String showClientData(ModelMap model, @RequestParam("uin") String dni){
		
		ClienteDomain clienteEncontrado = clienteRepo.findByDni(dni);
		
		
		
		model.addAttribute("cliente", clienteEncontrado);
		model.addAttribute("direcciones", direccionesRepo.findByDni(clienteEncontrado.getDni().toString()));
		
		return "officeclientpage";
	}

}
