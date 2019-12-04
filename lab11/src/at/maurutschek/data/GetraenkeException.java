/**
 * 
 */
package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab11
 *
 */
public class GetraenkeException extends RuntimeException{

	private static final long serialVersionUID = -1729225354128820929L;

	public GetraenkeException(String message){
		super(message);
	}

	public GetraenkeException(){
		super();
	}

	/**
	 * 
	 */
	public void ausgeben(){
		System.err.println(getMessage());
	}

}
