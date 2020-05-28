/**
 * 
 */
package at.application.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import at.application.Main;
import at.application.controller.GameFieldButtonController;
import at.application.model.GameFieldButtonData;
import javafx.scene.layout.Pane;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */

public class ButtonField extends Pane{

	public GameFieldButton bb;

	private GameFieldButtonController gfbc = new GameFieldButtonController(this);

	private ArrayList<GameFieldButton> buttons = new ArrayList<>();

	public ArrayList<GameFieldButton> getButtons(){
		return buttons;
	}

	public GameFieldButtonController getGfbc(){
		return gfbc;
	}

	public ButtonField(){

		initGameField();
		if(Main.EDITOR)
			initEditorButton();
		checkButtons();

	}

	private void checkButtons(){
		for(GameFieldButton g : buttons){
			for(int i : g.g.tC){
				if(i != 0){
					boolean a = false;
					for(int x : buttons.get(i - 1).g.tC)
						if(x == g.g.number)
							a = true;
					if(!a)
						System.err.println(g.g.number + " " + buttons.get(i - 1).g.number);
				}
			}
			for(int i : g.g.bC){
				if(i != 0){
					boolean a = false;
					for(int x : buttons.get(i - 1).g.bC)
						if(x == g.g.number)
							a = true;
					if(!a)
						System.err.println(g.g.number + " " + buttons.get(i - 1).g.number);
				}
			}
			for(int i : g.g.uC){
				if(i != 0){
					boolean a = false;
					for(int x : buttons.get(i - 1).g.uC)
						if(x == g.g.number)
							a = true;
					if(!a)
						System.err.println(g.g.number + " " + buttons.get(i - 1).g.number);
				}
			}
		}

	}

	private void initEditorButton(){
		bb = new GameFieldButton(
					new GameFieldButtonData(100, 100, false, false, 1, new int[1], new int[1],
								new int[1]));
		bb.setText(buttons.get(buttons.size() - 1).g.number + 1 + "");
		bb.g.number = buttons.get(buttons.size() - 1).g.number + 1;
		getChildren().add(bb);
	}

	private void initGameField(){
		File f = new File("buttons.in");
		loadButtons(f);
		for(GameFieldButton g : buttons)
			g.setOnAction(gfbc);
		getChildren().addAll(buttons);
	}

	private void loadButtons(File f){
		try{
			Scanner s = new Scanner(f);
			while(s.hasNextLine()){
				GameFieldButtonData g = GameFieldButtonData.get(s.nextLine().trim());
				if(g != null)
					buttons.add(new GameFieldButton(g));
			}
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
