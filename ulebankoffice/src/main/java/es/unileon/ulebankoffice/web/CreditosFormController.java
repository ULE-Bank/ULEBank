package es.unileon.ulebankoffice.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import es.unileon.ulebankoffice.domain.CreditosDomain;
import es.unileon.ulebankoffice.domain.MovimientosCreditosDomain;
import es.unileon.ulebankoffice.service.Creditos;
import es.unileon.ulebankoffice.service.MovimientosCreditos;

@Controller
public class CreditosFormController {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value = "/creditaccount", method = RequestMethod.POST)
    public ModelAndView processAdd(@Valid @ModelAttribute("creditos")
    		Creditos creditos, BindingResult bindingResult, HttpServletResponse response) throws ParseException {
		
		ModelAndView model = new ModelAndView("creditaccount");
		
		if (bindingResult.hasErrors())
        	return model;
		
		List<MovimientosCreditos> movimientos = creditos.getMovimientos();
		
		List<MovimientosCreditosDomain> myMovimientos = new ArrayList<>();
		
		response.addCookie(new Cookie("movimientos", new Gson().toJson(movimientos)));
		response.addCookie(new Cookie("fechaApertura", creditos.getFechaApertura()));
		response.addCookie(new Cookie("fechaVencimiento", creditos.getFechaVencimiento()));
		
		String descripcionMovimiento;
		double importeMovimiento;
		Date fechaMovimiento;
		String operacion;
		
		
		for(MovimientosCreditos movimiento : movimientos) {
			fechaMovimiento = sdf.parse(movimiento.getFecha());
			descripcionMovimiento = movimiento.getDescripcion();
			importeMovimiento = movimiento.getImporte();
			operacion = movimiento.getOperacion();
			myMovimientos.add(new MovimientosCreditosDomain(descripcionMovimiento, importeMovimiento, fechaMovimiento,operacion));
		}
		
		double limiteCredito = creditos.getLimiteCredito();
		Date fechaApertura = sdf.parse(creditos.getFechaApertura());
		Date fechaVencimiento = sdf.parse(creditos.getFechaVencimiento());
		double interesDeudor = creditos.getInteresDeudor();
		double interesExcedido = creditos.getInteresExcedido();
		double interesAcreedor = creditos.getInteresAcreedor();
		double comisionSMND = creditos.getComisionSMND();
		double comisionApertura = creditos.getComisionApertura();
		double corretaje = creditos.getCorretaje();
		
		CreditosDomain myCreditos = new CreditosDomain(limiteCredito, fechaApertura, fechaVencimiento, interesDeudor, 
				interesExcedido, interesAcreedor, comisionSMND, myMovimientos);
		
		myCreditos.incluirComsionAperturaYCorretaje(comisionApertura, corretaje);
		
		List<List<String>> tabla = myCreditos.calcularTabla();
		
		model.addObject("tabla", tabla);
        model.addObject("liquidacion", myCreditos.obtenerLiquidacion());
		
        response.addCookie(new Cookie("resultados", "1"));
        
        
        return model;
	}
	
	@RequestMapping(value = "/creditaccount", method = RequestMethod.GET)
    public String add(Model model, @ModelAttribute("creditos") Creditos creditos) {
        return "creditaccount";
    }
}
