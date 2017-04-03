package es.unileon.ulebankoffice.service;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Razvan Raducu
 *
 */
public class CuentaCorriente {
	
	@NotEmpty
	private double interes;
	
	@NotBlank
	private String dni;
	
	@NotEmpty
	private double saldo; 
	
	@NotEmpty
	private double tae;
	
	@NotEmpty
	private double comision;
	
	//Nótese el uso de MovimientoCuentaCorriente y no domain pues también hay que validar los datos que componen el movimiento
	private List<MovimientoCuentaCorriente> movimientos;

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTae() {
		return tae;
	}

	public void setTae(double tae) {
		this.tae = tae;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public List<MovimientoCuentaCorriente> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoCuentaCorriente> movimientos) {
		this.movimientos = movimientos;
	}
	
	
	
}
