/**
 * 
 */
package es.unileon.ulebankoffice.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
public class TAEVariosInteresesController {
	
	@RequestMapping(value="/aprv", method=RequestMethod.GET)
	public String getAprvView(){
		return "aprv";
	}
	
	@RequestMapping(value="/aprv", method=RequestMethod.POST)
	public String calculateAprv(ModelMap model,  BindingResult result){
		
		return "aprv";
	}
}
