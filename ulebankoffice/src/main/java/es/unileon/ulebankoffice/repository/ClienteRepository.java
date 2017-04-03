/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.ClienteDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface ClienteRepository extends MongoRepository<ClienteDomain, String>{

		public List<ClienteDomain> findByDni(String dni);
	
}
