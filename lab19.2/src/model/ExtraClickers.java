package model;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab19.2
 *
 */
public enum ExtraClickers{
	JUNGE(0, 10, 1, false), ALABA(0, 100, 5, false),
	RONALDO(0, 1000, 50, false);

	private int anzahl, kosten;
	private double geld;
	private boolean enabled;

	private ExtraClickers(int anzahl, int kosten, double geld, boolean enabled){
		this.anzahl = anzahl;
		this.kosten = kosten;
		this.geld = geld;
		this.enabled = enabled;
	}

	public void increment(){
		anzahl++;
		geld *= 1.1;
		kosten *= 1.3;
	}

	public void setAnzahl(int anzahl){
		this.anzahl = anzahl;
	}

	public void setKosten(int kosten){
		this.kosten = kosten;
	}

	public void setGeld(double geld){
		this.geld = geld;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public int getAnzahl(){
		return anzahl;
	}

	public int getKosten(){
		return kosten;
	}

	public double getGeld(){
		return geld;
	}

	public boolean isEnabled(){
		return enabled;
	}

}
