package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class LoginController {

		@RequestMapping(value="/login")
		public String controllerLogin(){
			return "login";
		}
}
