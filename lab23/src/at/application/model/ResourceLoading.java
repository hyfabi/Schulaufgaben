/**
 * 
 */
package at.application.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.Random;

import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class ResourceLoading{
	public static final int[] STARTABLE_FIELDS = { 112, 174, 13, 29, 117, 26, 53, 103, 132, 198,
				138, 94,
				34, 155, 50, 91, 197, 141 };

	public static int getRandomStartField(){
		Random rnd = new Random();
		return STARTABLE_FIELDS[rnd.nextInt(STARTABLE_FIELDS.length)];
	}

	public static Image[] getPlayerImages(int players){
		Image[] img = new Image[players];
		for(int i = 0; i < players; i++)
			img[i] = new Image(System.getProperty("user.dir") + "\\res\\figures\\" + i);
		return img;
	}

	public static void save(GameData gd){
		Dialog<ButtonType> d = new Dialog<>();
		d.setHeaderText("Wie?");
		ButtonType btn1 = new ButtonType("Automatisch Speichern");
		ButtonType btn2 = new ButtonType("Manuell Speichern");
		d.getDialogPane().getButtonTypes()
					.addAll(btn1, btn2);
		Optional<ButtonType> bt = d.showAndWait();
		if(bt.isPresent()){
			if(bt.get().getText() == "Automatisch Speichern"){
				File f = new File("res/saves/" + getLatestFileNumber());
				if(!f.exists()) try{
					f.createNewFile();
				}catch(IOException e){
					e.printStackTrace();
				}
				speichern(f, gd);
			}else{
				FileChooser fc = new FileChooser();
				speichern(fc.showSaveDialog(null), gd);
			}
		}
	}

	private static void speichern(	File f,
									GameData g){

		try{
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(g);
			oos.close();
			fos.close();
		}catch(IOException e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	private static int getLatestFileNumber(){
		return 1;
	}

	public static GameData[] lookupFiles(){
		File f = new File("res/saves");
		f.listFiles();
		ChoiceDialog<GameData> cd = new ChoiceDialog<>();

		return null;
	}

	public static GameData load(){
		return null;
	}
}
