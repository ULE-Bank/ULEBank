/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.DocumentoAdjuntoDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DocumentoRepository extends MongoRepository<DocumentoAdjuntoDomain, String> {
	
	public DocumentoAdjuntoDomain findById(String id);
	
	public void deleteByIdIn(List<String> id);
	
	public List<DocumentoAdjuntoDomain> findByIdIn(List<String> id);
	
	public List<DocumentoAdjuntoDomain> findByIdInOrderByFechaCreacionAsc(List<String> id);
}
