/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.service.Documento;

/**
 * @author Razvan Raducu
 *
 */
public interface DocumentoRepository extends MongoRepository<Documento, String> {
	
}
