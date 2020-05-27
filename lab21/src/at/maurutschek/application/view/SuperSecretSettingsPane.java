/**
 * 
 */
package at.maurutschek.application.view;

import at.maurutschek.application.controller.SuperSecretSettingsController;
import at.maurutschek.application.model.SuperSecretSettings;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class SuperSecretSettingsPane extends BorderPane{
	MyPane my;
	SuperSecretSettings sss;
	SuperSecretSettingsController sssc;
	public VBox vbox = new VBox(10);

	public SuperSecretSettingsPane(MyPane my){
		this.my = my;
		setRight(vbox);
		sss = new SuperSecretSettings(my);
		sssc = new SuperSecretSettingsController(my);
		init();
	}

	private void init(){
		setVisible(false);
		Label l1 = new Label("The Super Secret Settings!");
		l1.setFont(new Font(20));
		l1.setPadding(new Insets(70));
		setTop(l1);
		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		my.setRight(this);

		TranslateTransition tt = new TranslateTransition(Duration.millis(5000), this);
		tt.setByX(10);
		tt.setFromX(450);
		tt.setToX(0);
		tt.setOnFinished(x -> sss.start());
		tt.play();
		setVisible(true);
	}

}
