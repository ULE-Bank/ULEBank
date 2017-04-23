
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
	DocumentoRepository repo;

	public void addDocumento(DocumentoAdjuntoDomain documento) {
		//this.documentos.add(documento);
		repo.save(documento);
	}

	public List<DocumentoAdjuntoDomain> getDocumentos(List<String> idDocumentos) {
		
		return repo.findByIdIn(idDocumentos);
	}
	
public List<DocumentoAdjuntoDomain> getDocumentosByDateAsc(List<String> idDocumentos) {
		
		return repo.findByIdInOrderByFechaCreacionAsc(idDocumentos);
	}

}
