/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.CuentaCorrienteDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface CuentaCorrienteRepository extends MongoRepository<CuentaCorrienteDomain, String>{

}
