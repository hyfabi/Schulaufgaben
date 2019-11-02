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
	 * @throws Exception falls das Geschäft null ist
	 */
	public GeschaeftListKnoten(Geschaeft geschaeft, GeschaeftListKnoten next) throws Exception {
		setGeschaeft(geschaeft);
		setNext(next);
	}

	/**
	 * Konstruktor ohne das ein nächstes ELement verlnagt wird
	 * 
	 * @param g Geschäft
	 * @throws Exception falls das Geschäft null ist
	 */
	public GeschaeftListKnoten(Geschaeft g) throws Exception {
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
	 * @throws Exception falls das Geschäft null ist
	 */
	private void setGeschaeft(Geschaeft geschaeft) throws Exception {
		if(geschaeft == null)
			throw new Exception("setGeschaeft");
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
