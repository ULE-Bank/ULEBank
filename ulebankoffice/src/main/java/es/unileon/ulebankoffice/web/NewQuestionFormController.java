package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import es.unileon.ulebankoffice.domain.SolicitudFinancialAdvisorDomain;
import es.unileon.ulebankoffice.repository.SolicitudesFinancialAdvisorRepository;
import es.unileon.ulebankoffice.service.SolicitudFinancialAdvisor;

@Controller
@RequestMapping("/offersconsulting/newquery")
public class NewQuestionFormController {

	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String GOOGLEENCODING = "ISO-8859-1";
	private static final String UTF8 = "UTF-8";
	private static final int QUINCE_MEBIBYTES = 15728640;

	@Autowired
	private SolicitudesFinancialAdvisorRepository repo;

	@ModelAttribute("newQuestion")
	public SolicitudFinancialAdvisor getNewQuestion() {
		return new SolicitudFinancialAdvisor();
	}

	@PostMapping
	public String processAdd(@Valid @ModelAttribute("newQuestion") SolicitudFinancialAdvisor nuevaSolicitud,
			BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res, Principal principal,
			ModelMap model) throws IOException {

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		String blobStoreFileKey = null;
		
		

		if (bindingResult.hasErrors()) {
			model.addAttribute("errorQueryDetails", "Por favor, ofrece detalles acerca de tu consulta.");
			logger.warn(principal.getName()
					+ " ha intentado crear una nueva consulta y en el formulario ha habido errores. Devolviendo la vista de nuevo.");
			return "newquery";
		}
		logger.info(principal.getName() + " ha creado una nueva consulta");
		// TODO Comprobaciones de formato, contenido y tamaño serverside
		if (!blobs.isEmpty()) {
			logger.info("La consulta contenía un archivo adjunto. Guardado en la blobstore. Ahora se van a pasar los filtros");
			
			List<BlobKey> blobKeys = blobs.get("myFile");
			BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
			BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(blobKeys.get(0));
			logger.info(principal.getName() + " ha adjuntado un documento."
					+ "El documento es tipo: " + blobInfo.getContentType() + " con nombre: " + blobInfo.getFilename()
					+ " y tamaño " + blobInfo.getSize());
			
			logger.info("Comprobando el contenido del archivo");
			if(!"application/pdf".equals(blobInfo.getContentType())){
				logger.warn("Se ha tratado de adjuntar un archivo con contenido distinto a PDF. Borrando archivo.");
				blobstoreService.delete(blobKeys.get(0));
				model.addAttribute("fileError", "Must be PDF!");
				return "redirect:/o/offersconsulting/newquery";
			}
			logger.info("Contenido... OK");
			
			logger.info("Comprobando el tamaño del archivo");
			if(blobInfo.getSize() > QUINCE_MEBIBYTES){
				logger.warn("Se ha tratado de adjuntar un archivo con tamaño superior a 15 MiB. Borrando archivo.");
				blobstoreService.delete(blobKeys.get(0));
				model.addAttribute("fileError", "15MB Max!");
				return "redirect:/o/offersconsulting/newquery";
			}
			logger.info("Tamaño del archivo... OK");
			
			logger.info("Comprobando contenido del archivo. Numeros mágicos.");
			BlobstoreInputStream input = new BlobstoreInputStream(blobKeys.get(0));
			byte[] bytes = new byte[4];
			/* Los primeros 4 bytes del pdf son -> 0x25 0x50 0x44 0x46 y por algún motivo Java los traduce a decimal. Creo un array de bytes con esos valores y simplemente los comparo.*/ 
			byte[] bytesDePdfEnDecimal = {37, 80, 68, 70};
			input.read(bytes, 0, 4);
			logger.debug("Los 4 primeros bytes, en decimal, del archivo son: " + Arrays.toString(bytes));
			/* Se deben comparar los toString ya que las comparaciones entre arrays sin ninguna relación devuelven siempre false */
			if(!Arrays.toString(bytes).equals(Arrays.toString(bytesDePdfEnDecimal))){
				logger.warn("Se ha tratado de adjuntar un archivo cuyos 4 primeros bytes, números mágicos, no coinciden con los de PDF. Borrando archivo.");
				blobstoreService.delete(blobKeys.get(0));
				model.addAttribute("fileError", "PDF Content!");
				return "redirect:/o/offersconsulting/newquery";
			}
			logger.info("Contenido del archivo, numero mágicos,... OK");
			
			blobStoreFileKey = blobKeys.get(0).getKeyString();
		}
		
		String texto = new String(nuevaSolicitud.getTextoOferta().getBytes(GOOGLEENCODING), UTF8);
		String asunto =  new String(nuevaSolicitud.getAsuntoOferta().getBytes(GOOGLEENCODING), UTF8);
		String url =  new String(nuevaSolicitud.getUrlOferta().getBytes(GOOGLEENCODING), UTF8);
		SolicitudFinancialAdvisorDomain solicitud = new SolicitudFinancialAdvisorDomain();
		solicitud.setEmail(principal.getName());
		solicitud.setEstado("Pendiente");
		solicitud.setFileBlobKey(blobStoreFileKey);
		solicitud.setUrlOferta(url);
		solicitud.setTextoOferta(texto);
		solicitud.setAsuntoOferta(asunto);
		repo.save(solicitud);
		logger.info("Se ha guardado en la base de datos (MongoDB) la solicitud de " + principal.getName() + " con id: " + solicitud.getId() + " y asunto : " + asunto);
		return "question-verification";
	}

	@GetMapping
	public String add(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return "newquery";

	}
}
