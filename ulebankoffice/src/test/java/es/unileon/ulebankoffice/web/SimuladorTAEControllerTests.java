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

public class SimuladorTAEControllerTests {

	@InjectMocks
    private SimuladorTAEFormController taeController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(taeController).build();
    }

	@Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/simulador-calculos-tae.htm"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("simulador-calculos-tae"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/simulador-calculos-tae.htm")
				.param("i", "2.59")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("simulador-calculos-tae"))
	            .andExpect(model().attributeExists("tabla"));
	}
	
	@Test
	public void testPostRequestTipoInteresError() throws Exception {
		this.mockMvc.perform(post("/simulador-calculos-tae.htm")
				.param("i", "-1")
	            .param("p", "1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("simulador-calculos-tae"))
	            .andExpect(model().hasErrors());
	}

}
