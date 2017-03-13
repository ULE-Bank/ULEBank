/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.service.Documento;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DocumentoRepository extends MongoRepository<Documento, String> {
	
}
