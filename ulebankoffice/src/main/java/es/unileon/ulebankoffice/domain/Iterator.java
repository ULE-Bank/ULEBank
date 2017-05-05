/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * @author Razvan Raducu
 *
 */
public interface Iterator {

	/**
	 * Método que sitúa el puntero en el primer elemento de la colección.
	 */
	public void firstElement();

	/**
	 * Método que avanza el puntero al siguiente elemento de la colección.
	 */
	public void nextElement();

	/**
	 * @return True si el puntero actual (la posición con base 0 del elemento al
	 *         que apunta) es menor que el total de elementos de la coleccion
	 *         (getSize)
	 */
	public boolean hasMoreElements();

	/**
	 * @return Devuelve el elemento de la colección, su instancia, al que está
	 *         apuntando el puntero en el momento de su invocación.
	 *         <b>Importante no olvidar hacer cast al elemento que se esté
	 *         obteniendo. Este método devuelve un objeto de tipo Object
	 *         (superclase)</b>
	 */
	public Object currentElement();

}
