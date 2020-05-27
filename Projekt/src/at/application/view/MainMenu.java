package at.application.view;

import at.application.model.ResourceLoading;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class MainMenu extends BorderPane{

	RootPane myPane;

	public MainMenu(RootPane myPane){
		this.myPane = myPane;
		init();
	}

	/**
	 * 
	 */
	private void init(){
		setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.3),
					new CornerRadii(30), null)));
		setPadding(new Insets(30));
		VBox h = new VBox(10);

		Button btn1 = new Button("Neues Spiel");
		btn1.setFont(new Font("Arial", 100));
		btn1.setTextFill(Color.ROYALBLUE);
		btn1.setBackground(new Background(
					new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10), null)));
		btn1.setOnMouseEntered(x -> {
			btn1.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.7), new CornerRadii(10),
									null)));
		});
		btn1.setOnMouseExited(x -> {
			btn1.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10),
									null)));
		});

		Button btn3 = new Button("Spiel Laden");
		btn3.setFont(new Font("Arial", 60));
		btn3.setTextFill(Color.ROYALBLUE);
		btn3.setBackground(new Background(
					new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10), null)));
		btn3.setOnMouseEntered(x -> {
			btn3.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.7), new CornerRadii(10),
									null)));
		});
		btn3.setOnMouseExited(x -> {
			btn3.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10),
									null)));
		});

		Button btn2 = new Button("Spiel Beenden");
		btn2.setFont(new Font("Arial", 60));
		btn2.setTextFill(Color.ROYALBLUE);
		btn2.setBackground(new Background(
					new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10), null)));
		btn2.setOnMouseEntered(x -> {
			btn2.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.7), new CornerRadii(10),
									null)));
		});
		btn2.setOnMouseExited(x -> {
			btn2.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10),
									null)));
		});

		Button btn4 = new Button("Online");
		btn4.setFont(new Font("Arial", 60));
		btn4.setTextFill(Color.ROYALBLUE);
		btn4.setBackground(new Background(
					new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10), null)));
		btn4.setOnMouseEntered(x -> {
			btn3.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.7), new CornerRadii(10),
									null)));
		});
		btn4.setOnMouseExited(x -> {
			btn3.setBackground(new Background(
						new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(10),
									null)));
		});

		btn1.setOnAction(x -> {
			myPane.startGame();
		});

		btn2.setOnAction(x -> {
			Platform.exit();
		});

		btn3.setOnAction(x -> ResourceLoading.lookupFiles());

		btn4.setOnAction(x -> myPane.onlineDialoge());

		h.getChildren().addAll(btn1, btn3, btn2, btn4);

		Label l = new Label("Scotland Yard");
		l.setFont(new Font("Times New Roman", 250));
		l.setTextFill(Color.WHEAT);
		setTop(l);
		setLeft(h);
	}

}
