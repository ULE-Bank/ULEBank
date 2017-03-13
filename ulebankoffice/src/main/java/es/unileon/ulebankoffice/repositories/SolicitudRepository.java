/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.service.Solicitud;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Repository
public interface SolicitudRepository extends MongoRepository<Solicitud, String>{

}
