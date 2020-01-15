/**
 * 
 */
package at.maurutschek.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab12
 *
 */
public class Wetterdaten{
	private ArrayList<Messwert> daten = new ArrayList<>();

	public void add(Messwert m){
		if(!daten.contains(m))
			daten.add(m);
	}

	public void del(Messwert m){
		daten.remove(m);
	}

	public void del(int jahr){
		Iterator<Messwert> it = daten.iterator();
		while(it.hasNext())
			if(it.next().getDatum().getYear() == jahr)
				it.remove();
	}

	public void save(File f) throws IOException{
		if(!f.exists())
			f.createNewFile();
		if(!f.isDirectory())
			throw new IOException("Is Directory unable to write");
		FileWriter fw = new FileWriter(f, true);
		for(Messwert m : daten)
			fw.append(m.toString());
		fw.close();

	}

	public void read(File f) throws IOException{
		if(!f.exists())
			return;
		if(!f.isDirectory())
			throw new IOException("Is Directory unable to read");
		Scanner s = new Scanner(f);
		while(s.hasNextLine())
			add(Messwert.getMesswert(s.nextLine()));
		s.close();
	}
}
