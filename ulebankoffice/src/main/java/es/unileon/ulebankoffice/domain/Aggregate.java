/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * @author Razvan Raducu
 *
 */
public interface Aggregate {

	/**
	 * Crea y devuelve la instancia del iterador que se usará para moverse por
	 * la colección de la que esa clase Agregada es responsable.
	 * 
	 * @return La instancia del iterador concreto.
	 */
	Iterator createIterator();

	/**
	 * Método para obtener el tamaño de la colección sobre la que se itera.
	 * 
	 * @return Número de elementos de la colección.
	 */
	int getSize();

	/**
	 * Método para agregar un nuevo objeto a la colección de la que la clase
	 * Agregada es responable. Recibe como parámeto un objeto de tipo Object
	 * (superclase de Java) ya que esta es una interfaz, no una implementación
	 * concreta.
	 * 
	 * @param object
	 */
	void add(Object object);

	/**
	 * Método para eliminar un elemento de la colección. Se especifica el índice
	 * del elemento a borrar.
	 * 
	 * @param index
	 */
	void remove(int index);

	/**
	 * Método para obtener un elemento concreto de la colección. Se especifica
	 * el índice del elemento a obtener.
	 * 
	 * @param index
	 * @return El elemento del índica indicado. <b>Importante. No olvidar hacer
	 *         casting a la implementación concreta ya que aquí se devuelve un
	 *         objeto del tipo Object</b>
	 * @throws EmptyCollectionException
	 *             Se lanza la excepción cuando se trata de iterar sobre una
	 *             colección que tiene 0 elementos.
	 */
	Object getElement(int index) throws EmptyCollectionException;
}
