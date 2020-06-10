package at.application;

import at.application.view.RootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static final boolean EDITOR = false, DEBUG = false, LOCAL = true, DEBUG_NETWORK = false,
				SHOW_MESSAGES = false;
	public static final int PORT = 25565, SECUTITY_ID = 58375839;

	@Override
	public void start(Stage primaryStage){
		try{
			RootPane root = new RootPane(primaryStage);
			Scene scene = new Scene(root, 1920, 1000);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Scotlandyard");
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}
}
