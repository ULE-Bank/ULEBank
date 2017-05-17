/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping(value="/offersconsutting/queryok")
public class QueryOKController {

	@GetMapping
	public String controllerVacio(){
		return "question-verification";
	}
	
}
