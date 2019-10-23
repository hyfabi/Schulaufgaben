package at.maurutschek.data;

public class Lebensmittel extends Geschaeft{

	private char kategorie;

	public Lebensmittel(String name, boolean stadt, int angestellete, char kategorie) {
		super(name, stadt, angestellete);
		setKategorie(kategorie);
	}

	public char getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(char kategorie) {
		if (kategorie == 'I' || kategorie == 'F' || kategorie == 'S')
			this.kategorie = kategorie;
	}

	@Override
	public String toString() {
		return "kategorie=" + this.kategorie + "]";
	}

	public void ausgeben() {
		System.out.println(super.toString() + toString());
	}

	@Override
	public float getFoerderung() {
		float f = 100;
		if(this.stadt)
			f += 200;
		return getFoerderung(this.angestellete, f);
	}
	
	private float getFoerderung(int anz, float f) {
		if(anz == 0)
			return f;
		if(f >= 500)
			return 500f;
		anz--;
		return (float) (f*1.5);
	}
}
