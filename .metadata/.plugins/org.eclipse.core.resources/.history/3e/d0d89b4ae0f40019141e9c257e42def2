package at.maurutschek.rekursionen.liederbaum.data;

import java.io.File;
import java.util.Random;

/**
 * Lab 02 POS: Lied-Lied ist eine Liedklasse welche Lieder attribute verwendet
 * Zweck: Keine Ahnung (null)
 * 
 * @author Fabian Maurutschek
 */
public class Lied {
	private String titel;
	private String interpret;
	private File file;
	private long laenge;

	/**
	 * @param titel: Titel vom Lied
	 * @param interpret: Macher des Liedes
	 * @param file: File wo das Lied gespeichert
	 * @param laenge: Laenge das liebes
	 */
	public Lied(String titel, String interpret, String file, long laenge) {
		setTitel(titel);
		setInterpret(interpret);
		setFile(file);
		setLaenge(laenge);
	}

	/**
	 * Konsturktor: default
	 */
	public Lied() {
		setTitel("7 Rings");
		setInterpret("lol xD");
		setFile("C:");
		setLaenge(429);
	}

	/**
	 * Konsturktor
	 * 
	 * @param titel
	 * @param interpret
	 */
	public Lied(String titel, String interpret) {
		setTitel(titel);
		setInterpret(interpret);
		setLaenge(0);
		setFile("C:");
	}

	/**
	 * @return Titel das Lieds
	 */
	public String getTitel() {
		return this.titel;
	}

	/**
	 * @param titel: Darf nicht null/leer sein
	 */
	public void setTitel(String titel) {
		if (titel != null && !titel.isEmpty()) {
			this.titel = titel;
		} else {
			this.titel = "unkown";
		}
	}

	/**
	 * 
	 * @return interpret
	 */
	public String getInterpret() {
		return this.interpret;
	}

	/**
	 * @param interpret: NUR Vor und nachname in einem String
	 */
	public void setInterpret(String interpret) {// Nur vor und nachname!!
		String[] s = interpret.split(" ");
		if (s.length > 2 || s.length < 2) {
			this.interpret = "unkown";
			return;
		}
		setInterpret(s[0], s[1]);
	}

	/**
	 * 
	 * @param vorname: Vorname des Machers
	 * @param nachname: Nachname des Machers
	 */
	private void setInterpret(String vorname, String nachname) {
		if (vorname != null && nachname != null) {
			this.interpret = vorname + " " + nachname.toUpperCase();
		} else {
			this.interpret = "unkown";
		}
	}

	/**
	 * @return file
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * 
	 * @return Laenge des Files
	 */
	public long getFileLaenge() {
		if (this.file.exists())
			return this.file.length();
		return 0;
	}

	/**
	 * 
	 * @param file: File wo das Lied gespeichert ist (Keine URI!)
	 */
	public void setFile(String file) {
		if (file != null) {
			this.file = new File(file);
		}
	}

	/**
	 * @return laenge
	 */
	public long getLaenge() {
		return this.laenge;
	}

	/**
	 * @param laenge: Muss mehr als 0 beinhalten, ansonsten wird eine Random Zahl
	 *        zwischen 100-500 genutzt
	 */
	public void setLaenge(long laenge) {
		if (laenge > 0) {
			this.laenge = laenge;
		} else {
			Random rnd = new Random();
			this.laenge = rnd.nextInt(400) + 101;
		}
	}

	/**
	 * ToString halt
	 */
	@Override
	public String toString() {
		long m = this.laenge / 60; // Für Minuten
		long s = this.laenge % 60;// Für Sekunden
		if (s < 10) {
			return "\"" + this.titel + "\" von " + this.interpret + " abgespeichert im \"" + this.file + "\" (Dauer: " + m
					+ ":0" + s + ")";
		}
		return "\"" + this.titel + "\" von " + this.interpret + " abgespeichert im \"" + this.file + "\" (Dauer: " + m + ":"
				+ s + ")";
	}

	/**
	 * Gibt den Text von toString() zur Konsole aus
	 */
	public void ausgeben() {
		System.out.println(toString());
	}

}
