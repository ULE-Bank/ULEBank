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
public interface Direccion extends MongoRepository<Direccion, String> {

}
