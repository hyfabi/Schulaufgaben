/**
 * 
 */
package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import application.view.RootPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab26
 *
 */
public class Buisness{
	private ObservableList<Clothing> clothes = FXCollections
				.observableList(new ArrayList<Clothing>());

	RootPane rp;

	public Buisness(RootPane rp){
		this.rp = rp;
		mokup();
	}

	private void mokup(){
		clothes.add(new Clothing("A", Color.ALICEBLUE, LocalDate.now(), Size.M, true, 100));
		clothes.add(new Clothing("B", Color.BLACK, LocalDate.now(), Size.XL, false, 101));
	}

	public ObservableList<Clothing> getClothes(){
		return clothes;
	}

	public void add(Clothing c){
		if(!clothes.contains(c))
			clothes.add(c);
		else
			throw new RuntimeException();
		rp.lv.refresh();
	}

	public void save(){
		FileChooser fc = new FileChooser();
		fc.setTitle("Save to your File");
		File f = fc.showSaveDialog(null);
		if(f == null)
			return;
		try{
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Clothing cc : clothes){
				oos.writeObject(cc.getStoreable());
			}
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		rp.lv.refresh();
	}

	public void load(){
		FileChooser fc = new FileChooser();
		fc.setTitle("Open your File");
		File f = fc.showOpenDialog(null);
		if(f == null)
			return;
		try{
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try{
				while(true){
					clothes.add(new Clothing((StoreableClothing) ois.readObject()));
					System.out.println("lol");
				}
			}catch(Exception e){

			}
			ois.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		rp.lv.refresh();
	}

	/**
	 * 
	 */
	public void sort(){
		clothes.sort((	x,
						y) -> x.getBrand().get().compareTo(y.getBrand().get()));
	}

}
