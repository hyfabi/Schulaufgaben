package at.maurutschek.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Baum {
	private String art;
	private LocalDate datum;
	
	
	public Baum(String art, LocalDate datum) {
		setArt(art);
		setDatum(datum);
	}
	
	public abstract float wert();
	
	public String getArt() {
		return art;
	}
	
	public void setArt(String art) {
		if(!art.isEmpty() && art != null)
			this.art = art;
		else
			throw new NullPointerException();
	}
	
	public LocalDate getDatum() {
		return datum;
	}
	
	public void setDatum(LocalDate datum) {
		if(datum.isBefore(LocalDate.now()))
			this.datum = datum;
		else
			this.datum = LocalDate.now().minusYears(1);
	}
	
	//TODO Jahre zurückgeben
	public int altersUnterschied(Baum b) {
		int a = datum.compareTo(b.datum);
		if(a < 1)
			a*= -1;
		return a;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM y");
		String text = datum.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		return "Baum [art=" + art + ", datum=" + parsedDate + "]";
	}
	
	
	
}
