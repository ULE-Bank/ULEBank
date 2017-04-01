/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class TESTINGLOADERController {

	@RequestMapping(value="/tl", method=RequestMethod.GET)
	public String returnLoader(){
		return "TESTINGLOADER";
	}
}
