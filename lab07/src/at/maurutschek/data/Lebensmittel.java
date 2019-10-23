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
		return "Lebensmittel [kategorie=" + this.kategorie + "]";
	}

	public void ausgeben() {
		System.out.println(toString());
	}

	@Override
	public float getFoerderung() {
		return getFoerderung(this.angestellete, 100);
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
