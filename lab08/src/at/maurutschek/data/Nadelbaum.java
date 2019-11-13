package at.maurutschek.data;

import java.time.LocalDate;

public class Nadelbaum extends Baum{
	
	private float preisProMeter;
	private float hoehe;
	private boolean christbaum;
	
	
	
	public Nadelbaum(String art, LocalDate datum, float preisProMeter, float hoehe, boolean christbaum) throws Exception {
		super(art, datum);
		setPreisProMeter(preisProMeter);
		setHoehe(hoehe);
		setChristbaum(christbaum);
	}

	@Override
	public float wert() {
		float s = preisProMeter * hoehe;
		if(christbaum)
			s*=2; 
		return s;
	}

	public float getPreisProMeter() {
		return preisProMeter;
	}

	public void setPreisProMeter(float preisProMeter) throws Exception {
		if(preisProMeter > 0)
			this.preisProMeter = preisProMeter;
		else
			throw new Exception();
	}

	public float getHoehe() {
		return hoehe;
	}

	public void setHoehe(float hoehe) throws Exception {
		if(hoehe > 0)
			this.hoehe = hoehe;
		throw new Exception();
	}

	public boolean isChristbaum() {
		return christbaum;
	}

	public void setChristbaum(boolean christbaum) {
		this.christbaum = christbaum;
	}

	//TODO Richtiges toString
	@Override
	public String toString() {
		return super.toString() + "Nadelbaum [preisProMeter=" + preisProMeter + ", hoehe=" + hoehe + ", christbaum=" + christbaum + "]";
	}

	public static Baum readNadelbaum(String baumString) throws NumberFormatException, Exception {
		String[] a = baumString.split(":");
		return new Nadelbaum(a[0], LocalDate.parse(a[1]), Float.parseFloat(a[2]), Float.parseFloat(a[3]), Boolean.parseBoolean(a[4]));
	}
	
}
