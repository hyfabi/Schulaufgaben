package at.maurutschek.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Obstbaum extends Baum{

	private float ertrag;
	private float wertProKilo;
	
	public Obstbaum(String art, LocalDate datum, float ertrag, float wertProKilo) {
		super(art, datum);
		this.ertrag = ertrag;
		this.wertProKilo = wertProKilo;
	}

	@Override
	public float wert() {
		float s = ertrag*wertProKilo;
		if(LocalDate.now().getYear() - getDatum().getYear() > 3 && LocalDate.now().getYear() - getDatum().getYear() < 10)
			s *= 1.1;
		return s;
	}

	//TODO Richtiges printen
	@Override
	public String toString() {
		return super.toString() + "Obstbaum [ertrag=" + ertrag + ", wertProKilo=" + wertProKilo + "]";
	}

	public float getErtrag() {
		return ertrag;
	}

	public void setErtrag(float ertrag) throws Exception {
		if(ertrag > 0)
			this.ertrag = ertrag;
		else
			throw new Exception();
	}

	public float getWertProKilo() {
		return wertProKilo;
	}

	public void setWertProKilo(float wertProKilo) throws Exception {
		if(wertProKilo > 0)
			this.wertProKilo = wertProKilo;
		else
			throw new Exception();
	}
	
	public static Obstbaum readObstbaum(String baumString) {
		String[] a = baumString.split(":");
		return new Obstbaum(a[0], LocalDate.parse(a[1], DateTimeFormatter.ofPattern("dd.MM.yyyy")), Float.parseFloat(a[2]), Float.parseFloat(a[3]));
	}
	
}
