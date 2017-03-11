/**
 * 
 */
package es.unileon.ulebankoffice.service;

/**
 * @author Razvi Razvan Raducu
 *
 */
public class DNIHandler implements Handler {
	
	private String id;
	
	public boolean compareTo(Handler handler) {
		// TODO Auto-generated method stub
		//return toString().equals(handler.toString());
		return this.equals(handler);
	}

	@Override
	public String toString(){
		return "id";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
