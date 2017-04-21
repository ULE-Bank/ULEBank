package es.unileon.ulebankoffice.domain;

import java.io.Serializable;
/**
 * 
 * @author Razvan Raducu
 * POJO aprendiendo Spring MVC
 *
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;
    private Double price;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }
}