/**
 * 
 */
package application.controller;

import application.model.Einstellung;
import application.view.MyPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class Controller implements EventHandler<ActionEvent>{

	MyPane e;

	public Controller(MyPane e){
		this.e = e;
	}

	@Override
	public void handle(ActionEvent event){
		String x = "";
		if(event.getSource() instanceof MenuItem)
			x = (String) ((MenuItem) (event.getSource())).getUserData();
		else
			x = (String) ((Button) (event.getSource())).getUserData();
		switch(x){
			case "Maus":
				e.getE().setMaus();
			break;
			case "Katze":
				e.getE().setKatze();
			break;
			case "Gefangen":
				e.getE().setGefangen();
			break;
			case "Plan":
				e.getE().setPlan();
			break;
			case "Spiel":
				e.changeToSpiel();
			break;
			case "Einstellungen":
				e.changeToEinstellung();
			break;
			case "Add":
				e.getE().getE().add(new Einstellung(e.getTa().getText(), e.getS().getValue(),
							e.getE().getE().getAktE().getpM(), e.getE().getE().getAktE().getpK(),
							e.getE().getE().getAktE().getpG(), e.getE().getE().getAktE().getpP()));
			break;
			case "Update":
				Einstellung ein = e.getList().getSelectionModel().getSelectedItem();
				ein.setName(e.getE().getE().getAktE().clone().getName());
				ein.setOpacity(e.getE().getE().getAktE().clone().getOpacity());
				ein.setpG(e.getE().getE().getAktE().clone().getpG());
				ein.setpK(e.getE().getE().getAktE().clone().getpK());
				ein.setpM(e.getE().getE().getAktE().clone().getpM());
				ein.setpP(e.getE().getE().getAktE().clone().getpP());
				e.reload();
			break;
			case "Delete":
				e.getE().getE().del(e.getList().getSelectionModel().getSelectedItem());
			break;

		}
		e.reload();
	}

}
