/**
 * 
 */
package at.maurutschek.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab12
 *
 */
public class Zamg{
	private HashMap<String, Wetterdaten> ortsWetter = new HashMap<>();

	// TODO schauen auf den 1ten Block ob optimierbar
	public Wetterdaten addWetterDaten(	String ort,
										Wetterdaten w){
		if(!ortsWetter.containsKey(ort)){
			ortsWetter.put(ort, w);
			return null;
		}
		return ortsWetter.replace(ort, w);
	}

	public void addWetterDaten(	String ort,
								File f){
		Wetterdaten temp = new Wetterdaten();
		try{
			temp.read(f);
		}catch(IOException e){
			e.printStackTrace();
		}
		addWetterDaten(ort, temp);
	}

	public void erweitereWetter(String ort,
								Messwert w){
		if(!ortsWetter.containsKey(ort))
			throw new IllegalArgumentException();
		ortsWetter.get(ort).add(w);
	}

	public void loeschen(int jahr){
		for(Wetterdaten w : ortsWetter.values())
			w.del(jahr);
	}

	public void save(	String ort,
						File f) throws IOException{
		if(!f.exists())
			f.createNewFile();
		if(!f.isDirectory())
			throw new IOException("Is Directory unable to write");
		FileWriter fw = new FileWriter(f, false);
		fw.write(ort);
		ortsWetter.get(ort).save(f);
		fw.close();
	}
}
