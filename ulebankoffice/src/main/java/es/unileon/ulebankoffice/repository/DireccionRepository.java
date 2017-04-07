/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.DireccionDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DireccionRepository extends MongoRepository<DireccionDomain, String> {
	
	@Query("{'dni._id':?0}")
	public List<DireccionDomain> findByDni(String dni);
}
