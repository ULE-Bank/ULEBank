/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Document(collection="CuentasBancarias")
public class CuentaBancaria implements ProductoFinanciero {
	
	@Id
	private String id;
	
	@NotBlank @NotEmpty
	private Double saldo, comision, tae;
	
//	private Solicitud solicitud;
	
//	private Handler id;
	@NotBlank @NotEmpty
	private String dni;
	@NotBlank @NotEmpty
	private String name, estado;
	
//	private List<Documento> listaDocs;
	@NotBlank @NotEmpty @Past
	private Date fechaSolicitud;
	
	@NotBlank @NotEmpty
	private Date fechaResolucion, fechaFinalizacion;

	
	@Override
	public void setFechaSolicitud(Date fecha) {
		// TODO Auto-generated method stub
		this.fechaSolicitud = fecha;
	}

	@Override
	public Date getFechaSolicitud() {
		// TODO Auto-generated method stub
		return fechaSolicitud;
	}

	@Override
	public void setFechaResolucion(Date fecha) {
		// TODO Auto-generated method stub
		this.fechaResolucion = fecha;
	}

	@Override
	public Date getFechaResolucion() {
		// TODO Auto-generated method stub
		return fechaResolucion;
	}

	@Override
	public void setFechaFinalizacion(Date fecha) {
		// TODO Auto-generated method stub
		this.fechaFinalizacion = fecha;
	}

	@Override
	public Date getFechaFinalizacion() {
		// TODO Auto-generated method stub
		return fechaFinalizacion;
	}

	@Override
	public void setEstado(String estado) {
		// TODO Auto-generated method stub
		this.estado = estado;
	}

	@Override
	public String getestado() {
		// TODO Auto-generated method stub
		return estado;
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

	public String getName() {
		return name;
	}

	public String getEstado() {
		return estado;
	}

//	public void setSolicitud(Solicitud solicitud) {
//		this.solicitud = solicitud;
//	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDni() {
		// TODO Auto-generated method stub
		return this.dni;
	}

	@Override
	public void setDni(String dni) {
		// TODO Auto-generated method stub
		this.dni = dni;
	}
	
	
}
