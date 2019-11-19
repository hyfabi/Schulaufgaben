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
			throw new RuntimeException();
	}
	
	public LocalDate getDatum() {
		return datum;
	}
	
	public void setDatum(LocalDate datum) {
		if(datum.isBefore(LocalDate.now()) || datum.isEqual(LocalDate.now()))
			this.datum = datum;
		else
			throw new RuntimeException();
	}
	
	public int altersUnterschied(Baum b) {
		int a = Math.abs(datum.compareTo(b.datum));
		if(datum.getMonthValue()>5)
			a++;
		return a;
	}

	@Override
	public String toString() {
		return "Baum [art=" + art + ", datum=" + datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "]";
	}
	
	
	
}
