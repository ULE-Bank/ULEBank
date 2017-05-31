package es.unileon.ulebankoffice.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import es.unileon.ulebankoffice.domain.ClienteDomain;
import es.unileon.ulebankoffice.domain.CuentaCorrienteDomain;
import es.unileon.ulebankoffice.domain.DireccionDomain;
import es.unileon.ulebankoffice.domain.PdfGenerator;
import es.unileon.ulebankoffice.repository.ClienteRepository;
import es.unileon.ulebankoffice.repository.CuentaCorrienteRepository;
import es.unileon.ulebankoffice.repository.DireccionRepository;

@Controller
@RequestMapping("/o/u")
public class PdfController {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private DireccionRepository direccionesRepo;

	@Autowired
	private CuentaCorrienteRepository cuentasCorrientesRepo;
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
	@GetMapping(value = "/contratoCuenta", params = { "accn" })
	public void inspeccionarContrato(HttpServletRequest req, HttpServletResponse response, Principal principal,
			@RequestParam("accn") String numeroDeCuenta) throws Exception {
		CuentaCorrienteDomain cuenta = cuentasCorrientesRepo.findByNumeroDeCuenta(numeroDeCuenta);
		if (cuenta == null) {
			throw new IllegalArgumentException("Numero de cuenta icnorrecto");
		}

		ClienteDomain cliente = clienteRepo.findByDni(cuenta.getDni().toString());
		if (cliente == null) {
			throw new IllegalArgumentException("Dni asociado a cuenta corriente incorrecto");
		}

		List<DireccionDomain> direccion = direccionesRepo.findByDni(cuenta.getDni().toString());
		if (direccion.isEmpty()) {
			throw new IllegalArgumentException("El cliente no tiene domicilio?");
		}

		Document document = new Document();
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " quiere inspeccionar el contrato de la cuenta " + cuenta.getNumeroDeCuenta());
		PdfWriter.getInstance(PdfGenerator.generatePdf(document, cliente, cuenta, direccion.get(0)),
				response.getOutputStream());
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " ha cargado el contrato de la cuenta " + cuenta.getNumeroDeCuenta());
	}
}
