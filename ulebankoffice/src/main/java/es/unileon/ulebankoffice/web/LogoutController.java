package es.unileon.ulebankoffice.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.domain.Authenticator;

@Controller
public class LogoutController {
	
	@Autowired
	private Authenticator authenticator;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView add(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		return new ModelAndView(authenticator.logout());		
	}
}
