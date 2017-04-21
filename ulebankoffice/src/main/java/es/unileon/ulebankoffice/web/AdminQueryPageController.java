package es.unileon.ulebankoffice.web;

import java.io.IOException;
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

import com.google.appengine.api.datastore.Entity;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.domain.Question;
import es.unileon.ulebankoffice.service.AdminAnswer;

@Controller
public class AdminQueryPageController {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value = "/adminquerypage", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("adminAnswer")
    		AdminAnswer adminAnswer, BindingResult bindingResult) {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		if (bindingResult.hasErrors())
        	return new ModelAndView("adminquerypage", "model", myModel);
		
		String answer = adminAnswer.getAnswer();
		String id = adminAnswer.getIdConsulta();
		String userMail = adminAnswer.getEmail();
		
		new Question(id, datastore).reply(answer, userMail);

        return new ModelAndView("redirect:/answerok", "model", myModel);	
	}
	
	@RequestMapping(value = "/adminquerypage", method = RequestMethod.GET)
    public ModelAndView add(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		model.addAttribute("adminAnswer", new AdminAnswer());
        
        if (authenticator.isAuthenticated(req)) {
        	
        	Map<String, Object> myModel = new HashMap<String, Object>();
        	
        	String nombre, apellidos, titulo, url, comentarios, state, email;
        	
        	String id = req.getParameter("id");
        	Entity result = Datastore.getDatastore().query("Question", id);
        	
    		nombre = (String) result.getProperty("nombre");
    		apellidos = (String) result.getProperty("apellidos");
    		email = (String) result.getProperty("email");
    		titulo = (String) result.getProperty("titulo");
    		url = (String) result.getProperty("url");
    		comentarios = (String) result.getProperty("comentarios");
    		state = (String) result.getProperty("state");
        	
        	myModel.put("nombre", nombre);
        	myModel.put("apellidos", apellidos);
        	myModel.put("titulo", titulo);
        	myModel.put("url", url);
        	myModel.put("comentarios", comentarios);
        	myModel.put("state", state);
        	myModel.put("email", email);
        	myModel.put("id_consulta", id);
        	
        	return new ModelAndView("adminquerypage", "model", myModel);	
        	
        }
        else                                     
        	return new ModelAndView(authenticator.login(req));
		
    }
	
}
