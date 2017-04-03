/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "CuentasCorrientes")
public class CuentaCorrienteDomain implements ProductoFinanciero<Handler>{
	
	@Id
	private String id;
	
	private Date fechaSolicitud, fechaResolucion, fechaFinalizacion;
	
	private Double saldo, comision, tae, interes;
	
	private String estado;
	
	private Handler dni;
	
	private List<MovimientoCuentaCorrienteDomain> movimientos;
	
	@Autowired
	DateFormat dateFormat;
	
	public CuentaCorrienteDomain(String dni, String estado, double saldo, double interes, double tae, double comision) throws DNIException, ParseException{
		this.dni = new DNIHandler(dni);
		this.estado = estado;
		this.saldo = saldo;
		this.interes = interes;
		this.tae = tae;
		this.comision = comision;
		this.fechaSolicitud = dateFormat.parse(new Date().toString());
		
	}
	
	
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public Double getTae() {
		return tae;
	}

	public void setTae(Double tae) {
		this.tae = tae;
	}

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Handler getDni() {
		return dni;
	}

	public void setDni(Handler dni) {
		this.dni = dni;
	}

	public List<MovimientoCuentaCorrienteDomain> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoCuentaCorrienteDomain> movimientos) {
		this.movimientos = movimientos;
	}
	
	public void addMovimiento(MovimientoCuentaCorrienteDomain movimiento){
		this.movimientos.add(movimiento);
	}
	
	//Se supone que van a enviar la documentación más adelante
	public Double realizarLiquidacion(){
		return null;
	}

}
