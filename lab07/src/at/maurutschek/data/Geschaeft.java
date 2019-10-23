package at.maurutschek.data;

public abstract class Geschaeft {
	
	private String name;
	protected boolean stadt;
	protected int angestellete;
	
	
	public abstract float getFoerderung();

	

	public Geschaeft(String name, boolean stadt, int angestellete) {
		setAngestellete(angestellete);
		setName(name);
		setStadt(stadt);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStadt() {
		return this.stadt;
	}


	public void setStadt(boolean stadt) {
		this.stadt = stadt;
	}


	public int getAngestellete() {
		return this.angestellete;
	}


	public void setAngestellete(int angestellete) {
		this.angestellete = angestellete;
	}

	public void ausgeben() {
		System.out.println(toString() + "]");
	}
	
	@Override
	public String toString() {
		return "Geschaeft [name=" + this.name + ", stadt=" + this.stadt + ", angestellete=" + this.angestellete;
	}
	
}
