/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.SolicitudDomain;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Repository
public interface SolicitudRepository extends MongoRepository<SolicitudDomain, String>{

}
