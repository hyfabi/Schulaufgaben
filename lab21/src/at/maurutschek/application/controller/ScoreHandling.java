package at.maurutschek.application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import at.maurutschek.application.model.Score;
import at.maurutschek.application.view.Main;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public abstract class ScoreHandling{

	public ArrayList<Score> scores = new ArrayList<>();

// public abstract ArrayList<Score> read1();

// public abstract void read1(ArrayList<Score> a);

	public ArrayList<Score> read(){
		ArrayList<Score> arr = new ArrayList<>();
		File f = chooser();
		if(f == null)
			return arr;
		try{
			FileInputStream fip = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fip);

			while(true){
				try{
					Object o = ois.readObject();
					if(o instanceof Score)
						arr.add((Score) o);
				}catch(Exception e){
					break;
				}
			}
			ois.close();
			fip.close();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		return arr;
	}

	public void write(ArrayList<Score> arr){
		File f = chooser();
		if(f == null)
			return;
		try{
			FileOutputStream fop = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			for(Score s : arr)
				oos.writeObject(s);
			oos.close();
			fop.close();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}

	}

	/**
	 * @return
	 */
	private File chooser(){
		FileChooser fj = new FileChooser();
		fj.setTitle("Bitte eine Datei auswählen");
		fj.getExtensionFilters().add(new ExtensionFilter("TextFiles", "*.log", "*.txt"));
		return fj.showOpenDialog(Main.scene.getWindow());
	}

	/**
	 * 
	 */
	public void write(){
	}

// public ArrayList<Score> read(String s){
// return null;
// }
//
// public void write( String s,
// ArrayList<Score> scores){
// File f = new File(s);
// if(f.exists())
//
// else
// f.createNewFile();
//
// }
}
