package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import es.unileon.ulebankoffice.domain.Authenticator;
import es.unileon.ulebankoffice.domain.Datastore;
import es.unileon.ulebankoffice.domain.Question;
import es.unileon.ulebankoffice.service.NewQuestion;
import es.unileon.ulebankoffice.service.SolicitudFinancialAdvisor;

@Controller
@RequestMapping("/offersconsulting/newquery")
public class NewQuestionFormController {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
	@ModelAttribute("newQuestion")
	public SolicitudFinancialAdvisor getNewQuestion(){
		return new SolicitudFinancialAdvisor();
	}
	
	@PostMapping
    public String processAdd(@Valid @ModelAttribute("newQuestion")
    SolicitudFinancialAdvisor nuevaSolicitud, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res, Principal principal, ModelMap model) throws IOException {
		
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		
		if(bindingResult.hasErrors()){
			model.addAttribute("errorQueryDetails", "Por favor, ofrece detalles acerca de tu consulta.");
			logger.warn(principal.getName() + " ha intentado crear una nueva consulta y en el formulario ha habido errores. Devolviendo la vista de nuevo.");
			return "redirect:/offersconsulting/newquery";
		}
		
		if(!blobs.isEmpty()){
			List<BlobKey> blobKeys = blobs.get("myFile");
			BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
			BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(blobKeys.get(0));
			logger.info(principal.getName() + " ha creado una nueva consulta y ha adjuntado un documento."
					+ "\nEl documento es tipo: " + blobInfo.getContentType() + " con nombre: " +  blobInfo.getFilename() + " y tamaño " + blobInfo.getSize());
			
		}
		
		
		
		
//		System.out.println("La longitud es - >" +  blobs.get("myFile").size());
		
        List<BlobKey> blobKeys = blobs.get("myFile");
//        System.out.println("APARENTEMENTE ESOT RECOGE LOOL _>>>>>>>>>>>>>>>> " + blobKeys.toString());
        if (blobKeys == null || blobKeys.isEmpty()) {
        	System.out.println("E ENTRAU EN QUE ES VACIO CLARO");
            return "newquery";
        } else {
//        	 BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
        	System.out.println("wow1 -> " + blobKeys.get(0).toString());
        	System.out.println("wow2 -> " + blobKeys.get(0).getKeyString());
        	res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
        	System.out.println("La longitud es 2222 - >" +  blobKeys.size());
    		
    		Map<String, Object> myModel = new HashMap<String, Object>();
    		System.out.println("He recibido el post");
    		if (bindingResult.hasErrors())
            	return "newquery";
    		
//    		String[] propertiesValues = new String[12];
//    		propertiesValues[0] = req.getUserPrincipal().getName();
//    		propertiesValues[1] = newQuestion.getNombre();
//    		propertiesValues[2] = newQuestion.getApellidos();
//    		propertiesValues[3] = Integer.toString(newQuestion.getEdad());
//    		propertiesValues[4] = newQuestion.getClaseSocial();
//    		propertiesValues[5] = newQuestion.getEstadoCivil();
//    		propertiesValues[6] = newQuestion.getCargas();
//    		propertiesValues[7] = newQuestion.getTitulo();
//    		propertiesValues[8] = newQuestion.getComentarios();
//    		propertiesValues[9] = newQuestion.getUrl();
//    		propertiesValues[10] = "Activa";
//    		propertiesValues[11] = "Un experto en finanzas está estudiando tu caso.";
//    		
//    		new Question(propertiesValues, datastore).insertQuestion();

            return "queryok";
        }
        
        	
	}
	
	@GetMapping
    public String add(Model model, HttpServletRequest req, HttpServletResponse resp) {
        

            return "newquery";
      
		
    }
}
