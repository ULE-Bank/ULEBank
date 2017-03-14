/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DireccionRepository extends MongoRepository<DireccionRepository, String> {

}
