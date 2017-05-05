/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * Implementación concreta de la interface Iterator.
 * 
 * @author Razvan Raducu
 *
 */
public class ListIterator implements Iterator {

	private Aggregate aggregate;
	private int current;

	/**
	 * Constructor para instanciar la implementación concreta de la interface
	 * Iterator.
	 * 
	 * @param aggregate
	 *            Un objeto que implementa la interface Aggregate cuya colección
	 *            ha de iterarse, o sobre ella.
	 */
	public ListIterator(Aggregate aggregate) {
		this.aggregate = aggregate;
		current = 0;
	}

	@Override
	public void firstElement() {
		current = 0;
	}

	@Override
	public void nextElement() {
		current = current + 1;
	}

	@Override
	public boolean hasMoreElements() {
		return current < aggregate.getSize();
	}

	@Override
	public Object currentElement() {
		return aggregate.getElement(current);
	}
}
