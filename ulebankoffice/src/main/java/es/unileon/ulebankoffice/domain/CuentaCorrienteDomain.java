/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "CuentasCorrientes")
public class CuentaCorrienteDomain implements ProductoFinanciero {

	@Id
	private String id;

	private Date fechaApertura;
	private Double interesesAcreedores;
	private Double interesDeudorSobreSaldosNegativos;
	private Double retencionRendimientosCapital;
	private Double comisionMantenimiento;
	private Double comisionDescubierto;
	private Double minimoComisionDescubierto;
	private Date fechaSolicitud;
	private Date fechaResolucion;
	private Date fechaFinalizacion;
	private int diasAnuales;
	private int periodoLiquidacion;

	private Double saldo;
	private String estado;

	private Handler dni;

	private List<MovimientoCuentaCorrienteDomain> movimientos;

	private Documentos documentos;

	/**
	 * Constructor utilizado para instanciar manualmente objetos e instanciar
	 * por primera vez una CuentaCorrienteDomain, pasándole el DNI y sin
	 * especificar sus documentos, que tendrán que ser añadidos más adelante.
	 * 
	 * @param fechaApertura
	 * @param interesesAcreedores
	 * @param interesDeudorSobreSaldosNegativos
	 * @param retencionRendimientosCapital
	 * @param comisionMantenimiento
	 * @param comisionDescubierto
	 * @param minimoComisionDescubierto
	 * @param fechaSolicitud
	 * @param saldo
	 * @param estado
	 * @param dni
	 * @param diasAnuales
	 * @param periodoLiquidacion
	 */
	public CuentaCorrienteDomain(Date fechaApertura, Double interesesAcreedores,
			Double interesDeudorSobreSaldosNegativos, Double retencionRendimientosCapital, Double comisionMantenimiento,
			Double comisionDescubierto, Double minimoComisionDescubierto, Date fechaSolicitud, Double saldo,
			String estado, Handler dni, int diasAnuales, int periodoLiquidacion) {
		this.fechaApertura = fechaApertura;
		this.interesesAcreedores = interesesAcreedores;
		this.interesDeudorSobreSaldosNegativos = interesDeudorSobreSaldosNegativos;
		this.retencionRendimientosCapital = retencionRendimientosCapital;
		this.comisionMantenimiento = comisionMantenimiento;
		this.comisionDescubierto = comisionDescubierto;
		this.minimoComisionDescubierto = minimoComisionDescubierto;
		this.fechaSolicitud = fechaSolicitud;
		this.saldo = saldo;
		this.estado = estado;
		this.dni = dni;
		this.diasAnuales = diasAnuales;
		this.periodoLiquidacion = periodoLiquidacion;
	}

	/**
	 * Constructor utilizado para instanciar objetos de esta clase desde MongoDB
	 * 
	 * @param fechaApertura
	 * @param interesesAcreedores
	 * @param interesDeudorSobreSaldosNegativos
	 * @param retencionRendimientosCapital
	 * @param comisionMantenimiento
	 * @param comisionDescubierto
	 * @param minimoComisionDescubierto
	 * @param fechaSolicitud
	 * @param fechaResolucion
	 * @param fechaFinalizacion
	 * @param saldo
	 * @param estado
	 * @param dni
	 * @param movimientos
	 * @param documentos
	 * @param diasAnuales
	 * @param periodoLiquidacion
	 */
	@PersistenceConstructor
	public CuentaCorrienteDomain(Date fechaApertura, Double interesesAcreedores,
			Double interesDeudorSobreSaldosNegativos, Double retencionRendimientosCapital, Double comisionMantenimiento,
			Double comisionDescubierto, Double minimoComisionDescubierto, Date fechaSolicitud, Date fechaResolucion,
			Date fechaFinalizacion, Double saldo, String estado, Handler dni,
			List<MovimientoCuentaCorrienteDomain> movimientos, Documentos documentos, int diasAnuales,
			int periodoLiquidacion) {
		this.fechaApertura = fechaApertura;
		this.interesesAcreedores = interesesAcreedores;
		this.interesDeudorSobreSaldosNegativos = interesDeudorSobreSaldosNegativos;
		this.retencionRendimientosCapital = retencionRendimientosCapital;
		this.comisionMantenimiento = comisionMantenimiento;
		this.comisionDescubierto = comisionDescubierto;
		this.minimoComisionDescubierto = minimoComisionDescubierto;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaResolucion = fechaResolucion;
		this.fechaFinalizacion = fechaFinalizacion;
		this.saldo = saldo;
		this.estado = estado;
		this.dni = dni;
		this.movimientos = movimientos;
		this.documentos = documentos;
		this.diasAnuales = diasAnuales;
		this.periodoLiquidacion = periodoLiquidacion;
	}

	/**
	 * Método para obtener la liquidación entre los periodos indicados. La
	 * liquidación se realizará teniendo en cuenta los movimientos entre las dos
	 * fechas indicadas, exclusive. Si se quiere hacer la liqudiación entre el 2
	 * y el 10 de mayo, por ejemplo, se deberá indicar como parámetros el 1 y el
	 * 11 de mayo.
	 * 
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return El total de la liquidación
	 */
	public Double realizarLiquidacion(Date fechaInicio, Date fechaFinal) {

		ordenarMovimientosPorFecha();
		List<MovimientoCuentaCorrienteDomain> movimientosLiquidacion = obtenerMovimientosLiquidacion(fechaInicio,
				fechaFinal);

		for (MovimientoCuentaCorrienteDomain movimientoCuentaCorrienteDomain : movimientosLiquidacion) {

		}

		return null;
	}

	/*
	 * A este método le falta optimización. Lo ideal sería llevar un contador de
	 * movimientos que ya han sido liquidados, de esta forma no se recorrerían
	 * todos siempre. Animo a la persona que esté leyendo esto y que haya venido
	 * detrás de mi a hacerlo ya que yo no he tenido tiempo. En cuanto haya
	 * muchos movimientos si se tiene que recorrer toda la coleccion siempre
	 * esto va a ser luz fuego destrucción.
	 */
	private List<MovimientoCuentaCorrienteDomain> obtenerMovimientosLiquidacion(Date fechaInicio, Date fechaFinal) {

		List<MovimientoCuentaCorrienteDomain> movimientosLiquidacion = new ArrayList<>();
		for (MovimientoCuentaCorrienteDomain movimientoCuentaCorrienteDomain : movimientos) {
			Date fechaMovimiento = movimientoCuentaCorrienteDomain.getFechaValor();
			if (fechaMovimiento.after(fechaInicio) && fechaMovimiento.before(fechaFinal)) {
				movimientosLiquidacion.add(movimientoCuentaCorrienteDomain);
			}
		}
		return movimientosLiquidacion;

	}

	private void ordenarMovimientosPorFecha() {
		Collections.sort(this.movimientos, new Comparator<MovimientoCuentaCorrienteDomain>() {
			@Override
			public int compare(MovimientoCuentaCorrienteDomain m1, MovimientoCuentaCorrienteDomain m2) {
				return m1.getFechaValor().compareTo(m2.getFechaValor());
			}
		});
	}

	@Override
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Override
	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	@Override
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

	@Override
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
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

	/**
	 * Añade la cantidad indicada al saldo actual de la cuenta
	 * 
	 * @param saldo
	 */
	public void ingresarSaldo(double saldo) {
		this.saldo += saldo;
	}

	/**
	 * Extrae la cantidad indicada del saldo actual de la cuenta
	 * 
	 * @param saldo
	 */
	public void extraerSaldo(double saldo) {
		this.saldo -= saldo;
	}

	/**
	 * Añade a la lista de movimientos el movimiento especificado
	 * 
	 * @param movimiento
	 */
	public void addMovimiento(MovimientoCuentaCorrienteDomain movimiento) {
		this.movimientos.add(movimiento);
	}

	/**
	 * Añade el documento a la base de datos así como a la lista de ids de
	 * documentos asociada a esta cuenta corriente.
	 * 
	 * @param documento
	 */
	public void addDocumento(DocumentoAdjuntoDomain documento) {
		documentos.add(documento);
	}

	public List<DocumentoAdjuntoDomain> getDocumentos() throws EmptyCollectionException {
		// Este código sustituye a return documentos.getDocumentos()

		Iterator<DocumentoAdjuntoDomain> iterator = documentos.createIterator();
		List<DocumentoAdjuntoDomain> listaDocs = new ArrayList<>();

		for (iterator.firstElement(); iterator.hasMoreElements(); iterator.nextElement()) {

			listaDocs.add((DocumentoAdjuntoDomain) iterator.currentElement());

		}
		return listaDocs;
	}

	public String getId() {
		return id;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Double getInteresesAcreedores() {
		return interesesAcreedores;
	}

	public void setInteresesAcreedores(Double interesesAcreedores) {
		this.interesesAcreedores = interesesAcreedores;
	}

	public Double getInteresDeudorSobreSaldosNegativos() {
		return interesDeudorSobreSaldosNegativos;
	}

	public void setInteresDeudorSobreSaldosNegativos(Double interesDeudorSobreSaldosNegativos) {
		this.interesDeudorSobreSaldosNegativos = interesDeudorSobreSaldosNegativos;
	}

	public Double getRetencionRendimientosCapital() {
		return retencionRendimientosCapital;
	}

	public void setRetencionRendimientosCapital(Double retencionRendimientosCapital) {
		this.retencionRendimientosCapital = retencionRendimientosCapital;
	}

	public Double getComisionMantenimiento() {
		return comisionMantenimiento;
	}

	public void setComisionMantenimiento(Double comisionMantenimiento) {
		this.comisionMantenimiento = comisionMantenimiento;
	}

	public Double getComisionDescubierto() {
		return comisionDescubierto;
	}

	public void setComisionDescubierto(Double comisionDescubierto) {
		this.comisionDescubierto = comisionDescubierto;
	}

	public Double getMinimoComisionDescubierto() {
		return minimoComisionDescubierto;
	}

	public void setMinimoComisionDescubierto(Double minimoComisionDescubierto) {
		this.minimoComisionDescubierto = minimoComisionDescubierto;
	}

	public int getDiasAnuales() {
		return diasAnuales;
	}

	public void setDiasAnuales(int diasAnuales) {
		this.diasAnuales = diasAnuales;
	}

	public int getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}

	public void setPeriodoLiquidacion(int periodoLiquidacion) {
		this.periodoLiquidacion = periodoLiquidacion;
	}

}
