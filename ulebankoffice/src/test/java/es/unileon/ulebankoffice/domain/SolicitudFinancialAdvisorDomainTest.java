package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
	public void testEnlaceOferta() {
		assertNull(solicitud.getEnlaceOferta());
		solicitud.setTextoOferta("texto");
		assertThat(solicitud.getTextoOferta(), is("texto"));
	}

	@Test
	public void testRutaOferta() {
		assertNull(solicitud.getRutaOferta());
		solicitud.setRutaOferta("ruta");
		assertThat(solicitud.getRutaOferta(), is("ruta"));
	}

	@Test
	public void testGetIdSolicitud() {
		assertNull(solicitud.getIdSolicitud());
	}

}
