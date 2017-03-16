/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.repositories.ClienteRepository;
import es.unileon.ulebankoffice.service.Cliente;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
@RequestMapping("/u")
public class OfficeClientPageController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.GET, params = {"uin"})
	public String showClientData(ModelMap model, @RequestParam("uin") String dni){
		
		List<Cliente> clientes = clienteRepository.findByDni(dni);
		
		
		
		model.addAttribute("cliente", clientes);
		
		return "officeclientpage";
	}

}
