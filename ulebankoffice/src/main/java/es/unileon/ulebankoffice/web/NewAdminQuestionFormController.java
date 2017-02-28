package es.unileon.ulebankoffice.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.service.NewAdminQuestion;

@Controller
public class NewAdminQuestionFormController {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value = "/newadminquery", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("newAdminQuestion")
    		NewAdminQuestion newAdminQuestion, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp) {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		if (bindingResult.hasErrors())
        	return new ModelAndView("new-admin-question", "model", myModel);
		
		String[] properties = {"pregunta", "tipo", "ponderacion"};
		String[] propertiesValues = {newAdminQuestion.getPregunta(), "1", newAdminQuestion.getPonderacion()};
		
		datastore.insertEntity("AdminQuestion", properties, propertiesValues);

        return new ModelAndView("redirect:/questions-list");	
	}
	
	@RequestMapping(value = "/newadminquery", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest req, HttpServletResponse resp) {
        
        if (authenticator.isAuthenticated(req)) {
        	model.addAttribute("newAdminQuestion", new NewAdminQuestion());
            return "new-admin-question";
        }
        else    
        	return authenticator.login(req);
		
    }

}
