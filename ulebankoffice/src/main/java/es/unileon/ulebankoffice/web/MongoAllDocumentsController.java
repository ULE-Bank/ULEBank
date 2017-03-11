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

import es.unileon.ulebankoffice.repositories.MongoDBDocumentsRepository;
import es.unileon.ulebankoffice.service.MongoDBDocument;

/**
 * @author Razvan Raducu
 *
 */
@Controller
public class MongoAllDocumentsController {

	@Autowired
	private MongoDBDocumentsRepository repository;
	
	/*Método para guardar un nuevo documento. Se comprueba que los campos no sean nulos, vacíos o blancos*/
	@RequestMapping(value = "/alldocs", method = RequestMethod.POST)
	public String saveDoc(@ModelAttribute("mongoDocument") @Valid MongoDBDocument mongoDocument,
			BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp, ModelMap model) {
			
//		model.addAttribute("mongoDocument", new MongoDBDocument());
		if(bindingResult.hasErrors()){
				return "alldocs";
			}
		System.out.println(mongoDocument.getName());
		repository.insert(mongoDocument);
		return "redirect:/alldocs";
	}
	
	/*Método para mostrar todos los documentos. Con el foreach en el jsp puedo acceder a todos los
	 * campos del documento*/
	@RequestMapping(value = "/alldocs", method = RequestMethod.GET)
	public String showMeAllDocs(ModelMap model, @ModelAttribute("mongoDocument") MongoDBDocument mongoDocument) {

		model.addAttribute("documents", repository.findAll());
		return "alldocs";
	}
	
	
	
	/*Método para borrar un documento de la base de datos.*/
	@RequestMapping(value = "/alldocs/delete", method = RequestMethod.GET)
	public String deleteDoc(ModelMap model, @ModelAttribute("document") MongoDBDocument document){
		repository.delete(document);
		return "alldocs";
	}
}
