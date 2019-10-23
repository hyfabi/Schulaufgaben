package at.maurutschek.data;

public class GeschaeftListKnoten {
	
	Geschaeft geschaeft;
	GeschaeftListKnoten next;
	
	public GeschaeftListKnoten(Geschaeft geschaeft, GeschaeftListKnoten next) {
		setGeschaeft(geschaeft);
		setNext(next);
	}
	
	public GeschaeftListKnoten(Geschaeft g) {
		setGeschaeft(g);
		setNext(null);
	}

	public Geschaeft getGeschaeft() {
		return this.geschaeft;
	}
	
	public void setGeschaeft(Geschaeft geschaeft) {
		this.geschaeft = geschaeft;
	}
	
	public GeschaeftListKnoten getNext() {
		return this.next;
	}
	
	public void setNext(GeschaeftListKnoten next) {
		this.next = next;
	}
	
}
