package es.unileon.ulebankoffice.service;

import java.util.Date;

/**
 * @author Razvan Raducu
 *
 */
public interface ProductoFinanciero {
//	public void crearSolicitud();
//	public Solicitud getSolicitud();
//	public void setId(Handler id);
//	public Handler getId();
	public void setName(String name);
//	public void addDocument(Documento documento);
//	public void removeDocument(String name);
//	public List<Documento> getListaDocs();
	public void setFechaSolicitud(Date fecha);
	public Date getFechaSolicitud();
	public void setFechaResolucion(Date fecha);
	public Date getFechaResolucion();
	public void setFechaFinalizacion(Date fecha);
	public Date getFechaFinalizacion();
	public void setEstado(String estado);
	public String getestado();
	public void setDni(String dni);
	public String getDni();
	
}
