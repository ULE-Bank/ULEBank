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

import es.unileon.ulebankoffice.domain.FrancesDomain;
import es.unileon.ulebankoffice.service.PrestamoFrancesCuotaConstante;

@Controller
public class PrestamoFrancesCuotaConsFormController {
	
	@RequestMapping(value = "/frenchloan", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("prestamoFrancesCuotaConstante")
    		PrestamoFrancesCuotaConstante prestamoFrancesCuotaConstante, BindingResult bindingResult, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView("frenchloan");
		
		if (bindingResult.hasErrors())
        	return model;
		
		double C0 = prestamoFrancesCuotaConstante.getC0();
		double i = prestamoFrancesCuotaConstante.getI();
		int k = prestamoFrancesCuotaConstante.getK();
		int p = prestamoFrancesCuotaConstante.getP();
		
		FrancesDomain myFrances = new FrancesDomain(i, C0, k, p);
		
		List<List<String>> tabla = myFrances.calcular();
		
		model.addObject("tabla", tabla);
		
		response.addCookie(new Cookie("resultados", "1"));

        return model;	
	}
	
	@RequestMapping(value = "/frenchloan", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("prestamoFrancesCuotaConstante", new PrestamoFrancesCuotaConstante());
        
        return "frenchloan";
    }
}
