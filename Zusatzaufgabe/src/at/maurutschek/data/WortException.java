/**
 * 
 */
package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Zusatzaufgebe
 *
 */
public class WortException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8410755753925672844L;

	public WortException(String m){
		super(m);
	}

	public WortException(){
		super();
	}
}
