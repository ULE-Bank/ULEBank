package es.unileon.ulebankoffice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebankoffice.repositories.ClienteRepository;
import es.unileon.ulebankoffice.service.Cliente;
import es.unileon.ulebankoffice.service.Direccion;



/**
 * @author Razvan Raducu
 *
 */
@Controller
public class OfficeController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/*Método para guardar un nuevo documento. Se comprueba que los campos no sean nulos, vacíos o blancos*/
	@RequestMapping(value = "/o", method = RequestMethod.POST)
	public String saveDoc(@ModelAttribute("nuevoCliente") @Valid Cliente nuevoCliente, BindingResult clienteResult,
			@ModelAttribute("direccion") @Valid Direccion nuevaDireccion,
			BindingResult direccionResult, HttpServletRequest req, HttpServletResponse resp, ModelMap model) {
			
		System.out.println(nuevoCliente);
		System.out.println(nuevaDireccion);
//		model.addAttribute("mongoDocument", new MongoDBDocument());
		if(clienteResult.hasErrors() || direccionResult.hasErrors()){
			System.out.println(clienteResult.toString() + " \n-########## ");
			System.out.println(direccionResult.toString() + " \n-########## ");
				return "officeindex";
			}
		
//		repository.insert(mongoDocument);
		System.out.println("sin errores");
		return "officeindex";		
		
//		return "redirect:/o";
	}
	
	/*Método para mostrar todos los documentos. Con el foreach en el jsp puedo acceder a todos los
	 * campos del documento*/
	@RequestMapping(value = "/o", method = RequestMethod.GET)
	public String showMeAllDocs(ModelMap model, @ModelAttribute("nuevoCliente") Cliente nuevoCliente,
			@ModelAttribute("direccion") Direccion nuevaDireccion) {

		model.addAttribute("clients", clienteRepository.findAll());
		return "officeIndex";
	}
	
	
	
	/*Método para borrar un documento de la base de datos.*/
//	@RequestMapping(value = "/alldocs/delete", method = RequestMethod.GET)
//	public String deleteDoc(ModelMap model, @ModelAttribute("document") MongoDBDocument document){
//		repository.delete(document);
//		return "alldocs";
//	}
}
