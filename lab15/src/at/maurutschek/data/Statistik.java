package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab15
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Statistik{
	ArrayList<Parkgarage> garagen = new ArrayList<>();

	public Statistik(){
		garagen.add(new Parkgarage("Halbgasse", 89, 2.6f));
		garagen.add(new Parkgarage("Lugner City", 854, 1.6f));
		garagen.add(new Parkgarage("Stadthalle", 704, 2));
		garagen.add(new Parkgarage("GarageMAHü77", 234, 2.9f));
		garagen.add(new Parkgarage("Tiefgarage am Museumsquartier", 961, 2.5f));
		garagen.add(new Parkgarage("Kaiserstrasse", 135, 2.6f));
	}

	public void ausgeben(){
		for(Parkgarage p : garagen)
			System.out.println(p);
	}

	public void sortNachName(){
		garagen.sort((	x,
						y) -> {
			return x.getNamen().compareTo(y.getNamen());
		});

	}

	public void sortNachPlatz(){
		garagen.sort((	x,
						y) -> {
			return x.getAnzahl() - y.getAnzahl();
		});

	}

	public void sortNachKosten(){
		garagen.sort((	x,
						y) -> {
			return (int) (y.getPreis() - x.getPreis());
		});

	}

	public void speichereGaragen(File f){
		try{
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			for(Parkgarage p : garagen)
				ous.writeObject(p);
			ous.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void liesGaragen(File f){
		try{
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true){
				try{
					garagen.clear();
					garagen.add((Parkgarage) ois.readObject());
				}catch(Exception e){
					break;

				}
			}
			ois.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Statistik s = new Statistik();
		s.ausgeben();
		System.out.println(" **** Sortiere nach Garagenname aufsteigend ****");
		s.sortNachName();
		System.out.println(" **** Speichere sortiert nach Garagenname aufsteigend ****");
		s.speichereGaragen(new File("garagen.dat"));
		System.out.println(" **** Ausgabe sortiert nach Anzahl der Stehplätze absteigend ****");
		s.sortNachPlatz();
		s.ausgeben();
		System.out.println(" **** Ausgabe sortiert nach Kosten aufsteigend ****");
		s.sortNachKosten();
		s.ausgeben();
		System.out.println(" **** Lies sortiert nach Garagenname aufsteigend ****");
		s.liesGaragen(new File("garagen.dat"));
		System.out.println(" **** Ausgabe sortiert nach Garagenname aufsteigend ****");
		s.ausgeben();

	}

}
