package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Entity;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.service.AdminQuestionInfo;

@Controller
public class QuestionsListController {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value = "/questions-list.htm", method = RequestMethod.GET)
    public ModelAndView add(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        if (authenticator.isAuthenticated(req)) {
                                     
        	ModelAndView Model = new ModelAndView("questions-list");
        	
        	List<AdminQuestionInfo> list = new ArrayList<AdminQuestionInfo>();
        	
        	List<Entity> results = datastore.query("AdminQuestion");
        	for (Entity result : results) {
        		String pregunta = (String) result.getProperty("pregunta");
        		String ponderacion = (String) result.getProperty("ponderacion");
        		
        		list.add(new AdminQuestionInfo(pregunta, ponderacion));
        	}
        	
        	Model.addObject("lists", list);
        	
        	return Model;
        }
        else               
        	return new ModelAndView(authenticator.login(req));
    }

}
