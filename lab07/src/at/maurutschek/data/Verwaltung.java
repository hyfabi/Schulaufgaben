package at.maurutschek.data;

/**
 * LAB07 - Virtualiesierung von Geschäften und einer Geschäfteverwaltung
 * Verwaltungsklasse + Main Fürs Verwalten von Geschäften
 * 
 * @author Fabian Maurutschek
 * @version Alpha 2.0
 */
public class Verwaltung {

	private GeschaeftListKnoten root;

	public static void main(String[] args) {
		Verwaltung v = new Verwaltung();

		v.addGeschaeft(new Lebensmittel(" ", true, 1, 'I'));
		v.addGeschaeft(new Lebensmittel(" ", false, 1, 'F'));
		v.addGeschaeft(new Lebensmittel(" ", false, 1, 'S'));
		v.addGeschaeft(new BioLaden(" ", false, 1, 2));
		v.addGeschaeft(new BioLaden(" ", true, 1, 1));
		v.addGeschaeft(new BioLaden(" ", false, 1, 1));
		v.addGeschaeft(new BioLaden(" ", false, 1, 1));
		System.out.println("summeFoerderungen(): " + v.summeFoerderungen());
		System.out.println("Ausgeben:");
		v.ausgeben();
	}

	/**
	 * Fügt ein Geschäft zur Liste hinzu
	 * 
	 * @param g Das Geschäft
	 */
	public void addGeschaeft(Geschaeft g) {
		if (this.root == null) {
			this.root = new GeschaeftListKnoten(g);
			return;
		}
		GeschaeftListKnoten glk = this.root;
		while (glk.getNext() != null) {
			glk = glk.getNext();
		}
		glk.setNext(new GeschaeftListKnoten(g));
	}

	/**
	 * Summiert die Forderungen aller Geschäfte
	 * 
	 * @return Gesamte Zahl an Forderungen
	 */
	public int summeFoerderungen() {
		return (int) summeFoerderungen(this.root, 0);
	}

	/**
	 * Hilfsmethode (wahre Methode) von summeFoerderungen()
	 */
	private float summeFoerderungen(GeschaeftListKnoten glk, float ges) {
		if (glk.getNext() == null)
			return glk.getGeschaeft().getFoerderung();
		ges = glk.getGeschaeft().getFoerderung();
		return ges += summeFoerderungen(glk.getNext(), ges);
	}

	/**
	 * Gibt alle Attribute von jedem EInzelnen geschäft aus
	 */
	public void ausgeben() {
		if (this.root != null)
			ausgeben(this.root);
	}

	/**
	 * Hilfsmethode (wahre Methode) von ausgeben()
	 */
	private void ausgeben(GeschaeftListKnoten glk) {
		glk.getGeschaeft().ausgeben();
		if (glk.getNext() == null)
			return;
		ausgeben(glk.getNext());
	}

}
