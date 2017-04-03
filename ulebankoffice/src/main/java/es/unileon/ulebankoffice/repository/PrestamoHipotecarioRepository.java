/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.PrestamoHipotecario;

/**
 * @author Razvan Raducu
 * 
 * @warning ESTA CLASE ESTÁ INCOMPLETA
 */
@Repository
public interface PrestamoHipotecarioRepository extends MongoRepository<PrestamoHipotecario, String> {

}
