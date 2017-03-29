/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class JavaLangExceptionController {
	
	@RequestMapping(value="/oops")
	public String returnErrorWindow(){
		return "answer-verification";
	}
	
}
