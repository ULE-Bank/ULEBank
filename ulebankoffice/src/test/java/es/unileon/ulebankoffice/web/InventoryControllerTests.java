package es.unileon.ulebankoffice.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.service.SimpleProductManager;

public class InventoryControllerTests {

	@Test
	public void testHandleRequestView() throws Exception {
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("indexprueba", modelAndView.getViewName());
		Map<String, Object> objectsMap = (Map<String, Object>) modelAndView.getModel().get("model");
		String nowValue = (String) objectsMap.get("now");
        assertNotNull(nowValue);
	}

}
