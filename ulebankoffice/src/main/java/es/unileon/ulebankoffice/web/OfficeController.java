package es.unileon.ulebankoffice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebankoffice.repositories.ClienteRepository;



/**
 * @author Razvan Raducu
 *
 */
@Controller
public class OfficeController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/*Método para guardar un nuevo documento. Se comprueba que los campos no sean nulos, vacíos o blancos*/
//	@RequestMapping(value = "/o", method = RequestMethod.POST)
//	public String saveDoc(@ModelAttribute("mongoDocument") @Valid MongoDBDocument mongoDocument,
//			BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp, ModelMap model) {
//			
////		model.addAttribute("mongoDocument", new MongoDBDocument());
//		if(bindingResult.hasErrors()){
//				return "alldocs";
//			}
//		System.out.println(mongoDocument.getName());
//		repository.insert(mongoDocument);
//		return "redirect:/alldocs";
//	}
	
	/*Método para mostrar todos los documentos. Con el foreach en el jsp puedo acceder a todos los
	 * campos del documento*/
	@RequestMapping(value = "/o", method = RequestMethod.GET)
	public String showMeAllDocs(ModelMap model ) {

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
