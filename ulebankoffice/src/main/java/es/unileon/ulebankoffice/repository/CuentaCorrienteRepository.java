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
public interface CuentaCorrienteRepository extends MongoRepository<CuentaCorrienteDomain, String> {

	/**
	 * Busca todas las cuentas corrientes asociadas a un determinado cliente
	 * 
	 * @param dni
	 *            del cliente cuyas cuentas corrientes se quieren obtener
	 * @return La lista de cuentas corrientes de ese cliente que tendrá 0
	 *         elementos en caso de no existir ninguna cuenta corriente
	 */
	@Query("{'dni._id':?0}")
	public List<CuentaCorrienteDomain> findByDni(String dni);

	/**
	 * Elimina todas las cuentas corrientes asociadas a un determinado cliente
	 * 
	 * @param dni
	 *            del cliente cuyas cuentas corrientes se quieren borrar
	 */
	@Query(value = "{'dni._id' : ?0}", delete = true)
	public void deleteByDni(String dni);

}
