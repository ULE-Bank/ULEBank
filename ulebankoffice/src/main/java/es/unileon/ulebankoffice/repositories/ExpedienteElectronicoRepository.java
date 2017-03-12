/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.service.ExpedienteElectronico;

/**
 * @author Razvi Razvan Raducu
 *
 */
public interface ExpedienteElectronicoRepository extends MongoRepository<ExpedienteElectronico, String>{

}
