/**
 * 
 */
package application.controller;

import application.view.RootPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab26
 *
 */
public class MenuController implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event){
		switch(((MenuItem) (event.getSource())).getText()){
			case "Add":
				rp.add();
			break;
			case "Del":
				rp.del();
			break;
			case "Save":
				rp.b.save();
			break;
			case "Load":
				rp.b.load();
			break;
			case "Sort":
				rp.b.sort();
			break;
		}
	}

	RootPane rp;

	public MenuController(RootPane rp){
		super();
		this.rp = rp;
	}

}
