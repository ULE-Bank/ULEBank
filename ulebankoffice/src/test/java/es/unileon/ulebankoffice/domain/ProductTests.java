/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class ProductTests {
	
	 private Product product;

	    @Before
	    public void setUp() throws Exception {
	        product = new Product();
	    }
	
	
	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.Product#getDescription()}.
	 */
	@Test
	public void testGetAndSetDescription() {
		assertNull(product.getDescription());
		String desc = "Descripcion aleatoria";
		product.setDescription(desc);
		assertNotNull(product.getDescription());
		assertEquals(product.getDescription(), desc);
	}


	/**
	 * Test method for {@link es.unileon.ulebankoffice.domain.Product#getPrice()}.
	 */
	@Test
	public void testGetandSetPrice() {
		assertNull(product.getPrice());
		product.setPrice(15.00);
		assertEquals(product.getPrice(), 15.00, 0);
	}

}
