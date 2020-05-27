/**
 * 
 */
package at.maurutschek.application.view;

import at.maurutschek.application.model.Score;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class Finished extends Stage{
	Main m;

	public Finished(Main m){
		this.m = m;
		BorderPane p = new BorderPane();
		Scene sc = new Scene(p);
		setScene(sc);

		setAlwaysOnTop(true);
		initPane();
	}

	public void showing(Score s){
		show();
	}

	/**
	 * 
	 */
	private void initPane(){
		Button btn1 = new Button("Nochmal"), btn2 = new Button("Aufhören");
		btn1.setOnAction(x -> Main.root.b.init());
		btn2.setOnAction(x -> {
			try{
				m.stop();
			}catch(Exception e){
				e.printStackTrace();
			}
		});
	}
}
