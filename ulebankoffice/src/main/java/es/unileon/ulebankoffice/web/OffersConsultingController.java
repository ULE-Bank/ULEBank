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
public class OffersConsultingController {

	@Autowired
	private Authenticator authenticator;

	@Autowired
	private Datastore datastore;
	
	@RequestMapping(value= "/consuLogin", method = RequestMethod.GET) 
	public String getLogin(){
		return "offersConsultingLogin";
	}

	@RequestMapping(value = "/offersconsulting", method = RequestMethod.GET)
	public ModelAndView add(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {

		

			ModelAndView Model = new ModelAndView("offersconsulting");

			List<QuestionInfo> list = new ArrayList<QuestionInfo>();

			List<Entity> results = datastore.query("Question", "email", "email");
			for (Entity result : results) {
				String id = Long.toString(result.getKey().getId());
				String title = (String) result.getProperty("titulo");
				String state = (String) result.getProperty("state");

				list.add(new QuestionInfo(id, title, state));
			}

			Model.addObject("nombre", req.getUserPrincipal().getName());
			Model.addObject("lists", list);

			return Model;
		}

		

	
}
