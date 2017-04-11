package es.unileon.ulebankoffice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class ProductIDHandlerTests {
	
	private ProductIDHandler productId;
	
	@Before
	public void beforeEachMethod(){
		productId = new ProductIDHandler("id1");
	}

	@Test
	public void testGetId() {
		assertThat(productId.getId(), is("id1"));
	}

	@Test
	public void testSetId() {
		productId.setId("id2");
		assertThat(productId.getId(), is("id2"));
	}

	@Test
	public void testToString() {
		assertThat(productId.toString(), is("id1"));
	}

	@Test
	public void testCompareTo() {
		assertThat(productId.compareTo(new ProductIDHandler("id3")), is(not(true)));
		assertThat(productId.compareTo(new ProductIDHandler("id1")), is(true));
	}

}
