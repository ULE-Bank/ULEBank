package es.unileon.ulebankoffice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.unileon.ulebankoffice.domain.UleBankEmployeeDomain;
import es.unileon.ulebankoffice.repository.UleBankEmployeeRepository;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class IndexController {
	
	

	@RequestMapping(value = { "/", "/inicio", "/index*" })
	public String controllerVacio() {

		
		return "index";
	}


}
