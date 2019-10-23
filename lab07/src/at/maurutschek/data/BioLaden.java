package at.maurutschek.data;

public class BioLaden extends Geschaeft{
	
	private int anzahlProdukte;
	
	public BioLaden(String name, boolean stadt, int angestellete, int anzahlProdukte) {
		super(name, stadt, angestellete);
		setAnzahlProdukte(anzahlProdukte);
	}

	public int getAnzahlProdukte() {
		return this.anzahlProdukte;
	}

	public void setAnzahlProdukte(int anzahlProdukte) {
		if (anzahlProdukte >= 0) {
			this.anzahlProdukte = anzahlProdukte;
		}
	}

	@Override
	public float getFoerderung() {
		if(this.stadt)
			return this.anzahlProdukte;
		else
			return this.anzahlProdukte*2;
	}

	@Override
	public String toString() {
		return " anzahlProdukte=" + this.anzahlProdukte;
	}

	@Override
	public void ausgeben() {
		System.out.println("BioLaden [" + super.toString() + toString() + "]");
	}
	
}