/**
 * 
 */
package at.maurutschek.data;

import java.io.Serializable;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab15
 *
 */
public class Parkgarage implements Serializable{
	private static final long serialVersionUID = -6430731859968629836L;

	private String namen;
	private int anzahl;
	private float preis;

	public String getNamen(){
		return namen;
	}

	public Parkgarage(String namen, int anzahl, float preis){
		setNamen(namen);
		setAnzahl(anzahl);
		setPreis(preis);
	}

	public void setNamen(String namen){
		if(namen != null && !namen.trim().isEmpty())
			this.namen = namen;
		else throw new RuntimeException();
	}

	public int getAnzahl(){
		return anzahl;
	}

	public void setAnzahl(int anzahl){
		if(anzahl > 10)
			this.anzahl = anzahl;
		else throw new RuntimeException();
	}

	public float getPreis(){
		return preis;
	}

	public void setPreis(float preis){
		if(preis > 0)
			this.preis = preis;
		else throw new RuntimeException();
	}

	@Override
	public String toString(){
		return "Parkgarage [namen=" + namen + ", anzahl=" + anzahl + ", preis=" + preis
					+ ", getNamen()=" + getNamen() + ", getAnzahl()=" + getAnzahl()
					+ ", getPreis()=" + getPreis() + "]";
	}

}
