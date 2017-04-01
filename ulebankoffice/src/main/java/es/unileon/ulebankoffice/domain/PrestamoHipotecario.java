/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 * @tipo Hipotecario
 * ESTA CLASE ESTÁ AÚN INCOMPLETA
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

	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}


	@Override
	public Date getFechaSolicitud() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Date getFechaResolucion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Date getFechaFinalizacion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getDni() {
		// TODO Auto-generated method stub
		return null;
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


	
}
