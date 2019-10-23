package at.maurutschek.data;

/**
 * Wird verwendet um ein Geschäft zu virtualisieren
 * 
 * @author Fabian Maurutschek
 *
 */
public abstract class Geschaeft {

	private String name;
	protected boolean stadt;
	protected int angestellete;

	/**
	 * Forderung für jedes Geschäft
	 * Unterschiedlich nach Art
	 * 
	 * @return
	 */
	public abstract float getFoerderung();

	/**
	 * Konstruktor
	 * 
	 * @param name Name des Geschäfts
	 * @param stadt Falls es sich in der Stadt befindet
	 * @param angestellete Anzahl von Angestellten
	 */
	public Geschaeft(String name, boolean stadt, int angestellete) {
		setAngestellete(angestellete);
		setName(name);
		setStadt(stadt);
	}

	/**
	 * Gibt den Geschäftenamen zurück
	 * 
	 * @return Geschäftenamen
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setzt den Namen des Geschäfts
	 * 
	 * @param name Name des Geschäfts
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gibt zurück ob das Geschäft in der Stadt ist
	 * 
	 * @return Ja/Nein
	 */
	public boolean isStadt() {
		return this.stadt;
	}

	/**
	 * Setzt ob das Geschäft in der Stadt ist
	 * 
	 * @param stadt Ja/Nein
	 */
	public void setStadt(boolean stadt) {
		this.stadt = stadt;
	}

	/**
	 * Gibt die Anzahl an Angestellten zurück
	 * 
	 * @return Anzahl an Angestellten
	 */
	public int getAngestellete() {
		return this.angestellete;
	}

	/**
	 * Setzt die Anzahl an Angestellten
	 * 
	 * @param angestellete Anzahl an Angestellten
	 */
	public void setAngestellete(int angestellete) {
		this.angestellete = angestellete;
	}

	/**
	 * Gibt die Attribute zur Konsole aus
	 */
	public void ausgeben() {
		System.out.println("Geschaeft [" + toString() + "]");
	}

	/**
	 * Überschreiben von der toString() Methode
	 */
	@Override
	public String toString() {
		return "name=" + this.name + ", stadt=" + this.stadt + ", angestellete=" + this.angestellete;
	}

}
