package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SolicitudFinancialAdvisorDomainTest {
	
	private SolicitudFinancialAdvisorDomain solicitud;
	
	@Before
	public void setUp() throws Exception {
		solicitud = new SolicitudFinancialAdvisorDomain();
	}

	@Test
	public void testTextoOferta() {
		assertNull(solicitud.getTextoOferta());
		solicitud.setTextoOferta("texto");
		assertThat(solicitud.getTextoOferta(), is("texto"));
	}


	@Test
	public void testRutaOferta() {
		assertNull(solicitud.getUrlOferta());
		solicitud.setUrlOferta("ruta");
		assertThat(solicitud.getUrlOferta(), is("ruta"));
	}
	
	@Test
	public void testEstado(){
		assertNull(solicitud.getEstado());
		solicitud.setEstado("abierta");
		assertThat(solicitud.getEstado(), is("abierta"));
	}


}
