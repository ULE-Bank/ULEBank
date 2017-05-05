
package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import es.unileon.ulebankoffice.repository.DocumentoRepository;

/**
 * Clase agregada de DocumentoAdjuntoDomain. Se encarga de encapsular el
 * comportamiento del array de los documentos ya que es un elemento común a los
 * Clientes, los ProductosFunaniceros y las Solicitudes. De esta forma, todas
 * las clases anteriormente mencionadas delegan su manejor del array de
 * documentos a una instancia de esta clase.
 * 
 * @author Razvan Raducu
 *
 */
public class Documentos implements Aggregate {

	@Autowired
	private DocumentoRepository repo;

	@Id
	private String id;

	private List<String> idDocumentos;

	/**
	 * Método utilizad para instanciar Documentos desde la abse de datos y
	 * viceversa. También se utiliza la primera vez que se crea cualquier clase
	 * que utiliza la clase agregada Documentos ya que se pasa como parámetro un
	 * ArrayList vació.
	 * 
	 * @param idDocumentos
	 */
	@PersistenceConstructor
	public Documentos(List<String> idDocumentos) {
		this.idDocumentos = idDocumentos;
	}

	/**
	 * Método utilizado para guardar en la base de datos.
	 * 
	 * @param documento
	 *            El documento ya instanciado a guardar.
	 */
	@Override
	public void add(Object documento) {
			DocumentoAdjuntoDomain aux = (DocumentoAdjuntoDomain) documento;
			repo.save(aux);
	
		
		// Para obtener esta ID que es
		// automáticamente generada por MongoDB se debe hacer lo siguiente: 1-
		// Guardar el documento en el repositorio. 2- Obtener la ID después de
		// que se haya producido el guardado. Los TESTS dirán la verdad
		
		idDocumentos.add(aux.getId());
	}

//	/**
//	 * Método utilizado para obtener todos los documentos cuyas ids coinciden
//	 * con las asociadas al dni
//	 * 
//	 * @return La lista de los documentos encontrados
//	 */
//	public List<DocumentoAdjuntoDomain> getDocumentos() {
//
//		return repo.findByIdIn(idDocumentos);
//	}
//
//	/**
//	 * Devuelve la lista de documentos cuyas ids coinciden con las asociadas al
//	 * dni ordenada por fecha ascendentemente
//	 * 
//	 * @return La lista de los documentos encontrados ordenados por fecha
//	 *         ascendentemente
//	 */
//	public List<DocumentoAdjuntoDomain> getDocumentosByDateAsc() {
//
//		return repo.findByIdInOrderByFechaCreacionAsc(idDocumentos);
//	}

	@Override
	public Object getElement(int index) {
		return repo.findById(idDocumentos.get(index));
	}

	@Override
	public Iterator createIterator() {
		return new ListIterator(this);
	}

	@Override
	public int getSize() {
		return idDocumentos.size();
	}

	@Override
	public void remove(int index) {
		repo.delete(idDocumentos.get(index));
		idDocumentos.remove(index);
	}

	@Override
	public String toString() {
		return "Documentos [repo=" + repo + ", id=" + id + ", idDocumentos=" + idDocumentos + "]";
	}

}
