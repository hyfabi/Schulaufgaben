/**
 * 
 */
package at.application.controller;

import java.io.File;
import java.io.FileWriter;

import at.application.Main;
import at.application.view.GameField;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class KeyHandler implements EventHandler<KeyEvent>{

	GameField gv;

	public KeyHandler(GameField gv){
		super();
		this.gv = gv;
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(KeyEvent event){
		if(Main.EDITOR)
			switch(event.getCode()){
			case W:
			gv.bf.bb.setLayoutY((gv.bf.bb.getLayoutY() - 1));
			gv.bf.bb.g.y -= 1;
			break;
			case A:
			gv.bf.bb.setLayoutX((gv.bf.bb.getLayoutX() - 1));
			gv.bf.bb.g.x -= 1;
			break;
			case S:
			gv.bf.bb.setLayoutY((gv.bf.bb.getLayoutY() + 1));
			gv.bf.bb.g.y += 1;
			break;
			case D:
			gv.bf.bb.setLayoutX((gv.bf.bb.getLayoutX() + 1));
			gv.bf.bb.g.x += 1;
			break;
			case UP:
			gv.bf.bb.setLayoutY((gv.bf.bb.getLayoutY() - 0.1));
			gv.bf.bb.g.y -= 0.1;
			break;
			case LEFT:
			gv.bf.bb.setLayoutX((gv.bf.bb.getLayoutX() - 0.1));
			gv.bf.bb.g.x -= 0.1;
			break;
			case DOWN:
			gv.bf.bb.setLayoutY((gv.bf.bb.getLayoutY() + 0.1));
			gv.bf.bb.g.y += 0.1;
			break;
			case RIGHT:
			gv.bf.bb.setLayoutX((gv.bf.bb.getLayoutX() + 0.1));
			gv.bf.bb.g.x += 0.1;
			break;
			case ENTER:
			storeButton();
			break;
			default:
			System.out.println(event.getCode());
			break;

			}
// System.out.println(gv.gf.bb.getLayoutX() + " " + gv.gf.bb.getLayoutY());
	}

	void storeButton(){
		System.out.println("Stored: " + gv.bf.bb);
		File f = new File("buttons.in");

		try{
			FileWriter fileWriter = new FileWriter(f, true);
			fileWriter.append(gv.bf.bb.g.toString() + "\n");
			fileWriter.close();
			gv.bf.bb.g.number++;
			gv.bf.bb.setText("" + gv.bf.bb.g.number);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
// try{
// FileOutputStream fos = new FileOutputStream(f, true);
// ObjectOutputStream oos = new ObjectOutputStream(fos);
// oos.writeObject(GameFieldButtonData.getCopyButton(gv.gf.bb.g));
// oos.close();
// fos.close();
// }catch(Exception e){
// System.out.println(e.getMessage());
// e.printStackTrace();
//
// }
// }

}
