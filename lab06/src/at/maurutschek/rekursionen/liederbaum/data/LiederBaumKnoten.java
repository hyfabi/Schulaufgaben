package at.maurutschek.rekursionen.liederbaum.data;

public class LiederBaumKnoten {
	private Lied l;
	private LiederBaumKnoten rechts;
	private LiederBaumKnoten links;

	public LiederBaumKnoten(Lied l) {
		setLied(l);
	}

	public Lied getLied() {
		return this.l;
	}

	public void setLied(Lied l) {
		if (l != null)
			this.l = l;
	}

	public LiederBaumKnoten getRechts() {
		return this.rechts;
	}

	public void setRechts(LiederBaumKnoten rechts) {
		this.rechts = rechts;
	}

	public LiederBaumKnoten getLinks() {
		return this.links;
	}

	public void setLinks(LiederBaumKnoten links) {
		this.links = links;
	}

}
