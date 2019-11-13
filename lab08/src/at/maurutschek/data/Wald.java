package at.maurutschek.data;

import java.util.ArrayList;
import java.util.List;

public class Wald {
	public List<Baum> baeume;

	public Wald() {
		this.baeume = new ArrayList<>();
	}
	
	public void pflanzeBaum(Baum b) {
		baeume.add(b);
	}
	
	public void obstbaumPflanzen(String s) {
		baeume.add(Obstbaum.readObstbaum(s));
	}
	
	public void nadelbaumPflanzen(String s) {
		try {
			baeume.add(Nadelbaum.readNadelbaum(s));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean baumFaellen(String art) {
		for(int i = 0; i < baeume.size(); i++)
			if(baeume.get(i).getArt().equals(art)) {
				baeume.remove(i);
				return true;
			}
		return false;
	}
	
	public float berechneWert() {
		float s = 0;
		for(int i = 0; i < baeume.size(); i++)
			s += baeume.get(i).wert();
		return s;
	}
	
	public void baeumeGruppiertAusgeben() {
		ArrayList<Baum> b = new ArrayList<>(baeume);
		Baum temp = null;  
		for(int i=0; i < b.size(); i++){
			for(int j=1; j < (b.size()-i); j++){  
				if(b.get(j-1).getDatum().isAfter(b.get(j).getDatum())){  
					temp = b.get(j-1);  
					b.set(j-1, b.get(j));
					b.set(j, temp);
					}
				}
			}
		for(int i=0; i < b.size(); i++)
			System.out.println(b.get(i));
		}
}
