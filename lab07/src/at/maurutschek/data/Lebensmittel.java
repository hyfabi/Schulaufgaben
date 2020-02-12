package at.maurutschek.data;

/**
 * Eine Art von Geschäft
 * 
 * @author Fabian Maurutschek
 *
 */
public class Lebensmittel extends Geschaeft {

	private char kategorie;

	/**
	 * Konstruktor
	 * 
	 * @param name         Name des Geschäfts
	 * @param stadt        Falls es sich in der Stadt befindet
	 * @param angestellete Anzahl von Angestellten
	 * @param kategorie    Die Kategorie des Geschäfts
	 * @throws Exception falls falscher oder garkein Input existiert
	 */
	public Lebensmittel(String name, boolean stadt, int angestellete, char kategorie) throws Exception {
		super(name, stadt, angestellete);
		setKategorie(kategorie);
	}

	/**
	 * Gibt die Kategorie des Geschäfts zurück
	 * 
	 * @return Kategorie
	 */
	public char getKategorie() {
		return this.kategorie;
	}

	/**
	 * Setzt die Kategorie eines Geschäfts
	 * 
	 * @param kategorie Kategorie
	 * @throws Exception falls keine richtige Ketegorie eingegeben wurde
	 */
	public void setKategorie(char kategorie) throws Exception {
		if (kategorie == 'I' || kategorie == 'F' || kategorie == 'S')
			this.kategorie = kategorie;
		else
			throw new Exception("False Input");
	}

	/**
	 * Überschreiben von der toString() Methode
	 */
	@Override
	public String toString() {
		return ", kategorie=" + this.kategorie;
	}

	/**
	 * Überschreiben von der ausgeben() Methode
	 */
	@Override
	public void ausgeben() {
		System.out.println("Lebensmittel [" + super.toString() + toString() + "]");
	}

	/**
	 * Überschreiben von der getFoerderung() Methode
	 */
	@Override
	public float getFoerderung() {
		float f = 0;
		if (this.stadt)
			f += 200;
		if (this.angestellete == 0)
			return f;
		f += getFoerderung(this.angestellete, 100);
		return f;
	}

	/**
	 * Hilfsmethode (wahre Methode) von getFoerderung()
	 */
	private float getFoerderung(int anz, float f) {
		anz--;
		if (anz == 0)
			return f;
		f *= 1.5f;
		if (f >= 500)
			return 500f;
		return getFoerderung(anz, f);
	}
}
