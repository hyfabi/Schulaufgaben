/**
 * 
 */
package at.maurutschek.exceptions;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab12
 *
 */
public class WetterException extends RuntimeException{
	private static final long serialVersionUID = -5414542659123332800L;
	private Fehlertyp fehlertyp;

	public WetterException(String massage, Fehlertyp fehlertyp){
		super(massage);
		setFehlertyp(fehlertyp);
	}

	public WetterException(Fehlertyp fehlertyp){
		super();
		setFehlertyp(fehlertyp);
	}

	public Fehlertyp getFehlertyp(){
		return fehlertyp;
	}

	public void setFehlertyp(Fehlertyp fehlertyp){
		if(fehlertyp != null)
			this.fehlertyp = fehlertyp;
		else
			throw new RuntimeException();
	}

}
