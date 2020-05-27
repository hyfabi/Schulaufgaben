/**
 * 
 */
package at.application.controller;

import at.application.Main;
import at.application.view.GameField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class MouseHandler implements EventHandler<MouseEvent>{

	GameField gameField;

	/**
	 * @param gameField
	 */
	public MouseHandler(GameField gameField){
		this.gameField = gameField;
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(MouseEvent event){
		if(Main.EDITOR){
			gameField.bf.bb.setLayoutX(event.getX());
			gameField.bf.bb.setLayoutY(event.getY());
			gameField.bf.bb.g.x = event.getX();
			gameField.bf.bb.g.y = event.getY();
		}
	}

}
