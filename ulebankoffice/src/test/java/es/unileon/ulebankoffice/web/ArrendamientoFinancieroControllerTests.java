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

public class ArrendamientoFinancieroControllerTests {
	
	@InjectMocks
    private ArrendamientoFinancieroFormController arrendamientoFinancieroController;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(arrendamientoFinancieroController).build();
    }

    @Test
	public void testGetRequest() throws Exception {
		this.mockMvc.perform(get("/arrendamiento-financiero.htm"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("arrendamiento-financiero"));
	}
	
	@Test
	public void testPostRequestWithoutErrors() throws Exception {
		this.mockMvc.perform(post("/arrendamiento-financiero.htm")
				.param("valorBien", "12000")
	            .param("duracionContrato", "5")
	            .param("fraccionamientoPagoCuota", "3")
	            .param("tipoInteres", "2.50"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("arrendamiento-financiero"))
	            .andExpect(model().attributeExists("tabla"));
	}
	
	@Test
	public void testPostRequestValorBienError() throws Exception {
		this.mockMvc.perform(post("/arrendamiento-financiero.htm")
				.param("valorBien", "0")
	            .param("duracionContrato", "5")
	            .param("fraccionamientoPagoCuota", "3")
	            .param("tipoInteres", "2.50"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("arrendamiento-financiero"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestDuracionContratoError() throws Exception {
		this.mockMvc.perform(post("/arrendamiento-financiero.htm")
				.param("valorBien", "12000")
	            .param("duracionContrato", "0")
	            .param("fraccionamientoPagoCuota", "3")
	            .param("tipoInteres", "2.50"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("arrendamiento-financiero"))
	            .andExpect(model().hasErrors());
	}
	
	@Test
	public void testPostRequestTipoInteresError() throws Exception {
		this.mockMvc.perform(post("/arrendamiento-financiero.htm")
				.param("valorBien", "12000")
	            .param("duracionContrato", "5")
	            .param("fraccionamientoPagoCuota", "3")
	            .param("tipoInteres", "-1"))
	            .andExpect(status().isOk())
	            .andExpect(forwardedUrl("arrendamiento-financiero"))
	            .andExpect(model().hasErrors());
	}
}
