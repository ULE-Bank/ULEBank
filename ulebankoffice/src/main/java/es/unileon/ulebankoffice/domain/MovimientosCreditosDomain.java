package es.unileon.ulebankoffice.domain;

import java.util.Date;

public class MovimientosCreditosDomain {
	
	private String descripcionMovimiento;
	private double importeMovimiento;
	private Date fechaMovimiento;
	
	private boolean procesado = false;
	
	public MovimientosCreditosDomain(String descripcionMovimiento, double importeMovimiento, Date fechaMovimiento) {
		this.descripcionMovimiento = descripcionMovimiento;
		this.importeMovimiento = importeMovimiento;
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getDescripcionMovimiento() {
		return descripcionMovimiento;
	}

	public void setDescripcionMovimiento(String descripcionMovimiento) {
		this.descripcionMovimiento = descripcionMovimiento;
	}

	public double getImporteMovimiento() {
		return importeMovimiento;
	}

	public void setImporteMovimiento(double importeMovimiento) {
		this.importeMovimiento = importeMovimiento;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
}
