/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "CuentasCorrientes")
public class CuentaCorrienteDomain implements ProductoFinanciero<Handler> {

	@Id
	private String id;

	private Date fechaSolicitud;
	private Date fechaResolucion;
	private Date fechaFinalizacion;

	private Double saldo;
	private Double comision;
	private Double tae;
	private Double interes;

	private String estado;

	private Handler dni;

	private List<MovimientoCuentaCorrienteDomain> movimientos;

	private Documentos documentos;

	/**
	 * Constructor utilizado para instanciar manualmente objetos e instanciar
	 * por primera vez una CuentaCorrienteDomain, pasándole el DNI y sin
	 * especificar sus documentos, que tendrán que ser añadidos más adelante.
	 * 
	 * @param dni
	 * @param estado
	 * @param saldo
	 * @param interes
	 * @param tae
	 * @param comision
	 * @param fechaSolicitud
	 * @throws DNIException
	 * @throws ParseException
	 */
	public CuentaCorrienteDomain(Handler dni, String estado, Double saldo, Double interes, Double tae, Double comision,
			Date fechaSolicitud) throws DNIException, ParseException {

		this.dni = dni;
		this.estado = estado;
		this.saldo = saldo;
		this.interes = interes;
		this.tae = tae;
		this.comision = comision;
		this.fechaSolicitud = fechaSolicitud;
		this.documentos = new Documentos(new ArrayList<String>());

	}

	/**
	 * Constructor utilizado para instanciar objetos de esta clase desde MongoDB
	 * 
	 * @param fechaSolicitud
	 * @param fechaResolucion
	 * @param fechaFinalizacion
	 * @param saldo
	 * @param comision
	 * @param tae
	 * @param interes
	 * @param estado
	 * @param dni
	 * @param movimientos
	 * @param documentos
	 */
	@PersistenceConstructor
	public CuentaCorrienteDomain(Date fechaSolicitud, Date fechaResolucion, Date fechaFinalizacion, Double saldo,
			Double comision, Double tae, Double interes, String estado, Handler dni,
			List<MovimientoCuentaCorrienteDomain> movimientos, Documentos documentos) {
		this.fechaSolicitud = fechaSolicitud;
		this.fechaResolucion = fechaResolucion;
		this.fechaFinalizacion = fechaFinalizacion;
		this.saldo = saldo;
		this.comision = comision;
		this.tae = tae;
		this.interes = interes;
		this.estado = estado;
		this.dni = dni;
		this.movimientos = movimientos;
		this.documentos = documentos;
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

	public List<DocumentoAdjuntoDomain> getDocumentos() {
		// Este código sustituye a return documentos.getDocumentos() 
		
		Iterator iterator = documentos.createIterator();
		List<DocumentoAdjuntoDomain> listaDocs = new ArrayList<>();

		for (iterator.firstElement(); iterator.hasMoreElements(); iterator.nextElement()) {

			listaDocs.add((DocumentoAdjuntoDomain) iterator.currentElement());

		}
		return listaDocs;
	}

	// Se supone que van a enviar la documentación más adelante
	public Double realizarLiquidacion() {
		return null;
	}

	public String getId() {
		return id;
	}

}
