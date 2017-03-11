/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.Date;
import java.util.List;

/**
 * @author Razvan Raducu
 *
 */
public class ExpedienteElectronico {
	
	private List<ProductoFinanciero> productosActivos, historialProductos;
	private Date fechaDeApertura, fechaDeCierre;
	private Handler dni;
	
	public List<ProductoFinanciero> getProductosActivos() {
		return productosActivos;
	}
	public void setProductosActivos(List<ProductoFinanciero> productosActivos) {
		this.productosActivos = productosActivos;
	}
	public List<ProductoFinanciero> getHistorialProductos() {
		return historialProductos;
	}
	public void setHistorialProductos(List<ProductoFinanciero> historialProductos) {
		this.historialProductos = historialProductos;
	}
	public Date getFechaDeApertura() {
		return fechaDeApertura;
	}
	public void setFechaDeApertura(Date fechaDeApertura) {
		this.fechaDeApertura = fechaDeApertura;
	}
	public Date getFechaDeCierre() {
		return fechaDeCierre;
	}
	public void setFechaDeCierre(Date fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
	}
	public Handler getDni() {
		return dni;
	}
	public void setDni(Handler dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
}
