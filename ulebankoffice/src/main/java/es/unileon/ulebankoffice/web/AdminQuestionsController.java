package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Entity;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.domain.QuestionInfo;

@Controller
public class AdminQuestionsController {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value = "/adminoffersconsulting", method = RequestMethod.GET)
    public ModelAndView add(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        if (authenticator.isAuthenticated(req)) {
        	
        	if(!datastore.queryForExists("Admins", "Email", req.getUserPrincipal().getName()))
        		return new ModelAndView("redirect:/");
        	
        	List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        	
        	List<Entity> results = datastore.query("Question");
        	for (Entity result : results) {
        		String id = Long.toString(result.getKey().getId());
        		String title = (String) result.getProperty("titulo");
        		String state = (String) result.getProperty("state");
        		
        		list.add(new QuestionInfo(id, title, state));
        	}
        	
        	ModelAndView Model = new ModelAndView("admin-questions");
        	Model.addObject("lists", list);
        	
        	return Model;
        }
        else {                       
        	return new ModelAndView(authenticator.login(req));
        }
    }
}
