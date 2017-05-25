/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.ClienteDomain;
import es.unileon.ulebankoffice.domain.DNIException;
import es.unileon.ulebankoffice.domain.DireccionDomain;
import es.unileon.ulebankoffice.repository.ClienteRepository;
import es.unileon.ulebankoffice.repository.CuentaCorrienteRepository;
import es.unileon.ulebankoffice.repository.DireccionRepository;
import es.unileon.ulebankoffice.service.CuentaCorriente;
import es.unileon.ulebankoffice.service.Direccion;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
@RequestMapping("/o/u")
public class OfficeClientPageController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired 
	private DireccionRepository direccionesRepo;
	
	@Autowired 
	private CuentaCorrienteRepository cuentasCorrientesRepo;
	
	private String dniCliente;
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
	@ModelAttribute("nuevaCuentaCorriente")
	public CuentaCorriente cuentaCorriente(){
		return new CuentaCorriente();
	}
	
	@ModelAttribute("nuevaDireccion")
	public Direccion direccion(){
		return new Direccion();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"uin"})
	public String showClientData(ModelMap model, @RequestParam("uin") String dni){
		
		ClienteDomain clienteEncontrado = clienteRepo.findByDni(dni);
		
		dniCliente = clienteEncontrado.getDni().toString();
		
		model.addAttribute("cliente", clienteEncontrado);
		model.addAttribute("direcciones", direccionesRepo.findByDni(dniCliente));
		model.addAttribute("cuentasCorrientes", cuentasCorrientesRepo.findByDni(dniCliente));
		logger.debug("El dni es -> : " + dniCliente);
		return "officeclientpage";
	}
	
	@PostMapping(value="/nd")
	public String nuevaDireccion(ModelMap model, HttpServletRequest req, Principal principal, @Valid @ModelAttribute("nuevaDireccion") Direccion nuevaDireccion, BindingResult direccionResult) throws DNIException{
		logger.debug("El dni es -> : " + dniCliente);
		if(direccionResult.hasErrors()){
			return "officeclientpage";
		}
		
		DireccionDomain direccion = new DireccionDomain(dniCliente, nuevaDireccion.getCalle(), nuevaDireccion.getLocalidad(), nuevaDireccion.getComunidadAutonoma(), nuevaDireccion.getCodigoPostal(), nuevaDireccion.getNumero());
		
		direccionesRepo.save(direccion);
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " ha dado de alta una nueva dirección para el cliente: " + dniCliente);
		return "redirect:/o/u?uin="+dniCliente;
		
	}

}
