/**
 * 
 */
package at.maurutschek.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab10
 *
 */
public class Schule{
	private HashMap<String, Schueler> schueler;

	public Schule(){
		schueler = new HashMap<>();
	}

	public String addSchueler(	String name,
								String klasse,
								ArrayList<Fach> ar){
		try{
			Schueler s = new Schueler(name, LocalDate.now().minusYears(11), klasse, ar);
			if(schueler.containsValue(s))
				return null;
			schueler.put(s.getSchluessel(), s);
			return s.getSchluessel();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public Schueler delSchueler(String schluessel){
		if(schueler.containsKey(schluessel)) return schueler.remove(schluessel);
		return null;
	}

	public Schueler getSchueler(String schluessel){
		return schueler.get(schluessel);
	}
}
