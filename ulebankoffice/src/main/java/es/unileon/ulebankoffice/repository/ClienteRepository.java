/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.ClienteDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface ClienteRepository extends MongoRepository<ClienteDomain, String>{
	
		@Query("{'dni._id':?0}")
		public ClienteDomain findByDni(String dni);
		@Query(value="{'dni._id' : ?0}", delete = true)
		public void deleteByDni(String dni);
	
}
