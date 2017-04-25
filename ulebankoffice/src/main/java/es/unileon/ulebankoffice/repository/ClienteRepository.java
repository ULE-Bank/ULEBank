/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.ClienteDomain;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface ClienteRepository extends MongoRepository<ClienteDomain, String> {

	/**
	 * Se encarga de obtener de la base de datos el cliente
	 * 
	 * @param dni
	 *            del cliente a buscar
	 * @return El objeto ClienteDomain instanciado o null en caso de no existir
	 *         un cliente con el dni especificado
	 */
	@Query("{'dni._id':?0}")
	public ClienteDomain findByDni(String dni);

	/**
	 * Borra de la base de datos el cliente
	 * 
	 * @param dni
	 *            del cliente a borrar
	 */
	@Query(value = "{'dni._id' : ?0}", delete = true)
	public void deleteByDni(String dni);

}
