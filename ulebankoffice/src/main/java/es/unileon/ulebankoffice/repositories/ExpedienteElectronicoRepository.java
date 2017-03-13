/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.service.ExpedienteElectronico;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Repository
public interface ExpedienteElectronicoRepository extends MongoRepository<ExpedienteElectronico, String>{

}
