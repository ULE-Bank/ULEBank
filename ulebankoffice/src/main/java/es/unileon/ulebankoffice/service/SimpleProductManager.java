/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.List;

import es.unileon.ulebankoffice.domain.Product;

/**
 * @author Razvan Raducu Implementacion de la interfaz ProductManager tutorial
 *         Spring MVC
 */
public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	@Override
	public void increasePrice(int percentage) {
		if (products != null) {
			for (Product product : products) {
				/*Es necesario usar dooubleValue porque se usa la clase Double en product. Es necesario usar .00 porque se trabaja con double*/
				double precioIncrementado = product.getPrice().doubleValue() + (product.getPrice().doubleValue() * (percentage / 100.00));
				product.setPrice(precioIncrementado);
			}
		}

	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
