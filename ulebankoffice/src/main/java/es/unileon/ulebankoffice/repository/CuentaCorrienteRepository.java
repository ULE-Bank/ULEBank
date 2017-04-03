/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.CuentaCorrienteDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface CuentaCorrienteRepository extends MongoRepository<CuentaCorrienteDomain, String>{
	
		@Query("{'dni._id':?0}")
		public List<CuentaCorrienteDomain> findByDni(String dni);
	
}
