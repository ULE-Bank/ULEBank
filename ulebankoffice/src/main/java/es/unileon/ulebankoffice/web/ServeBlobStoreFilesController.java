package es.unileon.ulebankoffice.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

/**
 * Clase encargada de controlar todas las peticiones que se hagan para obtener
 * archivos desde la blobstore.
 * 
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping("/offersconsulting/serve")
public class ServeBlobStoreFilesController {

	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	/**
	 * Método encargado de obtener el parámetro blob-key e insertar la vista del
	 * archivo en la respuesta que recibirá el cliente, o su navegador en este
	 * caso.
	 * 
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@GetMapping
	public void serveFile(HttpServletRequest req, HttpServletResponse res) throws IOException {

		BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
		blobstoreService.serve(blobKey, res);
	}

}
