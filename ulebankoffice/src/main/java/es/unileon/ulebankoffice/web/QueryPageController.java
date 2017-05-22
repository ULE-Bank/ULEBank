package es.unileon.ulebankoffice.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.SolicitudFinancialAdvisorDomain;
import es.unileon.ulebankoffice.repository.SolicitudesFinancialAdvisorRepository;

@Controller
@RequestMapping(value = "/offersconsulting/querypage")
public class QueryPageController {

	@Autowired
	private SolicitudesFinancialAdvisorRepository repo;
	
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	
	@GetMapping( params = { "id" })
	public String add(ModelMap model, HttpServletRequest req, HttpServletResponse resp, Principal principal,
			@RequestParam("id") String idSolicitud) throws IOException {

		SolicitudFinancialAdvisorDomain solicitud = repo.findOne(idSolicitud);
		
		if(solicitud == null){
			logger.warn(principal.getName() + " " +  req.getRemoteAddr() + " " + req.getLocalAddr() + " ha tratado de acceder a una consulta inexistente. Devolviendo 404 advisor.");
			return "redirect:/e/adv404";
		}
		
		/* Se comprueba que el usuario que está accediendo a la solicitud es el creador de la misma o bien un empleado de la oficina o superiores */
		String creadorSolicitud = solicitud.getEmail();
			if(hasRole("ROLE_ADVISORUSER") && !principal.getName().equals(creadorSolicitud)){
				logger.warn("El usuario " + principal.getName() + req.getRemoteAddr() + " ha intentado acceder a la consulta " + solicitud.getId() + " del usuario " + creadorSolicitud + ". Redireccionando a 403.");
				return "redirect:/e/403";
			}
		
		/* Si es empleado, podrá ver los comandos para añadir nueva respuesta. Si la solicitud ya tiene una respuesta, se le cargará en el text área por si lo que quiere es modificarla. */
		model.addAttribute("asuntoOferta", solicitud.getAsuntoOferta());
		model.addAttribute("idQuery", solicitud.getId());
		model.addAttribute("enlaceArchivo", "/offersconsulting/serve?blob-key=" + solicitud.getFileBlobKey());
		model.addAttribute("textoOferta", solicitud.getTextoOferta());
		model.addAttribute("urlOferta", solicitud.getUrlOferta());
		model.addAttribute("respuestaOferta", solicitud.getRespuestaOferta());
		model.addAttribute("autorConsulta", solicitud.getEmail());

		return "querypage";

	}
	
	@PostMapping(params = {"id"})
	public String addResponse(ModelMap model, @RequestParam("response") String respuestaSolicitud, @RequestParam("id") String idSolicitud, Principal principal, HttpServletRequest req){
		if(hasRole("ROLE_ADMIN") || hasRole("ROLE_SUPERVISOR") || hasRole("ROLE_EMPLEADO")){
			SolicitudFinancialAdvisorDomain solicitud = repo.findOne(idSolicitud);
			
			if(solicitud == null){
				logger.warn(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + " ha tratado de acceder a una consulta inexistente. Devolviendo 404 advisor.");
				return "redirect:/e/adv404";
			}
			
			solicitud.setRespuestaOferta(respuestaSolicitud);
			solicitud.setEstado("Contestada");
			repo.save(solicitud);
			logger.info(principal.getName() + " ha añadido una respuesta a la consulta " + solicitud.getId());
			return "redirect:/offersconsulting/querypage?id="+idSolicitud;
		} else {
			logger.error(req.getRemoteAddr() + " " + req.getLocalAddr() + " Alguien ha tratado de hacer POST a una id de una consulta sin tener los roles necesarios o haber iniciado sesión. Esto significa que alguien ha tratado, por medios externos, contestar a una query.");
			return "redirect:/e/403";
		}
		
	}

	private boolean hasRole(String role) {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		boolean hasRole = false;
		for (GrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals(role);
			if (hasRole) {
				break;
			}
		}
		return hasRole;
	}

}
