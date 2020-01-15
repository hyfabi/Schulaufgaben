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
public class Skulptur extends Kunstwerk{
	private int volumen;
	private Material material;
	private int gewicht;

	public enum Material{
		GOLD, BRONZE, MARMOR, GLAS;
	}

	public int getVolumen(){
		return volumen;
	}

	public void setVolumen(int volumen){
		if(volumen > 0)
			this.volumen = volumen;
		else
			throw new IllegalArgumentException();
	}

	public Material getMaterial(){
		return material;
	}

	public int getGewicht(){
		return gewicht;
	}

	public void setGewicht(int gewicht){
		if(gewicht > 0)
			this.gewicht = gewicht;
		else
			throw new IllegalArgumentException();
	}

	public Skulptur(String titel,
					String kuenstler,
					LocalDate jahr,
					int volumen,
					Material material,
					int gewicht){
		super(titel, kuenstler, jahr);
		setVolumen(volumen);
		setGewicht(gewicht);
		this.material = material;
	}

	@Override
	public float transportkosten(){
		float sum = 0;
		sum += 2 * gewicht;
		if(material == Material.MARMOR || material == Material.GLAS)
			sum *= 1.05;
		return sum;
	}

	@Override
	public String toString(){
		return super.toString() + ";" + volumen + ";" + material + ";" + gewicht
					+ transportkosten();
	}

	public static Skulptur getSkulptur(String s){
		String a[] = s.split(";");
		if(a.length != 5)
			return new Skulptur(a[0], a[1], LocalDate.parse(a[2]), Integer.parseInt(a[3]),
						Material.valueOf(a[4]), Integer.parseInt(a[5]));
		throw new IllegalArgumentException();
	}

}