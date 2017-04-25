
package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.unileon.ulebankoffice.repository.DocumentoRepository;

/**
 * Clase agregada de DocumentoAdjuntoDomain. Se encarga de encapsular el
 * comportamiento del array de los documentos ya que es un elemento común a los
 * Clientes, los ProductosFunaniceros y las Solicitudes. De esta forma, todas
 * las clases anteriormente mencionadas delegan su manejor del array de
 * documentos a una instancia de esta clase.
 * 
 * @author Razvan Raducu
 *
 */
public class Documentos {

	@Autowired
	private DocumentoRepository repo;

	/**
	 * Método utilizado para guardar en la base de datos.
	 * 
	 * @param documento
	 *            El documento ya instanciado a guardar.
	 */
	public void addDocumento(DocumentoAdjuntoDomain documento) {
		repo.save(documento);
	}

	/**
	 * Método utilizado para obtener todos los documentos cuyas ids coinciden
	 * con las especificadas como parámetro
	 * 
	 * @param idDocumentos
	 *            Lista de ids de documentos a obtener
	 * @return La lista de los documentos encontrados
	 */
	public List<DocumentoAdjuntoDomain> getDocumentos(List<String> idDocumentos) {

		return repo.findByIdIn(idDocumentos);
	}

	/**
	 * Devuelve la lista de documentos cuyas ids coinciden con las epsecificadas
	 * como parámetro ordenada por fecha ascendentemente
	 * 
	 * @param idDocumentos
	 *            Lista de ids de documentos a obtener
	 * @return La lista de los documentos encontrados ordenados por fecha ascendentemente
	 */
	public List<DocumentoAdjuntoDomain> getDocumentosByDateAsc(List<String> idDocumentos) {

		return repo.findByIdInOrderByFechaCreacionAsc(idDocumentos);
	}
	
}
