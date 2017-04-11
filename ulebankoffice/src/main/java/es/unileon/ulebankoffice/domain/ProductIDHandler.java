/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * @author Razvan Raducu
 *
 */
public class ProductIDHandler implements Handler{
	
	private String id;

	public ProductIDHandler(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}

	@Override
	public boolean compareTo(Handler handler) {
		// TODO Auto-generated method stub
		return toString().equals(handler.toString());
	}
	
	
	
}
