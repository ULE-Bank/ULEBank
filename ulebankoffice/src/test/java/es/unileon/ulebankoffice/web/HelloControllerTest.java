package es.unileon.ulebankoffice.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.web.HelloController;

public class HelloControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {
		HelloController controller = new HelloController();
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("indexprueba", modelAndView.getViewName());
		String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
	}

}
