package at.fabianMaurutschek;

public class Mitarbeiter { // das solltet ihr können/kennen
	
	private String vorname;
	private String nachname;
	private int alter;
	private int gehalt;
	
	public Mitarbeiter(String nachname,String vorname, int alter, int gehalt) {
		setAlter(alter);
		setNachname(nachname);
		setVorname(vorname);
		setGehalt(alter);
	}

	
	
	public int getGehalt() {
		return gehalt;
	}

	public void setGehalt(int gehalt) {
		if(gehalt>0) this.gehalt = gehalt;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		if(vorname != null)this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		if(nachname != null) this.nachname = nachname;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		if(alter > 0)this.alter = alter;
	}

	public void ausgeben() {
		System.out.println(toString());
	}

	@Override //was ist @override?: Es wird "@override" gesetzt wenn man eine methode die schon existiert überschreiben will
	public String toString() {
		return "Mitarbeiter [vorname=" + vorname + ", nachname=" + nachname + ", alter=" + alter + ", gehalt=" + gehalt + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Mitarbeiter other = (Mitarbeiter) obj;
		return this.vorname == other.vorname && this.nachname == other.nachname;
	}
		
}
