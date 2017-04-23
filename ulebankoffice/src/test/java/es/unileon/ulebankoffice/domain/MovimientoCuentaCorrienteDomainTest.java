package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;

public class MovimientoCuentaCorrienteDomainTest {
	
	@Autowired
    private Validator validator;
	
	private MovimientoCuentaCorrienteDomain movimiento;

	@Before
	public void setUp() throws Exception {
		Calendar fecha = new GregorianCalendar(2017, 04, 23);
		movimiento = new MovimientoCuentaCorrienteDomain(150.00, "Ingreso", "UNILEON", "Razvan", fecha.getTime());
	}

	@Test
	public void testMovimientoCuentaCorrienteDomain() {
		assertThat(movimiento.getCantidad(), is(150d));
	}

	@Test
	public void testGetConcepto() {
		assertThat(movimiento.getConcepto(), is("Ingreso"));
	}

	@Test
	public void testTemporalidad() {
		// No es null porque es de tipo int, primitivo. Se inicializa por
		// defecto a 0.
		assertThat(movimiento.getTemporalidad(), is(0));
		movimiento.setTemporalidad(5);
		assertThat(movimiento.getTemporalidad(), is(5));
	}

	@Test
	public void testGetEmisor() {
		assertThat(movimiento.getEmisor(), is("UNILEON"));
	}

	@Test
	public void testGetDate() {
		assertThat(movimiento.getDate().getTime(), is(new GregorianCalendar(2017, 04, 23).getTime().getTime()));
	}

	@Test
	public void testGetReceptor() {
		assertThat(movimiento.getReceptor(), is("Razvan"));
	}

}
