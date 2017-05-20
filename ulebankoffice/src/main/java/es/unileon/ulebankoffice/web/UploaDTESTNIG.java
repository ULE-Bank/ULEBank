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
import com.google.appengine.api.blobstore.UploadOptions;

@Controller
@RequestMapping("/unileon.es/uploadMulti")
public class UploaDTESTNIG {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@GetMapping
	public String showview(){
		return "uploadtesting";
	}
	
	@PostMapping
	public void multiFileUpload(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(blobstoreService.getUploads(req).isEmpty()){
			System.out.println("ESTO FUE VBACIO HEHEHEHE");
		} else {
		
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		
		System.out.println("La longitud es - >" +  blobs.get("myFile").size());
		
        List<BlobKey> blobKeys = blobs.get("myFile");

        if (blobKeys == null || blobKeys.isEmpty()) {
            res.sendRedirect("/");
        } else {
//        	 BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
        	System.out.println("wow1 -> " + blobKeys.get(0).toString());
        	System.out.println("wow2 -> " + blobKeys.get(0).getKeyString());
        	res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
        }
	 
	    
		}
	    System.out.println("He llegado");
	}

}
