/**
 * 
 */
package at.maurutschek.data;

import java.time.LocalDate;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Zusatzaufgebe
 *
 */
public class Wort{
	private String inhalt;
	private int anzahl;
	private LocalDate datum;
	private Language sprache;

	public Wort(String inhalt, LocalDate datum, Language sprache){
		setInhalt(inhalt);
		setDatum(datum);
		setSprache(sprache);
		anzahl = 1;
	}

	public String getInhalt(){
		return inhalt;
	}

	public void setInhalt(String inhalt){
		if(inhalt != null && !inhalt.trim().isEmpty())
			this.inhalt = inhalt;
		else
			throw new WortException();
	}

	public int getAnzahl(){
		return anzahl;
	}

	public LocalDate getDatum(){
		return datum;
	}

	public void setDatum(LocalDate datum){
		if(datum.isBefore(LocalDate.now()))
			this.datum = datum;
		else
			throw new WortException();
	}

	public Language getSprache(){
		return sprache;
	}

	public void setSprache(Language sprache){
		this.sprache = sprache;
	}

}
