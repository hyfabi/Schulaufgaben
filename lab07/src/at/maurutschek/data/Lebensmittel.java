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
	public void getFoerderung() {
		// TODO Auto-generated method stub
		
	}
}
