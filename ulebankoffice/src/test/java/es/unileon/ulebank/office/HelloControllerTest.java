package es.unileon.ulebank.office;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

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
