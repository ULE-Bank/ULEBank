package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@Controller
@RequestMapping("/offersconsulting/serve")
public class SHOWBLOBSTORETESTING {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		
	@GetMapping
	public void multiFileUpload(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		 BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
         blobstoreService.serve(blobKey, res);
	}

}
