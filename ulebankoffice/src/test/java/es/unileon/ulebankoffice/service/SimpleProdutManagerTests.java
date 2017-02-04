package es.unileon.ulebankoffice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebankoffice.domain.Product;

public class SimpleProdutManagerTests {

	private SimpleProductManager productManager;
	private List<Product> products;

	@Before
	public void setUp() throws Exception {
		productManager = new SimpleProductManager();
		products = new ArrayList<>();

		Product product = new Product();
		product.setDescription("Silla");
		product.setPrice(20.50);
		products.add(product);

		product = new Product();
		product.setDescription("Mesa");
		product.setPrice(100.47);
		products.add(product);

		productManager.setProducts(products);
	}

	@Test
	public void testIncreasePriceWithNullListOfProducts() {
		try {
			productManager = new SimpleProductManager();
			productManager.increasePrice(10);
		} catch (NullPointerException ex) {
			fail("Products list is null.");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts() {
		try {
			productManager = new SimpleProductManager();
			productManager.setProducts(new ArrayList<Product>());
			productManager.increasePrice(10);
		} catch (Exception ex) {
			fail("Products list is empty.");
		}
	}

	@Test
	public void testIncreasePriceWithPositivePercentage() {
		productManager.increasePrice(10);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 110.517;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);
	}

	@Test
	public void testGetProductsWithNoProducts() {
		productManager = new SimpleProductManager();
		assertNull(productManager.getProducts());
	}

	@Test
	public void testGetProducts() {
		assertNotNull(productManager.getProducts());
		assertEquals(2, productManager.getProducts().size());

		assertEquals("Silla", productManager.getProducts().get(0).getDescription());
		assertEquals("Mesa", productManager.getProducts().get(1).getDescription());

		assertEquals(20.50, productManager.getProducts().get(0).getPrice(), 0);
		assertEquals(100.47, productManager.getProducts().get(1).getPrice(), 0);
	}

}
