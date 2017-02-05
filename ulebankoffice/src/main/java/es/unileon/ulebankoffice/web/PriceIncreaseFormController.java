package es.unileon.ulebankoffice.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @author Razvan Raducu
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebankoffice.service.IncrementoPrecio;
import es.unileon.ulebankoffice.service.ProductManager;


@Controller
@RequestMapping(value="/incrementarPrecio")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid IncrementoPrecio incrementoDePrecio, BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }
		
        int increase = incrementoDePrecio.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");
        System.out.println("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        return "redirect:/inicio";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected IncrementoPrecio formBackingObject(HttpServletRequest request) throws ServletException {
        IncrementoPrecio incrementoDePrecio = new IncrementoPrecio();
        incrementoDePrecio.setPercentage(15);
        return incrementoDePrecio;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}