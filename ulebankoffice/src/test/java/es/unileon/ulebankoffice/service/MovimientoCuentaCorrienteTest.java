package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MovimientoCuentaCorrienteTest {
	
	private static Validator validator;
	private MovimientoCuentaCorriente movimiento;
	private Set<ConstraintViolation<MovimientoCuentaCorriente>> constraintViolations;

	@BeforeClass
	   public static void setUp() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }
	
	@Before
	public void setUpBeforeEach(){
		movimiento = new MovimientoCuentaCorriente();
	}

	@Test
	public void testCantidad() {
		assertNull(movimiento.getCantidad());
		movimiento.setCantidad(150d);
		assertThat(movimiento.getCantidad(), is(150d));
	}

	@Test
	public void testConcepto() {
		assertNull(movimiento.getConcepto());
		movimiento.setConcepto("concepto");
		assertThat(movimiento.getConcepto(), is("concepto"));
	}

	@Test
	public void testEmisor() {
		assertNull(movimiento.getEmisor());
		movimiento.setEmisor("Emisor");
		assertThat(movimiento.getEmisor(), is("Emisor"));
	}

	@Test
	public void testDate() {
		assertNull(movimiento.getDate());
		movimiento.setDate("1994-12-05");
		assertThat(movimiento.getDate(), is("1994-12-05"));	
	}

	@Test
	public void testReceptor() {
		assertNull(movimiento.getReceptor());
		movimiento.setReceptor("Receptor");
		assertThat(movimiento.getReceptor(), is("Receptor"));
	}
	
	@Test
	public void testCanitdadAnnotation(){
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(4));
		movimiento.setConcepto("c");
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(3));
		movimiento.setDate("fecha");
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(2));
		movimiento.setReceptor("recpetor");
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(1));
		movimiento.setEmisor("emisor");
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(0));
		movimiento.setCantidad(-5d);
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("cantidad"));
	}
}
