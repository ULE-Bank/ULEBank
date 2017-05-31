/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping("/testingpdf2")
public class TESTINGPDFCREATIONCONTROLLER {
	
	@GetMapping
	public void showPdf(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("application/pdf");

		  try {
		   Document document = new Document();
		   PdfWriter.getInstance(document, res.getOutputStream());
		   document.open();
		   document.add(new Paragraph("This is a paragraph"));
		   document.close();
		  } catch (DocumentException e) {
		   e.printStackTrace();
		  }
		 
		
	}

}
