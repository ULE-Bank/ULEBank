/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.service.Cliente;

/**
 * @author Razvan Raducu
 *
 */
public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
