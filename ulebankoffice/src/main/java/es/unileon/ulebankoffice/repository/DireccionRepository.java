/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.DireccionDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DireccionRepository extends MongoRepository<DireccionDomain, String> {

}
