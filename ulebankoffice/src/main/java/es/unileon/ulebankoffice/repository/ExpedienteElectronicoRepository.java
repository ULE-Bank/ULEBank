/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.ExpedienteElectronicoDomain;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Repository
public interface ExpedienteElectronicoRepository extends MongoRepository<ExpedienteElectronicoDomain, String>{

}
