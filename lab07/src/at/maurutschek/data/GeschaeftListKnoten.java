package at.maurutschek.data;

/**
 * Diese Klasse wird für die Liste in Verwaltung benutzt
 * 
 * @author Fabian Maurutschek
 *
 */
public class GeschaeftListKnoten {

	Geschaeft geschaeft;
	GeschaeftListKnoten next;

	/**
	 * Konstruktor
	 * 
	 * @param geschaeft Geschäft
	 * @param next      Nächste Element
	 */
	public GeschaeftListKnoten(Geschaeft geschaeft, GeschaeftListKnoten next) {
		setGeschaeft(geschaeft);
		setNext(next);
	}

	/**
	 * Konstruktor ohne das ein nächstes ELement verlnagt wird
	 * 
	 * @param g Geschäft
	 */
	public GeschaeftListKnoten(Geschaeft g) {
		setGeschaeft(g);
		setNext(null);
	}

	/**
	 * Gibt das Geschäft zurück
	 * 
	 * @return Anzahl von Produkten
	 */
	public Geschaeft getGeschaeft() {
		return this.geschaeft;
	}

	/**
	 * Setzt das Geschäft
	 * 
	 * @param geschaeft Geschäft
	 */
	private void setGeschaeft(Geschaeft geschaeft) {
		this.geschaeft = geschaeft;
	}

	/**
	 * Gibt das Nächste Element zurück
	 * 
	 * @return Anzahl von Produkten
	 */
	public GeschaeftListKnoten getNext() {
		return this.next;
	}

	/**
	 * Setzt das nächste Element nach diesem in der Liste
	 * 
	 * @param next Nächste Element
	 */
	public void setNext(GeschaeftListKnoten next) {
		this.next = next;
	}

}
