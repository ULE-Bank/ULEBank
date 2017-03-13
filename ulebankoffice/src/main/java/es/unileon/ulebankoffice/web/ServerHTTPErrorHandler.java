/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase controlador para manejar los posibles errores HTTP que se puedan
 * producir en la aplicación y mostrar al usuario una página personalizada
 * 
 * @author Razvan Raducu
 * @see <a href="http://royal.pingdom.com/2009/05/06/the-5-most-common-http-errors-according-to-google/" target="_top">Errores HTTP comunes </a>
 */
@Controller
public class ServerHTTPErrorHandler {

//	@RequestMapping(value = "/e/{errorCode}")
//	public String errorPage(@PathVariable("errorCode") String errorCode){
//		System.out.println("He llegado hasta el mapeo del error");
//		switch(errorCode){
//		case "404":
//			return "HttpError404";
//		default:
//			return "index";
//		}
//	}
	
	@RequestMapping(value="/e/404")
	public String error404(){
		return "HttpError404";
	}
}
