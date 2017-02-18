package es.unileon.ulebankoffice.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.domain.Question;
import es.unileon.ulebankoffice.service.NewQuestion;

@Controller
public class NewQuestionFormController {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value = "/new-question.htm", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("newQuestion")
    		NewQuestion newQuestion, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp) {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		if (bindingResult.hasErrors())
        	return new ModelAndView("new-question", "model", myModel);
		
		String[] propertiesValues = new String[12];
		propertiesValues[0] = req.getUserPrincipal().getName();
		propertiesValues[1] = newQuestion.getNombre();
		propertiesValues[2] = newQuestion.getApellidos();
		propertiesValues[3] = Integer.toString(newQuestion.getEdad());
		propertiesValues[4] = newQuestion.getClaseSocial();
		propertiesValues[5] = newQuestion.getEstadoCivil();
		propertiesValues[6] = newQuestion.getCargas();
		propertiesValues[7] = newQuestion.getTitulo();
		propertiesValues[8] = newQuestion.getComentarios();
		propertiesValues[9] = newQuestion.getUrl();
		propertiesValues[10] = "Activa";
		propertiesValues[11] = "Un experto en finanzas está estudiando tu caso.";
		
		new Question(propertiesValues, datastore).insertQuestion();

        return new ModelAndView("redirect:/resources/question-verification.html", "model", myModel);	
	}
	
	@RequestMapping(value = "/new-question.htm", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest req, HttpServletResponse resp) {
        
        if (authenticator.isAuthenticated(req)) {
        	model.addAttribute("newQuestion", new NewQuestion());
            return "new-question";
        }
        else    
        	return authenticator.login(req);
		
    }
}
