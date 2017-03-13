/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.service.CuentaBancaria;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface CuentaBancariaRepository extends MongoRepository<CuentaBancaria, String>{

}
