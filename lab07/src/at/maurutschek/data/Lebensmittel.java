package at.maurutschek.data;

public class Lebensmittel extends Geschaeft {

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
		return "kategorie=" + this.kategorie;
	}

	public void ausgeben() {
		System.out.println("Lebensmittel [" + super.toString() + toString() + "]");
	}

	@Override
	public float getFoerderung() {
		float f = 0;
		if (this.angestellete == 0) {
			if (this.stadt)
				f += 200;
			return f;
		}

		f = getFoerderung(this.angestellete, 100);
		if (this.stadt)
			f += 200;
		return f;
	}

	private float getFoerderung(int anz, float f) {
		f *= 1.5f;
		anz--;
		if (anz == 0)
			return f;
		if (f >= 500)
			return 500f;
		return getFoerderung(anz, f);
	}
}
