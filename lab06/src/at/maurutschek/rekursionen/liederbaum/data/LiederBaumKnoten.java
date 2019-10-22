package at.maurutschek.rekursionen.liederbaum.data;

/**
 * 
 * @author spamm
 *
 */
public class LiederBaumKnoten {
	private Lied l;
	private LiederBaumKnoten rechts;
	private LiederBaumKnoten links;

	/**
	 * 
	 * @param l
	 */
	public LiederBaumKnoten(Lied l) {
		setLied(l);
	}

	/**
	 * 
	 * @return
	 */
	public Lied getLied() {
		return this.l;
	}

	/**
	 * 
	 * @param l
	 */
	public void setLied(Lied l) {
		if (l != null)
			this.l = l;
	}

	/**
	 * 
	 * @return
	 */
	public LiederBaumKnoten getRechts() {
		return this.rechts;
	}

	/**
	 * 
	 * @param rechts
	 */
	public void setRechts(LiederBaumKnoten rechts) {
		this.rechts = rechts;
	}

	/**
	 * 
	 * @return
	 */
	public LiederBaumKnoten getLinks() {
		return this.links;
	}

	/**
	 * 
	 * @param links
	 */
	public void setLinks(LiederBaumKnoten links) {
		this.links = links;
	}

}
