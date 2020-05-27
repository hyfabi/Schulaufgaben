/**
 * 
 */
package application.controller;

import application.view.MyPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class Game implements EventHandler<ActionEvent>{
	MyPane my;
	int round;

	public Game(MyPane my){
		super();
		this.my = my;
	}

	@Override
	public void handle(ActionEvent event){
		round++;
		if(round % 2 == 0)
			my.mouseMove();
		if(round % 5 == 0)
			my.showmouse(true);
		my.showImage(((Button) (event.getSource())).getUserData(), my.getE().getKatze());
	}

}
