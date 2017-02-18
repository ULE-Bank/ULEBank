package es.unileon.ulebankoffice.service;

public class MovimientosCreditos {
	
	private String descripcionMovimiento;
	private double importeMovimiento;
	private String fechaMovimiento;
	
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
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
}
