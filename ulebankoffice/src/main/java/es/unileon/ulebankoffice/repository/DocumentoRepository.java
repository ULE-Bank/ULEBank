/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.DocumentoAdjuntoDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DocumentoRepository extends MongoRepository<DocumentoAdjuntoDomain, String> {
	
//	public List<DocumentoAdjuntoDomain> findBySolicitudId(String solicitudId);
//	public List<DocumentoAdjuntoDomain> findByProductoFinancieroId(String productoFinancieroId);
//	@Query("{'dni._id':?0}")
//	public List<DocumentoAdjuntoDomain> findByDni(String id);
//	@Query("{'productId._id':?0}")
//	public List<DocumentoAdjuntoDomain> findByProductId(String id);
	
	public DocumentoAdjuntoDomain findById(String id);
	
}
