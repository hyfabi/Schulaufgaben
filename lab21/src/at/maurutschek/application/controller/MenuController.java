package at.maurutschek.application.controller;

import at.maurutschek.application.view.Main;
import at.maurutschek.application.view.MyPane;
import at.maurutschek.application.view.SuperSecretSettingsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class MenuController implements EventHandler<ActionEvent>{
	private MyPane my;
	private int a = 0;

	public MenuController(MyPane my){
		this.my = my;
	}

	@Override
	public void handle(ActionEvent event){
		if(Main.DEBUG)
			System.out.println(event.getSource());
		MenuItem m = (MenuItem) event.getSource();
		switch(m.getText()){
			case "Länge":
				my.changeSpielFeld(true);
				my.g.aktTiltle();
			break;
			case "Breite":
				my.changeSpielFeld(false);
				my.g.aktTiltle();
			break;
			case "Color":
				my.g.changeColor();
			break;
			case "Benutzerangabe":
				my.g.changeName();
			break;
			case "Anzeigen":
				my.changeView();
				a++;
				if(a == 6)
					my.sssp = new SuperSecretSettingsPane(my);
			break;
			case "Lesen":
				my.sv.s.read1();
			break;
			case "Speichern":
				my.sv.s.write();
			break;
			default:
			break;
		}
	}

}
