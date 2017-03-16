package es.unileon.ulebankoffice.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.repositories.ClienteRepository;
import es.unileon.ulebankoffice.service.Cliente;



/**
 * @author Razvan Raducu
 *
 */
@Controller
public class OfficeIndexController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
//	@InitBinder
//	public void bindingPreparation(WebDataBinder binder) {
//
//	  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, false);
//	  binder.registerCustomEditor(Date.class, orderDateEditor);
//	}
	
	/*Método para guardar un nuevo documento. Se comprueba que los campos no sean nulos, vacíos o blancos*/
	@RequestMapping(value = "/o", method = RequestMethod.POST)
	public String saveDoc(@ModelAttribute("nuevoCliente") @Valid Cliente nuevoCliente, BindingResult clienteResult, HttpServletRequest req, HttpServletResponse resp, ModelMap model) {
			
		System.out.println("FECHA ->>>>[" + nuevoCliente.getFechaNacimiento());
		
		/* Lo convierto a lowerCase puesto que es un ensureIndex unique:true y así se soluciona el problema mayúsculas-minúsculas*/
		nuevoCliente.setDni(nuevoCliente.getDni().toLowerCase());
		
//		model.addAttribute("mongoDocument", new MongoDBDocument());
		if(clienteResult.hasErrors()){
			System.out.println(clienteResult.toString() + " \n-########## ");
			
				return "officeindex";
			}
		try {
			clienteRepository.insert(nuevoCliente);
			System.out.println("Se ha registrado cliente sin errores");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println("HA HABIDO ERRORES");
			model.addAttribute("error", "HA HABIDO ERRORES");
			return "officeindex";
		}
		
//		repository.insert(mongoDocument);
		
		return "redirect:/o";		
		
//		return "redirect:/o";
	}
	
	/*Método para mostrar todos los documentos. Con el foreach en el jsp puedo acceder a todos los
	 * campos del documento*/
	@RequestMapping(value = "/o", method = RequestMethod.GET)
	public String showMeAllDocs(ModelMap model, @ModelAttribute("nuevoCliente") Cliente nuevoCliente, HttpServletRequest req) {
		System.out.println("Petición get " + req.getRemoteHost() + " || " + req.getRemoteAddr());
		model.addAttribute("clients",  clienteRepository.findAll());
		return "officeindex";
	}
	
	/*Método para mostrar buscar un cliente en concreto por dni*/
	@RequestMapping(value = "/o", method = RequestMethod.GET, params="uin")
	public String showMeAclient(ModelMap model, @RequestParam("uin") String dni, HttpServletRequest req, @ModelAttribute("nuevoCliente") Cliente nuevoCliente) {
		/*Es mucho más sensato capturar el idioma que el país ya que puede ser es_ES o es_EN. El idioma es el mismo
		 * pero el país no. De cara al futuro puede suponer problemas si se captura sólo el país.*/
		String locale = req.getLocale().getLanguage();
		String noClientFoundError = "";
		if(locale.equals(new Locale("en").getLanguage())){
			noClientFoundError = "No client found with such DNI/NIE";
		} else if(locale.equals(new Locale("es").getLanguage())){
			noClientFoundError = "No hay ningún cliente con ese DNI/NIE";
		}
		
		/*Lo convierto a lowercase puesto que al guardarlo lo hago como lowercase*/
		List<Cliente> clienteFound = clienteRepository.findByDni(dni.toLowerCase());
		System.out.println(clienteFound);
		if(clienteFound.isEmpty()){
			model.addAttribute("noClientFoundError", noClientFoundError);
			model.addAttribute("clients",  clienteRepository.findAll());
		}else{
			model.addAttribute("clients",  clienteFound);
		}
		
	
		return "officeindex";
	}
	
	
	/*Método para borrar un documento de la base de datos.*/
//	@RequestMapping(value = "/alldocs/delete", method = RequestMethod.GET)
//	public String deleteDoc(ModelMap model, @ModelAttribute("document") MongoDBDocument document){
//		repository.delete(document);
//		return "alldocs";
//	}
}
