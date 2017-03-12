/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.service.CuentaBancaria;

/**
 * @author Razvan Raducu
 *
 */
public interface CuentaBancariaRepository extends MongoRepository<CuentaBancaria, String>{

}
