package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class CreditosDomain extends Operacion {
	
	private double limiteCredito;
	private Date fechaApertura, fechaVencimiento;
	private double interesDeudor, interesExcedido, interesAcreedor, comisionSMND;
	private List<MovimientosCreditosDomain> movimientos;
	
	public CreditosDomain(double limiteCredito, Date fechaApertura, Date fechavencimiento, double interesDeudor, double interesExcedido, 
			double interesAcreedor, double comisionSMND, List<MovimientosCreditosDomain> movimientos) {
		
		this.limiteCredito = limiteCredito;
		this.fechaApertura = fechaApertura;
		this.fechaVencimiento = fechavencimiento;
		this.interesDeudor = interesDeudor / 100.0;
		this.interesExcedido = interesExcedido / 100.0;
		this.interesAcreedor = interesAcreedor / 100.0;
		this.comisionSMND = comisionSMND / 1000.0;
		this.movimientos = movimientos;
	}
	
	public void incluirComsionAperturaYCorretaje(double comisionApertura, double corretaje) {
		double importeComisionApertura = limiteCredito * (comisionApertura / 1000.0);
		double importeCorretaje = limiteCredito * (corretaje / 1000.0);
		
		movimientos.add(0, new MovimientosCreditosDomain("Corretaje", importeCorretaje, fechaApertura));
		movimientos.add(0, new MovimientosCreditosDomain("Comision de apertura", importeComisionApertura, fechaApertura));
	}
	
	public List<List<String>> calcular() {
		List<Double> saldo = new ArrayList<Double>();
		List<Integer> dias = new ArrayList<Integer>();
		List<Double> numerosDeudores = new ArrayList<Double>();
		List<Double> numerosExcedidos = new ArrayList<Double>();
		List<Double> numerosAcreedores = new ArrayList<Double>();
		
		List<List<String>> tabla = new ArrayList<List<String>>();
		List<String> itemTabla;
		
		int index = 0;
		
		for(MovimientosCreditosDomain movimiento : movimientos) {
			itemTabla = new ArrayList<String>();
			
			if(saldo.isEmpty()) {
				saldo.add(movimiento.getImporteMovimiento());
				itemTabla.add(Double.toString(redondear(movimiento.getImporteMovimiento())));
				System.out.println(movimiento.getImporteMovimiento());
			}
			else {
				saldo.add(movimiento.getImporteMovimiento() + saldo.get(index-1));
				itemTabla.add(Double.toString(redondear(movimiento.getImporteMovimiento() + saldo.get(index-1))));
				System.out.println(movimiento.getImporteMovimiento() + saldo.get(index-1));
			}
			
			DateTime thisDay, nextDay;
			Days days;
			thisDay = new DateTime(movimiento.getFechaMovimiento());
			if(index + 1 < movimientos.size()) {
				nextDay = new DateTime(movimientos.get(index+1).getFechaMovimiento());
				days = Days.daysBetween(thisDay, nextDay);
				dias.add(days.getDays());
			}
			else {
				nextDay = new DateTime(fechaVencimiento);
				days = Days.daysBetween(thisDay, nextDay);
				dias.add(days.getDays());
			}
			itemTabla.add(Integer.toString(days.getDays()));
			
			if(saldo.get(index) > limiteCredito) {
				numerosDeudores.add(limiteCredito * dias.get(index));
				System.out.println(limiteCredito * dias.get(index));
				double diferencia = saldo.get(index) - limiteCredito;
				numerosExcedidos.add(diferencia * dias.get(index));
				itemTabla.add("-");
				itemTabla.add(Double.toString(diferencia * dias.get(index)));
				itemTabla.add("-");
			}
			else if(saldo.get(index) < 0) {
				numerosAcreedores.add(dias.get(index) * saldo.get(index) * (-1));
				itemTabla.add("-");
				itemTabla.add("-");
				itemTabla.add(Double.toString(dias.get(index) * saldo.get(index) * (-1)));
				System.out.println(dias.get(index) * saldo.get(index) * (-1));
			}
			else {
				numerosDeudores.add(saldo.get(index) * dias.get(index));
				itemTabla.add(Double.toString(saldo.get(index) * dias.get(index)));
				itemTabla.add("-");
				itemTabla.add("-");
				System.out.println(saldo.get(index) * dias.get(index));
			}
			
			tabla.add(itemTabla);
			
			index++;
		}
		
		double sumatorioDeudores = 0, sumatorioExcedidos = 0, sumatorioAcreedores = 0;
		int sumatorioDias = 0;
		
		for(double deudor : numerosDeudores)
			sumatorioDeudores += deudor;
		
		for(double excedido : numerosExcedidos)
			sumatorioExcedidos += excedido;
		
		for(double acreedor : numerosAcreedores)
			sumatorioAcreedores += acreedor;
		
		for(int dia : dias)
			sumatorioDias += dia;
		
		System.out.println("Deudores: " + sumatorioDeudores + "\nExcedidos: " + sumatorioExcedidos + "\nAcreedores: " + sumatorioAcreedores);
		
		double interesesDeudores = (interesDeudor * sumatorioDeudores) / 360;
		System.out.println("Intereses deudores: " + interesesDeudores);
		
		double interesesExcedidos = (interesExcedido * sumatorioExcedidos) / 360;
		System.out.println("Intereses excedidos: " + interesesExcedidos);
		
		double interesesAcreedores = (interesAcreedor * sumatorioAcreedores) / 360;
		System.out.println("Intereses acreedores: " + interesesAcreedores);
		
		double saldoMedioDispuesto = sumatorioDeudores / sumatorioDias;
		double saldoMedioNoDispuesto = (limiteCredito - saldoMedioDispuesto) * comisionSMND;
		System.out.println("SMND: " + saldoMedioNoDispuesto);
		
		double totalDisposiciones = interesesDeudores + interesesExcedidos + saldoMedioNoDispuesto - interesesAcreedores;
		System.out.println("Total disposiciones: " + totalDisposiciones);
		
		double totalSaldo = saldo.get(saldo.size()-1) + totalDisposiciones;
		System.out.println("Total saldo: " + totalSaldo);
		
		itemTabla = new ArrayList<String>();
		
		return tabla;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public double getInteresDeudor() {
		return interesDeudor;
	}

	public void setInteresDeudor(double interesDeudor) {
		this.interesDeudor = interesDeudor / 100.0;
	}

	public double getInteresExcedido() {
		return interesExcedido;
	}

	public void setInteresExcedido(double interesExcedido) {
		this.interesExcedido = interesExcedido / 100.0;
	}

	public double getInteresAcreedor() {
		return interesAcreedor;
	}

	public void setInteresAcreedor(double interesAcreedor) {
		this.interesAcreedor = interesAcreedor / 100.0;
	}

	public double getComisionSMND() {
		return comisionSMND;
	}

	public void setComisionSMND(double comisionSMND) {
		this.comisionSMND = comisionSMND / 1000.0;
	}

	public List<MovimientosCreditosDomain> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientosCreditosDomain> movimientos) {
		this.movimientos = movimientos;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
}
