package es.unileon.ulebankoffice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.service.MongoDBDocument;

/**Interfaz repositorio para los documentos de mongo db
 * 
 * @author Razvi Razvan Raducu
 *
 */
public interface MongoDBDocumentsRepository extends MongoRepository<MongoDBDocument, String>{

}
