/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.service.Solicitud;

/**
 * @author Razvi Razvan Raducu
 *
 */
public interface SolicitudRepository extends MongoRepository<Solicitud, String>{

}
