package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolicitudDomainTest {

	private SolicitudDomain solicitud;
	private static List<String> idDocumentos;
	private static Date fechaApertura;
	private static Date fechaResolucion;
	
	@BeforeClass
	public static void beforeClass(){
		idDocumentos = new ArrayList<>();
		idDocumentos.add("documentId1");
		idDocumentos.add("documentId2");
		idDocumentos.add("documentId3");
		idDocumentos.add("documentId4");
		idDocumentos.add("documentId5");
		idDocumentos.add("documentId6");
		
		Calendar fecha = new GregorianCalendar(2017, 04, 23);
		fechaApertura = fecha.getTime(); 
		fecha = new GregorianCalendar(2017, 04, 24);
		fechaResolucion = fecha.getTime();
	}
	
	@Before
	public void setUp() throws Exception {
		solicitud = new SolicitudDomain("cerrada", fechaApertura, fechaResolucion, idDocumentos ,"productoID");
	}

	@Test
	public void testSolicitudDomain() {
		assertThat(solicitud.getEstado(), is("cerrada"));
		assertThat(solicitud.getProductId(), is("productoID"));
	}

	@Test
	public void testSetEstado() {
		solicitud.setEstado("resuelta");
		assertThat(solicitud.getEstado(), is("resuelta"));
	}

	@Test
	public void testGetFechaApertura() {
		assertThat(solicitud.getFechaApertura().equals(fechaApertura), is(true));
	}

	@Test
	public void testSetFechaApertura() {
		Calendar fecha = new GregorianCalendar(2017, 12, 05);
		solicitud.setFechaApertura(fecha.getTime());
		assertThat(solicitud.getFechaApertura().equals(fechaApertura), is(not(true)));
		
		assertThat(solicitud.getFechaApertura().equals(fecha), is(true));
	}

	@Test
	public void testGetFechaResolucion() {
		assertThat(solicitud.getFechaResolucion().equals(fechaResolucion), is(true));
	}

	@Test
	public void testSetFechaResolucion() {
		Calendar fecha = new GregorianCalendar(2017, 12, 05);
		solicitud.setFechaResolucion(fecha.getTime());
		assertThat(solicitud.getFechaResolucion().equals(fechaResolucion), is(not(true)));
		
		assertThat(solicitud.getFechaResolucion().equals(fecha), is(true));
	}

	@Test
	public void testSetProductId() {
		assertThat(solicitud.getProductId(), is("productID"));
		solicitud.setProductId("anotherProduct");
		assertThat(solicitud.getProductId(), is("anotherProduct"));
	}

}
