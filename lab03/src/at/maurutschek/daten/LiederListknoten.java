package at.maurutschek.daten;

public class LiederListknoten {
	Lied lied;
	LiederListknoten next;
	
	
	
	public LiederListknoten(Lied lied, LiederListknoten next) {
		setLied(lied);
		setNext(next);
	}
	public Lied getLied() {
		return lied;
	}
	public void setLied(Lied lied) {
		this.lied = lied;
	}
	public LiederListknoten getNext() {
		return next;
	}
	public void setNext(LiederListknoten next) {
		this.next = next;
	}
	
	
}
