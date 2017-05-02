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

import es.unileon.ulebankoffice.domain.AmericanoDomain;
import es.unileon.ulebankoffice.service.PrestamoMetodoAmericano;

@Controller
public class PrestamoAmericanoFormController {
	
	@RequestMapping(value = "/americanloan", method = RequestMethod.POST)
    public ModelAndView processAdd(@ModelAttribute("prestamoMetodoAmericano") @Valid 
    		PrestamoMetodoAmericano prestamoMetodoAmericano, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("americanloan");
		
		if (bindingResult.hasErrors())
        	return model;
		
		double C0 = prestamoMetodoAmericano.getC0();
		double i = prestamoMetodoAmericano.getI();
		int k = prestamoMetodoAmericano.getK();
		int p = prestamoMetodoAmericano.getP();
		
		AmericanoDomain myAmericano = new AmericanoDomain(C0, i, k, p);
		
		List<List<String>> tabla = myAmericano.calcularTabla();
		
        model.addObject("tabla", tabla);
        
        response.addCookie(new Cookie("resultados", "1"));

        return model;	
	}
	
	@RequestMapping(value = "/americanloan", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("prestamoMetodoAmericano", new PrestamoMetodoAmericano());
        
        return "americanloan";
    }
}
