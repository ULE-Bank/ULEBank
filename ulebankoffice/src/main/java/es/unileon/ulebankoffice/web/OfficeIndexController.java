package es.unileon.ulebankoffice.web;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.ClienteDomain;
import es.unileon.ulebankoffice.domain.DireccionDomain;
import es.unileon.ulebankoffice.domain.UleBankEmployeeDomain;
import es.unileon.ulebankoffice.repository.ClienteRepository;
import es.unileon.ulebankoffice.repository.UleBankEmployeeRepository;
import es.unileon.ulebankoffice.service.Cliente;
import es.unileon.ulebankoffice.service.UleBankEmployee;

/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping(value = "/o")
public class OfficeIndexController {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private UleBankEmployeeRepository employeesRepo;

	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String CLIENTSVIEWATTRIBUTE = "clients";
	private static final String CLIENTERROR = "clientError";
	
	@ModelAttribute("nuevoEmpleado")
	public UleBankEmployee addEmployee(){
		return new UleBankEmployee();
	}
	
	@ModelAttribute("nuevoCliente")
	public Cliente addClient(){
		return new Cliente();
	}
	
	@ModelAttribute(CLIENTSVIEWATTRIBUTE)
	public List<ClienteDomain> getClients(){
		return repo.findAll();
	}
	
	@ModelAttribute("employees")
	public List<UleBankEmployeeDomain> getEmployees(HttpServletRequest req){
		if (req.isUserInRole("ROLE_ADMIN")) {
			return employeesRepo.findAll();
		}
		return new ArrayList<>();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");

	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String comingSoon(ModelMap model, Principal principal, HttpServletRequest req) {
		logger.info(principal.getName() + " ha accedido a la página principal de la oficina.");
		return "officeindex";
	}

	@RequestMapping(method = RequestMethod.GET, params = "uin")
	public String showMeAclient(ModelMap model, @RequestParam("uin") String dni, HttpServletRequest req, Principal principal) {

		logger.info(principal.getName() + " ha buscado el cliente con dni: " + dni);

		/*
		 * Es mucho más sensato capturar el idioma que el país ya que puede ser
		 * es_ES o es_MX. El idioma es el mismo pero el país no. De cara al
		 * futuro puede suponer problemas si se captura sólo el país.
		 */
		String locale = req.getLocale().getLanguage();
		String noClientFoundError = "";
		if (locale.equals(new Locale("en").getLanguage())) {
			noClientFoundError = "No client found with such identifier " + dni;
		} else if (locale.equals(new Locale("es").getLanguage())) {
			noClientFoundError = "No hay ningún cliente con el identificador " + dni;
		}

		ClienteDomain clienteFound = repo.findByDni(dni);
		if (clienteFound == null) {
			logger.debug("el cliente no se ha encontrado y el locale es :" + locale);
			logger.info("Cliente no existente");
			model.addAttribute(CLIENTERROR, noClientFoundError);
			model.addAttribute(CLIENTSVIEWATTRIBUTE, repo.findAll());
		} else {
			logger.info("Cliente encontrado");
			model.addAttribute(CLIENTSVIEWATTRIBUTE, clienteFound);
		}

		return "officeindex";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveNewClient(@ModelAttribute("nuevoCliente") @Valid Cliente nuevoCliente, BindingResult clienteResult,
			BindingResult empleadoResult,
			HttpServletRequest req, HttpServletResponse resp, ModelMap model, Principal principal) {
	
		ClienteDomain cliente;
		System.out.println("LA FECHA DEL CLIENTE LLEGA COMO: ->> " + nuevoCliente.getFechaNacimiento());
		if (clienteResult.hasErrors()) {
			return "officeindex";
		}
	
		try {
			cliente = new ClienteDomain(nuevoCliente.getName(), nuevoCliente.getLastName(), nuevoCliente.getEmail(),
					nuevoCliente.getFechaNacimiento(), nuevoCliente.getDni(), new ArrayList<DireccionDomain>(),
					nuevoCliente.getNacionalidad());
		} catch (Exception e) {
			clienteResult.addError(new FieldError("nuevoCliente", "dni", e.getMessage()));
			logger.error(principal.getName() + " ha intentado crear un cliente y se ha producido un error: "
					+ e.getMessage() + " ||\n " + e + "||" + e.getLocalizedMessage() + e.getCause());
			return "officeindex";
		}

		try {
			
			repo.save(cliente);
		} catch (Exception e) {
			model.addAttribute(CLIENTERROR, "Ya existe un cliente con ese DNI/NIE");
			logger.error(principal.getName() + " ha intentado crear un cliente que ya existe ("
					+ cliente.getDni().toString() + ")." + e);
			return "officeindex";
		}

		logger.info("Se ha creado el nuevo cliente con identificación: " + nuevoCliente.getDni());
		return "newClientVerification";

	}
	
	@RequestMapping(value="/admin/submitEmployee",method = RequestMethod.POST)
	public String saveNewClient(@ModelAttribute("nuevoEmpleado") @Valid UleBankEmployee nuevoEmpleado,
			BindingResult empleadoResult, HttpServletRequest req, HttpServletResponse resp, ModelMap model,
			Principal principal) {

		if (empleadoResult.hasErrors()) {
			
			logger.warn("Se ha tratado de crear un empleado. Los datos son incorrectos." + empleadoResult.getAllErrors().toString());
			return "redirect:/o";
		}

		UleBankEmployeeDomain empleado = new UleBankEmployeeDomain(nuevoEmpleado.getUserName(),
				bcrypt.encode(nuevoEmpleado.getPassword()), nuevoEmpleado.getRole());

		try {
			employeesRepo.save(empleado);
		} catch (Exception e) {
			model.addAttribute("errorRegistroEmpleado", "Ya existe un empleado con ese nombre de usuario");
			logger.info("Se ha tratado de crear el usuario de la sucursal:" + empleado.getUserName()
					+ " con privilegios: " + empleado.getRole() + " pero ya existía. " + e);
			return "redirect:/o";
		}

		logger.info(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() +  " Ha creado el usuario de la sucursual: " + empleado.getUserName() + " con privilegios: "
				+ empleado.getRole());
		return "redirect:/o";

	}
	
	
	@RequestMapping(value = "/admin/d", method = RequestMethod.GET, params = "ein")
	public String deleteEmployee(ModelMap model, @RequestParam("ein") String employeeUserName, Principal principal, HttpServletRequest req) {

		UleBankEmployeeDomain empleado = employeesRepo.findByUserName(employeeUserName);

		/*
		 * Por si a alguien se le ocurre introducir la URL directamente en el
		 * navegador con un "ein" inexistente. Con esto se evita la excepción
		 * IllegalArgumentException del método .delete()
		 */
		if (empleado == null) {
			logger.warn(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() + " Ha tratado de borrar un empleado inexistente. Alguien ha accedido a una URL que no debía. Empleado inexistente: " + employeeUserName);
			return "redirect:/o";
		}
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr() +  " Ha eliminado el empleado de la oficina: " + employeeUserName);
		employeesRepo.delete(empleado);
		return "redirect:/o";

	}
	
}
