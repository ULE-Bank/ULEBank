/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
public class QueryOKController {

	@RequestMapping(value="/queryok")
	public String controllerVacio(){
		return "question-verification";
	}
	
}
