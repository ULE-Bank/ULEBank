/**
 * 
 */
package es.unileon.ulebankoffice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.DocumentoAdjuntoDomain;
import es.unileon.ulebankoffice.service.DocumentoAdjunto;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DocumentoRepository extends MongoRepository<DocumentoAdjuntoDomain, String> {
	
//	public List<DocumentoAdjuntoDomain> findBySolicitudId(String solicitudId);
//	public List<DocumentoAdjuntoDomain> findByProductoFinancieroId(String productoFinancieroId);

}
