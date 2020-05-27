/**
 * 
 */
package t.maurutschek.controller;

import java.io.File;

import at.maurutschek.view.MyPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab22.1
 *
 */
public class MenuController implements EventHandler<ActionEvent>{
	MyPane p;

	public MenuController(MyPane p){
		this.p = p;
	}

	@Override
	public void handle(ActionEvent event){
		try{
			String x = "";
			if(event.getSource() instanceof MenuItem)
				x = ((MenuItem) event.getSource()).getText();
			switch(x){
				case "Speicher in File":
					p.my.save(filechooser());
				break;
				case "Lies vom File":
					p.my.read(filechooser());
				break;
				case "Sortiere nach X":
					p.my.sortByX();
				break;
				case "Exit":
					Platform.exit();
				break;
			}
		}catch(Exception e){
			p.ta.setText(p.ta.getText() + "\n Fehler: " + e.getMessage());
		}

	}

	public File filechooser(){
		FileChooser fc = new FileChooser();
		return fc.showOpenDialog(null);
	}

}
