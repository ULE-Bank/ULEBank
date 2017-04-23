package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class DNIHandlerTests {

	private DNIHandler dni;
	
	@Before
	public void setUpBefore() throws DNIException{
		dni = new DNIHandler("x5526828c");
	}
		
	@Test
	public void testDNIHandlerToUpperCase() {
		assertThat(dni.getId(), is("X5526828C"));
		assertThat(dni.getId(), is(not("X5526828c")));
		assertThat(dni.getId(), is(not("x5526828C")));
		assertThat(dni.getId(), is(not("x5526828c")));
	}
	
	@Test(expected = DNIException.class)
	public void testDNIHandlerInvalidDNI() throws DNIException {
		dni = new DNIHandler("X5526828D");
	}
	
	@Test(expected = DNIException.class)
	public void testDNIHandlerInvalidDNIAgain() throws DNIException {
		dni = new DNIHandler("Y1059137Z");
	}
	
	@Test
	public void testCompareTo() throws DNIException {
		assertThat(dni.compareTo(new DNIHandler("x5526828c")), is(true));
		assertThat(dni.compareTo(new DNIHandler("61380818M")), is(not(true)));
	}

	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.DNIHandler#toString()}.
	 */
	@Test
	public void testToString() {
		assertThat(dni.toString(), is("X5526828C"));
	}
}
