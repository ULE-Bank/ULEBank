package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClienteDomainTest {

	private ClienteDomain cliente;
	private List<DireccionDomain> direcciones;
	private List<String> idDocumentos;
	
	@Before
	public void setUp() throws Exception {
		direcciones = new ArrayList<>();
		direcciones.add(new DireccionDomain("calle", "localidad", "comunidad", "numero", new DNIHandler("X5526828C"), 24195));
		
		idDocumentos = new ArrayList<>();
		idDocumentos.add("id1");
		idDocumentos.add("id2");
		
		cliente = new ClienteDomain("Razvan", "Raducu", "rraduc00@estudiantes.unileon.es", "1994-12-05", "x5526828C", direcciones, "español");
	}

	@Test
	public void testGetName() {
		assertThat(cliente.getName(), is("Razvan"));
	}

	@Test
	public void testSetName() {
		cliente.setName("Razvan2");
		assertThat(cliente.getName(), is("Razvan2"));
	}

	@Test
	public void testGetLastname() {
		assertThat(cliente.getLastName(), is("Raducu"));
	}

	@Test
	public void testSetLastname() {
		cliente.setLastName("Raducu2");
		assertThat(cliente.getLastName(), is("Raducu2"));
	}

	@Test
	public void testGetEmail() {
		assertThat(cliente.getEmail(), is("rraduc00@estudiantes.unileon.es"));
	}

	@Test
	public void testSetEmail() {
		cliente.setEmail("r@s.unileon.es");
		assertThat(cliente.getEmail(), is("r@s.unileon.es"));
	}

	@Test
	public void testGetFechaNacimiento() {
		/*
		 * ATENCIÓN: Los meses en java se numeran en índice 0, es decir, de 0 - Enero a 11 - Diciembre
		 */
		Calendar fecha = new GregorianCalendar(1994, 11, 05);
		assertThat(cliente.getFechaNacimiento(), is(fecha.getTime()));
	}

	@Test
	public void testGetDni() {
		assertThat(cliente.getDni().toString(), is("X5526828C"));
	}

	@Test
	public void testSetDniString() throws DNIException {
		assertThat(cliente.getDni().toString(), is("X5526828C"));
		cliente.setDni("61380818M");
		assertThat(cliente.getDni().toString(), is("61380818M"));
	}

	@Test
	public void testSetDniHandler() throws DNIException {
		assertThat(cliente.getDni().toString(), is("X5526828C"));
		cliente.setDni(new DNIHandler("61380818M"));
		assertThat(cliente.getDni().toString(), is("61380818M"));

	}

	@Test
	public void testGetDirecciones() {
		assertThat(cliente.getDirecciones(), hasSize(1));
		assertThat(cliente.getDirecciones().get(0).getDni().toString(), is("X5526828C"));
	}

	@Test
	public void testAddDireccion() throws DNIException {
		assertThat(cliente.getDirecciones(), hasSize(1));
		cliente.addDireccion(new DireccionDomain("X5526828C", null, null, null, 0, null));
		assertThat(cliente.getDirecciones(), hasSize(2));
	}

	@Test
	public void testGetNacionalidad() {
		assertThat(cliente.getNacionalidad(), is("español"));
	}

	@Test
	public void testSetNacionalidad() {
		assertThat(cliente.getNacionalidad(), is("español"));
		cliente.setNacionalidad("espaniol");
		assertThat(cliente.getNacionalidad(), is("espaniol"));
	}

	@Test
	public void testGetFechaDeAlta() {
		Calendar fecha = new GregorianCalendar(1994, 12, 05);
		cliente.setFechaDeAlta(fecha.getTime());
		assertThat(cliente.getFechaDeAlta().getTime(), is(fecha.getTime().getTime()));
	}

}
