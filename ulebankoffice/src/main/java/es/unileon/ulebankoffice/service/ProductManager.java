package es.unileon.ulebankoffice.service;

/**
 * @author Razvan Raducu
 * Interfaz tutorial Spring MVC
 */
import java.io.Serializable;
import java.util.List;

import es.unileon.ulebankoffice.domain.Product;

public interface ProductManager extends Serializable {

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}