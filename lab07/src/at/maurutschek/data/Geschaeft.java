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
	 * @throws Exception falls falscher oder garkein Input existiert
	 */
	public Geschaeft(String name, boolean stadt, int angestellete) throws Exception {
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
	 * @throws Exception falls der Name nichts oder null ist
	 */
	public void setName(String name) throws Exception {
		if(name.isEmpty() || name == null)
			throw new Exception("setName: Null or Empty" + this);
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
	 * @throws Exception falls angestallte weniger als 0 beträgt
	 */
	public void setAngestellete(int angestellete) throws Exception {
		if(angestellete < 0)
			throw new Exception("setAngestellete: Less than 0");
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
