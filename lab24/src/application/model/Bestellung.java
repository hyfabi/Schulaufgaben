package application.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Bestellung implements Serializable{

	private static final long serialVersionUID = -8002901634254264874L;
	private String artikel;
	private int anzahl;
	private LocalDate datum;

	public Bestellung(String artikel, int anzahl, LocalDate datum){
		super();
		setArtikel(artikel);
		setAnzahl(anzahl);
		setDatum(datum);
	}

	@Override
	public String toString(){
		return artikel + "; " + anzahl + " Stück am " + datum;
	}

	public String getArtikel(){
		return artikel;
	}

	public void setArtikel(String artikel){
		if(artikel == null || artikel.trim().isEmpty())
			throw new IllegalArgumentException("Keine Artikelbezichnung eingegeben!");
		this.artikel = artikel;
	}

	public int getAnzahl(){
		return anzahl;
	}

	public void setAnzahl(int anzahl){
		if(anzahl <= 0)
			throw new IllegalArgumentException("Die Anzahl muss größer 0 sein!");
		this.anzahl = anzahl;
	}

	public LocalDate getDatum(){
		return datum;
	}

	public void setDatum(LocalDate datum){
		if(datum.isAfter(LocalDate.now().plusDays(1)))
			throw new IllegalArgumentException(
						"Das Bestellungsdatum kann nicht in der Zukunft liegen!");
		this.datum = datum;
	}

}
