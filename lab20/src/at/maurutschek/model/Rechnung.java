/**
 * 
 */
package at.maurutschek.model;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab20
 *
 */
public class Rechnung{
	private String sRechnung;
	private float ergebnis;

	public Rechnung(String sRechnung, float ergebnis){
		setsRechnung(sRechnung);
		setErgebnis(ergebnis);
	}

	public String getsRechnung(){
		return sRechnung;
	}

	public void setsRechnung(String sRechnung){
		this.sRechnung = sRechnung;
	}

	public float getErgebnis(){
		return ergebnis;
	}

	public void setErgebnis(float ergebnis){
		this.ergebnis = ergebnis;
	}

	@Override
	public String toString(){
		return "Rechnung [sRechnung=" + sRechnung + "]";
	}

}
