package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebankoffice.service.ProductManager;

@Controller
public class InventoryController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private ProductManager productManager;

    @RequestMapping(value="/indexprueba.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = new Date().toString();
    	        
        /*Así es como se devuelve una vista con varias entradas, con un hashmap*/
        Map<String, Object> myModel = new HashMap<>();
        myModel.put("now", now);
        myModel.put("products", productManager.getProducts());
        
        logger.info("Returning your view with " + now +"\nProducts--> " + productManager.getProducts());
        System.out.println("Returning your view with " + now +"\nProducts--> " + productManager.getProducts());
     
        return new ModelAndView("indexprueba", "model", myModel);
    }
    
    public void setProductManager(ProductManager productManager){
    	this.productManager = productManager;
    }
}
