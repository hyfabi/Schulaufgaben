/**
 * 
 */
package at.maurutschek.data;

import java.time.LocalDate;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab13.1
 *
 */
public class Zeichnung extends Kunstwerk{

	private int laenge, breite;
	private Technikart technik;

	public enum Technikart{
		Aquarell, ÖL, Acryl;
	}

	@Override
	public float transportkosten(){
		int sum = (breite * laenge / 10000) * 30;
		if(breite / 100 > 3 || laenge / 100 > 3)
			sum += 20;
		return sum;

	}

	public Zeichnung(	String titel,
						String kuenstler,
						LocalDate jahr,
						int laenge,
						int breite,
						Technikart technik){
		super(titel, kuenstler, jahr);
		setLaenge(laenge);
		setBreite(breite);
		this.technik = technik;
	}

	public int getLaenge(){
		return laenge;
	}

	public void setLaenge(int laenge){
		if(laenge > 0)
			this.laenge = laenge;
		else
			throw new IllegalArgumentException();
	}

	public int getBreite(){
		return breite;
	}

	public void setBreite(int breite){
		if(breite > 0)
			this.breite = breite;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public String toString(){
		return super.toString() + ";" + laenge + ";" + breite + ";" + technik + ";"
					+ transportkosten();
	}

	public static Zeichnung getZeichnung(String s){
		String a[] = s.split(";");
		if(a.length != 5)
			return new Zeichnung(a[0], a[1], LocalDate.parse(a[2]), Integer.parseInt(a[3]),
						Integer.parseInt(a[4]), Technikart.valueOf(a[5]));
		throw new IllegalArgumentException();
	}

}
