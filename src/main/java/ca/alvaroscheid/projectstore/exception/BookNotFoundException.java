/**
 * 
 */
package ca.alvaroscheid.projectstore.exception;

/**
 * @author alvaro-scheid
 *
 */
public class BookNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3975254668975072320L;
	private long id;

	public BookNotFoundException(long id) {
		super(String.format("Book is not found with id : '%s'", id));
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
}
