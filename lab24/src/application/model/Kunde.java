package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kunde extends Person{

	private ObservableList<Bestellung> bestellungen;
	private Art art;

	public Kunde(String name, LocalDate gebDat, Art art){
		super(name, gebDat);
		this.bestellungen = FXCollections.observableArrayList();
		this.art = art;
	}

	@Override
	public String toString(){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return art + " :" + name + ((art == Art.firma) ? " gegründet am "
					: " Geburtsdatum: " + gebDat.format(df));
	}

	public ObservableList<Bestellung> getBestellungen(){
		return bestellungen;
	}

	public void setBestellungen(ObservableList<Bestellung> bestellungen){
		this.bestellungen = bestellungen;
	}

	public Art getArt(){
		return art;
	}

	public void setArt(Art art){
		this.art = art;
	}

	public void addBestellung(Bestellung b){
		bestellungen.add(b);
	}

	public void delBestellungen(ObservableList<Bestellung> b){
		bestellungen.removeAll(b);
	}

	public void sortByArtikel(){
		bestellungen.sort((	o1,
							o2) -> o1.toString().compareTo(o2.toString()));
	}

	public void sortByAnzahl(){
		bestellungen.sort((	o1,
							o2) -> o1.getAnzahl() - o2.getAnzahl());
	}

	public void sortByDatum(){
		bestellungen.sort((	o1,
							o2) -> o1.getDatum().compareTo(o2.getDatum()));
	}

	public void speicherBestellungen(File dir){
		if(!dir.isDirectory())
			return;
		File file = new File(dir + "/" + name);
		try{
			if(!file.exists())
				file.createNewFile();

			FileOutputStream fos = new FileOutputStream(file, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Bestellung b : bestellungen)
				oos.writeObject(b);
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void liesBestellungen(File f){

		try{
			if(!f.exists())
				return;

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(ois.available() > 0)
				bestellungen.add((Bestellung) ois.readObject());
			ois.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
