/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Repository
public interface PrestamoHipotecarioRepository extends MongoRepository<PrestamoHipotecarioRepository, String> {

}
