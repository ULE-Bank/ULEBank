package es.unileon.ulebankoffice.web;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.ItalianoDomain;
import es.unileon.ulebankoffice.service.PrestamoMetodoItaliano;

@Controller
public class PrestamoItalianoFormController {
	
	@RequestMapping(value = "/italianloan", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("prestamoMetodoItaliano") @Valid 
    		PrestamoMetodoItaliano prestamoMetodoItaliano, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("italianloan");
		
		if (bindingResult.hasErrors())
        	return model;
		
		double C0 = prestamoMetodoItaliano.getC0();
		double i = prestamoMetodoItaliano.getI();
		int k = prestamoMetodoItaliano.getK();
		int p = prestamoMetodoItaliano.getP();
		
		ItalianoDomain myItaliano = new ItalianoDomain(C0, i, k, p);
		
		List<List<String>> tabla = myItaliano.calcular();
		
        model.addObject("tabla", tabla);
        
        response.addCookie(new Cookie("resultados", "1"));

        return model;	
	}
	
	@RequestMapping(value = "/italianloan", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("prestamoMetodoItaliano", new PrestamoMetodoItaliano());
        
        return "italianloan";
    }
}

