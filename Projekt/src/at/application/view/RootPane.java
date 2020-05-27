package at.application.view;

import java.util.Optional;

import at.application.Main;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23 Main Menu
 */
public class RootPane extends BorderPane{
	GameView gv;
	MainMenu m;
	static DebugPane dp = new DebugPane();

	public RootPane(){
		m = new MainMenu(this);
		setCenter(m);
	}

	public void startGame(){
		gv = null;
		Dialog<ButtonType> d = new Dialog<>();
		d.setHeaderText("Welche Siete?");
		ButtonType btn1 = new ButtonType("Detektiv");
		ButtonType btn2 = new ButtonType("Mr X.");
		d.getDialogPane().getButtonTypes()
					.addAll(btn1, btn2);
		Optional<ButtonType> bt = d.showAndWait();
		if(bt.isPresent())
			if(bt.get().getText() == "Detektiv")
				gv = new GameView(5, false, false);
			else
				gv = new GameView(5, false, true);
		setCenter(gv);
		if(Main.DEBUG)
			initDebugStage();
	}

	private void initDebugStage(){
		Stage s = new Stage();
		s.setAlwaysOnTop(true);
		Scene scene = new Scene(dp);
		s.setScene(scene);
		s.show();
	}

	public void backToMenu(){
		// TODO save
		setCenter(m);
	}

	public void onlineDialoge(){
		Alert a = new Alert(AlertType.NONE);
		a.getButtonTypes().addAll(new ButtonType("Lobby erstellen", ButtonData.APPLY),
					new ButtonType("Lobby beitreten", ButtonData.APPLY));
		Optional<ButtonType> o = a.showAndWait();
		if(o.isPresent())
			if(o.get().getText() == "Lobby erstellen")
				System.out.println("Lobby erstelen");
			else
				System.out.println("Lobby beitreten");
	}

}
