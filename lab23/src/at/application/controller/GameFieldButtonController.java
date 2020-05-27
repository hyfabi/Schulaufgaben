/**
 * 
 */
package at.application.controller;

import at.application.model.GameHandler;
import at.application.view.ButtonField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class GameFieldButtonController implements EventHandler<ActionEvent>{

	ButtonField gameField;
	GameHandler gh;

	public GameFieldButtonController(ButtonField gameField){
		this.gameField = gameField;
	}

	public void setGh(GameHandler gh){
		this.gh = gh;
	}

	@Override
	public void handle(ActionEvent event){
		gh.movement(((Button) (event.getSource())).getText());
	}

}
