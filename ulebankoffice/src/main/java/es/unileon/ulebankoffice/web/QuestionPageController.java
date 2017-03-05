package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.domain.Question;

@Controller
public class QuestionPageController {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value = "/querypage", method = RequestMethod.GET)
    public ModelAndView add(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        if (authenticator.isAuthenticated(req)) {
        	
        	Map<String, Object> myModel = new HashMap<String, Object>();
        	
        	String id = req.getParameter("id");

        	String[] question = new Question(id, datastore).getQuestion();
        	
        	myModel.put("id_query", id);
        	myModel.put("nombre", question[0]);
        	myModel.put("apellidos", question[1]);
        	myModel.put("titulo", question[2]);
        	myModel.put("url", question[3]);
        	myModel.put("comentarios", question[4]);
        	myModel.put("state", question[5]);
        	myModel.put("respuesta", question[6]);
        	
        	return new ModelAndView("querypage", "model", myModel);	
        	
        }
        else                                     
        	return new ModelAndView(authenticator.login(req));
		
    }

}
