package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping("/encodingTesting")
public class EncodingTestController {
	
	@GetMapping
	public String getView(){
		return "testingformencoding";
	}
	
	@PostMapping
	public String getPost(@RequestParam("String") String cadenaDesdeForm, ModelMap model){
		model.addAttribute("stringrecibida", cadenaDesdeForm);
		System.out.println("He recbido " + cadenaDesdeForm);
		return "testingformencoding";
	}
	

}
