/**
 * 
 */
package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class MovimientosCreditosTest {

	private static Validator validator;
	private MovimientosCreditos movimiento;
	private Set<ConstraintViolation<MovimientosCreditos>> constraintViolations;
	
	@BeforeClass
	   public static void setUpClass() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }
	
	@Before
	public void setUp() throws Exception {
		movimiento = new MovimientosCreditos();
		movimiento.setDescripcion("Movimiento test");
		movimiento.setFecha("1994-12-05");
		movimiento.setImporte(150000d);
		movimiento.setOperacion("I");
	}


	@Test
	public void testGetDescripcionMovimiento() {
		assertThat(movimiento.getDescripcion(), is("Movimiento test"));
	}

	@Test
	public void testGetImporteMovimiento() {
		assertThat(movimiento.getImporte(), is(150000.0));
	}

	@Test
	public void testGetFechaMovimiento() {
		assertThat(movimiento.getFecha(), is("1994-12-05"));
	}

	@Test
	public void testGetOperacion() {
		assertThat(movimiento.getOperacion(), is("I"));
	}
	
	@Test
	public void testAnnotationDescription(){
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(0));
		movimiento.setDescripcion("");
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("descripcionMovimiento"));
	}
	
	@Test
	public void testAnnotationImporte(){
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(0));
		movimiento.setImporte(-150d);
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("importeMovimiento"));
	}
	
	@Test
	public void testAnnotatioFechan(){
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(0));
		movimiento.setFecha("");
		constraintViolations = validator.validate(movimiento);
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("fechaMovimiento"));
	}
	
}
