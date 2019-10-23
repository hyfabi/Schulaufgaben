package at.maurutschek.data;

public class Verwaltung {

	private GeschaeftListKnoten root;
	
	public static void main(String[] args) {
		Verwaltung v = new Verwaltung();
		v.addGeschaeft(new Lebensmittel(" ", true, 1, 'I'));
		v.addGeschaeft(new Lebensmittel(" ", false, 1,'F'));
		v.addGeschaeft(new Lebensmittel(" ", false, 1,'S'));
		v.addGeschaeft(new BioLaden(" ", false, 1, 2));
		v.addGeschaeft(new BioLaden(" ", true, 1, 1));
		v.addGeschaeft(new BioLaden(" ", false, 1, 1));
		v.addGeschaeft(new BioLaden(" ", false, 1, 1));
		System.out.println(v.summeFoerderungen());
		v.ausgeben();
		System.out.println();
	}

	
	public void addGeschaeft(Geschaeft g) {
		if(this.root == null) {
			this.root = new GeschaeftListKnoten(g);
			return;
		}
		GeschaeftListKnoten glk = this.root;
		while(glk.getNext() != null) {
			glk = glk.getNext();
		}
		
		glk.setNext(new GeschaeftListKnoten(g));
	}
	
	public int summeFoerderungen() {
		return (int) summeFoerderungen(this.root, 0);
	}
	
	private float summeFoerderungen(GeschaeftListKnoten glk, float ges) {
		if(glk.getNext() == null)
			return glk.getGeschaeft().getFoerderung();
		ges = glk.getGeschaeft().getFoerderung();
		return ges += summeFoerderungen(glk.getNext(), ges);
	}
	
	public void ausgeben() {
		if(this.root != null)
		ausgeben(this.root);
	}
	
	private void ausgeben(GeschaeftListKnoten glk) {
		glk.getGeschaeft().ausgeben();
		if(glk.getNext() == null)
			return;
		ausgeben(glk.getNext());
	}
	
}
