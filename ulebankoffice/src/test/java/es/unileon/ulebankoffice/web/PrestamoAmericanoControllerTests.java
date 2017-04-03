package es.unileon.ulebankoffice.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class PrestamoAmericanoControllerTests {

	@InjectMocks
    private PrestamoAmericanoFormController americanoController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(americanoController).build();
    }

    @Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/prestamo-metodo-americano.htm"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("prestamo-metodo-americano"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/prestamo-metodo-americano.htm")
				.param("C0", "100000")
	            .param("i", "5")
	            .param("k", "3")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("prestamo-metodo-americano"))
	            .andExpect(model().attributeExists("tabla"));
	}
	
	@Test
	public void testPostRequestCapInicialError() throws Exception {
		this.mockMvc.perform(post("/prestamo-metodo-americano.htm")
				.param("C0", "0")
	            .param("i", "5")
	            .param("k", "3")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("prestamo-metodo-americano"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestTipoInteresError() throws Exception {
		this.mockMvc.perform(post("/prestamo-metodo-americano.htm")
				.param("C0", "100000")
	            .param("i", "-5")
	            .param("k", "3")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("prestamo-metodo-americano"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestPeriodosError() throws Exception {
		this.mockMvc.perform(post("/prestamo-metodo-americano.htm")
				.param("C0", "100000")
	            .param("i", "5")
	            .param("k", "0")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("prestamo-metodo-americano"))
	            .andExpect(model().hasErrors());
	}
}
