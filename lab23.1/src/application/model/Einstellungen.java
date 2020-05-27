/**
 * 
 */
package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class Einstellungen{
	private Einstellung aktE;
	private ObservableList<Einstellung> einstellungen = FXCollections
				.observableList(new ArrayList<Einstellung>());

	public Einstellung getAktE(){
		return aktE;
	}

	public void add(Einstellung e){
		if(!einstellungen.contains(e))
			einstellungen.add(e);
	}

	public void del(Einstellung e){
		einstellungen.remove(e);
	}

	public void update(	Einstellung e1,
						Einstellung e2){
		for(int i = 0; i < einstellungen.size(); i++)
			if(einstellungen.get(i) == e2)
				einstellungen.set(i, e1);
	}

	public void setAktE(Einstellung aktE){
		this.aktE = aktE;
	}

	public ObservableList<Einstellung> getEinstellungen(){
		return einstellungen;
	}

	public Einstellungen(){
		aktE = new Einstellung();
	}

	public void load(File f){
		try{
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(ois.available() > 0)
				einstellungen.add((Einstellung) ois.readObject());
			ois.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void save(File f){
		try{
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Einstellung e : einstellungen)
				oos.writeObject(e);
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
