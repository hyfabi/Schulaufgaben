/**
 * 
 */
package at.application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class MenuController implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event){
		MenuItem mi = (MenuItem) event.getSource();
		switch(mi.getText()){

		}
	}

}
