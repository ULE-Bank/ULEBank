/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvi Razvan Raducu
 * @tipo Hipotecario
 */
@Document(collection="Prestamos")
public class PrestamoHipotecario implements ProductoFinanciero {
	
	@Id
	private String id;
	
	private String tipo;
	
	private Double interes, amortizacion;
	
	@Min(0)
	private Double capital;
//	private Solicitud solicitud;
//	private Handler id;
	
	@NotBlank @NotEmpty
	private String name, estado;
//	private List<Documento> listaDocs;
	
	@NotBlank @NotEmpty @Past
	private Date fechaSolicitud;
	
	private Date fechaResolucion, fechaFinalizacion;
	
	@NotBlank @NotEmpty
	private String dni;

	public PrestamoHipotecario() {
		this.tipo = "Hipotecario";
	}
//	@Override
//	public void crearSolicitud() {
//		// TODO Auto-generated method stub
//		this.solicitud = new Solicitud();
//	}
//
//	@Override
//	public Solicitud getSolicitud() {
//		// TODO Auto-generated method stub
//		return this.solicitud;
//	}
//
//	@Override
//	public void setId(Handler id) {
//		this.id = id;	
//	}
//
//	@Override
//	public Handler getId() {
//		// TODO Auto-generated method stub
//		return id;
//	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

//	@Override
//	public void addDocument(Documento documento) {
//		// TODO Auto-generated method stub
//		this.listaDocs.add(documento);
//	}
//
//		/**
//		 * Pendiente de revisión
//		 * 
//		 *
//		 */
//	@Override
//	public void removeDocument(String name) {
//		// TODO Auto-generated method stub
//		int index = -1;
//		for (Documento documento : listaDocs) {
//			if(documento.getName().equals(name)){
//				index = listaDocs.indexOf(documento);
//			}
//		}
//		if(index != -1){
//		listaDocs.remove(index);
//		}
//	}
//
//	@Override
//	public List<Documento> getListaDocs() {
//		// TODO Auto-generated method stub
//		return this.listaDocs;
//	}

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

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public Double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(Double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public String getName() {
		return name;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public void setDni(String dni) {
		// TODO Auto-generated method stub
		this.dni = dni;
	}

	@Override
	public String getDni() {
		// TODO Auto-generated method stub
		return this.dni;
	}

	
}
