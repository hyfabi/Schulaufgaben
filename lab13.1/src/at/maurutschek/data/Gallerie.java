/**
 * 
 */
package at.maurutschek.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import at.maurutschek.data.Zeichnung.Technikart;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab13.1
 *
 */
public class Gallerie{
	private ArrayList<Kunstwerk> kunstwerke;

	public Gallerie(){
		kunstwerke = new ArrayList<>();
	}

	public ArrayList<Kunstwerk> getKunstwerke(){
		return kunstwerke;
	}

	public void sortNachKuenstler(){
		Collections.sort(kunstwerke, (	o1,
										o2) -> {
			return o1.getKuenstler().compareTo(o2.getKuenstler());
		});
	}

	public void sortNachJahr(){
		Collections.sort(kunstwerke, (	o1,
										o2) -> {
			return o1.getJahr().compareTo((o2.getJahr()));
		});
	}

	public void sortNachTransportkosten(){
		Collections.sort(kunstwerke, (	o1,
										o2) -> {
			return (int) (o1.transportkosten() - o2.transportkosten());
		});
	}

	public void ausgeben(){
		for(Kunstwerk k : kunstwerke)
			System.out.println(k);
	}

	public Kunstwerk verkaufeWerk(Kunstwerk k){
		return kunstwerke.remove(kunstwerke.indexOf(k));
	}

	public Kunstwerk kaufeWerk(Kunstwerk k){
		if(k == null || kunstwerke.contains(k))
			return null;
		kunstwerke.add(k);
		return k;
	}

	public void kaufeWerk(File f) throws IOException{
		if(!(f != null && f.exists() && f.canRead() && f.isFile()))
			throw new IOException();
		Scanner s = new Scanner(f);
		while(s.hasNextLine())
			kaufeWerk(getKunstwerk(s.nextLine()));
		s.close();
	}

	private Kunstwerk getKunstwerk(String s){
		String a[] = s.split(";");
		try{
			Integer.parseInt(a[a.length - 1]);
			return Skulptur.getSkulptur(s);
		}catch(NumberFormatException e){
		}

		try{
			Technikart.valueOf(a[a.length - 1]);
			return Zeichnung.getZeichnung(s);
		}catch(Exception e){
		}
		return null;
	}

}
