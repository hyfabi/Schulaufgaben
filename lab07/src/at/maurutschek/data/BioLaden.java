package at.maurutschek.data;

/**
 * Eine Art von Geschäft
 * 
 * @author Fabian Maurutschek
 *
 */
public class BioLaden extends Geschaeft {

	private int anzahlProdukte;

	/**
	 * Konstruktor
	 * 
	 * @param name Name des Geschäfts
	 * @param stadt Falls es sich in der Stadt befindet
	 * @param angestellete Anzahl von Angestellten
	 * @param anzahlProdukte Anzahl von Produkten
	 * @throws Exception falls falscher oder garkein Input existiert
	 */
	public BioLaden(String name, boolean stadt, int angestellete, int anzahlProdukte) throws Exception {
		super(name, stadt, angestellete);
		setAnzahlProdukte(anzahlProdukte);
	}

	/**
	 * Gibt die Anzahl von Produkten zurück
	 * 
	 * @return Anzahl von Produkten
	 */
	public int getAnzahlProdukte() {
		return this.anzahlProdukte;
	}

	/**
	 * Setzt die Anzahl von Produkten
	 * Darf nicht kleiner als 0 sein
	 * 
	 * @param anzahlProdukte Anzahl an Produkten
	 * @throws Exception falls anzahlProdukte kleiner als 0 ist
	 */
	public void setAnzahlProdukte(int anzahlProdukte) throws Exception {
		if (anzahlProdukte >= 0)
			this.anzahlProdukte = anzahlProdukte;
		else
			throw new Exception("setAnzahlProdukte: May not be smaller than 0");
	}
	
	/**
	 * Überschreiben von der getFoerderung() Methode
	 */
	@Override
	public float getFoerderung() {
		return this.stadt ? this.anzahlProdukte : this.anzahlProdukte * 2;
	}

	/**
	 * Überschreiben von der toString() Methode
	 */
	@Override
	public String toString() {
		return ", anzahlProdukte=" + this.anzahlProdukte;
	}

	/**
	 * Überschreiben von der ausgeben() Methode
	 */
	@Override
	public void ausgeben() {
		System.out.println("BioLaden [" + super.toString() + toString() + "]");
	}

}