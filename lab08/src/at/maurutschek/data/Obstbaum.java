package at.maurutschek.data;

import java.time.LocalDate;

public class Obstbaum extends Baum{

	private int ertrag;
	private float wertProKilo;
	
	public Obstbaum(String art, LocalDate datum, int ertrag, float wertProKilo) {
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
		return "Obstbaum [ertrag=" + ertrag + ", wertProKilo=" + wertProKilo + "]";
	}

	public int getErtrag() {
		return ertrag;
	}

	public void setErtrag(int ertrag) throws Exception {
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
	
	
	
}
