package es.unileon.ulebankoffice.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.Days;
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
			fechaMovimiento = sdf.parse(movimiento.getFechaMovimiento());
			descripcionMovimiento = movimiento.getDescripcionMovimiento();
			importeMovimiento = movimiento.getImporteMovimiento();
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
		List<Double> totalLiquidacion = myCreditos.obtenerLiquidacion();
		
		/* El último elemento de esta tabla es la Liquidación per se */
		List<String> itemTabla = new ArrayList<>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fechaVencimiento);
		itemTabla.add(calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH));
		itemTabla.add("Liquidación");
		itemTabla.add(String.valueOf(totalLiquidacion.get(5)));
		itemTabla.add("-");
		itemTabla.add(String.valueOf(Double.parseDouble(tabla.get(tabla.size()-1).get(4))+totalLiquidacion.get(5)));
		itemTabla.add(String.valueOf(totalLiquidacion.get(4).intValue()));
		itemTabla.add(String.valueOf(totalLiquidacion.get(0)));
		itemTabla.add(String.valueOf(totalLiquidacion.get(1)));
		itemTabla.add(String.valueOf(totalLiquidacion.get(2)));
		
		tabla.add(itemTabla);
		
		
		
		model.addObject("tabla", tabla);
		
		/* Tabla de la Liquidación */
		
		
		model.addObject("iDeudores1",String.valueOf(interesDeudor));
		model.addObject("iDeudores2",String.valueOf(totalLiquidacion.get(0)));
		
		model.addObject("iExcedidos1",String.valueOf(interesExcedido));
		model.addObject("iExcedidos2",String.valueOf(totalLiquidacion.get(1)));
		
		model.addObject("iAcreedores1",String.valueOf(interesAcreedor));
		model.addObject("iAcreedores2",String.valueOf(totalLiquidacion.get(2)));
		
		model.addObject("CSMND1",String.valueOf(comisionSMND));
		model.addObject("CSMND2",String.valueOf(totalLiquidacion.get(3)));
		
		model.addObject("total", totalLiquidacion.get(5));
		
        response.addCookie(new Cookie("resultados", "1"));
        
        
        return model;
	}
	
	@RequestMapping(value = "/creditaccount", method = RequestMethod.GET)
    public String add(Model model, @ModelAttribute("creditos") Creditos creditos) {
        return "creditaccount";
    }
}
