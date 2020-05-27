/**
 * 
 */
package at.maurutschek.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab20
 *
 */
public class RVerwaltung{
	private ArrayList<Rechnung> rechnungen;

	public RVerwaltung(){
		this.rechnungen = new ArrayList<>();
	}

	public void add(Rechnung r){
		if(r != null)
			rechnungen.add(r);
		else
			throw new RuntimeException();
	}

	public void sort(){
		rechnungen.sort(new Comparator<Rechnung>(){

			@Override
			public int compare(	Rechnung o1,
								Rechnung o2){
				return (int) (o2.getErgebnis() - o1.getErgebnis());
			}
		});
	}

	@Override
	public String toString(){
		String s = "";
		for(Rechnung r : rechnungen)
			s += r.getsRechnung() + "\n";
		return s;
	}
}
