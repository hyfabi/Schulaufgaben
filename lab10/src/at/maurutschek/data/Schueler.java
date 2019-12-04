package at.maurutschek.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab10
 *
 */
public class Schueler{
	private String name;
	private LocalDate gebDatum;
	private String klasse;
	private List<Fach> faecher;

	public Schueler(String name, LocalDate gebDatum, String klasse, List<Fach> faecher){
		setName(name);
		setKlasse(klasse);
		setFaecher(faecher);
		setGebDatum(gebDatum);
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		if(name != null && !name.trim().isEmpty() && name.trim().split(" ").length == 2)
			this.name = name;
		else
			throw new IllegalArgumentException("Falscher Name");
	}

	public LocalDate getGebDatum(){
		return gebDatum;
	}

	public void setGebDatum(LocalDate gebDatum){
		if(gebDatum.isBefore(LocalDate.now().minusYears(10)))
			this.gebDatum = gebDatum;
		else
			throw new IllegalArgumentException("Zu jung oder Falsche eingabe");
	}

	public String getKlasse(){
		return klasse;
	}

	public void setKlasse(String klasse){
		if(klasse != null && !klasse.trim().isEmpty())
			this.klasse = klasse;
		else
			throw new IllegalArgumentException("Fehler bei Klasse");
	}

	public List<Fach> getFaecher(){
		return faecher;
	}

	public void setFaecher(List<Fach> faecher){
		if(faecher != null && faecher.size() >= 3)
			this.faecher = faecher;
		else
			throw new IllegalArgumentException("Falsche Feacherzuweisung");
	}

	public float avarage(){
		float a = 0;
		for(Fach f : faecher){
			if(f.getNote() == 0)
				return 0;
			a += f.getNote();
		}
		return a / faecher.size();
	}

	// TODO: Kompliziert
	public Collection<Fach> besteFaecher(){
		int x = 6;
		for(Fach f : faecher)
			if(f.getNote() < x && f.getNote() != 0)
				x = f.getNote();
		if(x == 6)
			x = 0;
		Collection<Fach> c = new ArrayList<>();
		for(Fach f : faecher)
			if(f.getNote() == x)
				c.add(f);
		return c;
	}

	public Fach loescheFach(Fach f){
		if(f == null)
			throw new NullPointerException();
		if(!faecher.contains(f))
			return null;
		faecher.remove(f);
		return f;
	}

	@Override
	public String toString(){
		return "Schueler [name=" + name + ", gebDatum=" + gebDatum + ", klasse=" + klasse
					+ ", faecher=" + faecher + "]";
	}

	public String getSchluessel(){
		return name + " " + klasse;
	}

}