package at.application;

import at.application.view.RootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static final boolean EDITOR = false, DEBUG = true, LOCAL = true;
	public static final int PORT = 25565, SECUTITY_ID = 58375839;

	@Override
	public void start(Stage primaryStage){
		try{
			RootPane root = new RootPane();
			Scene scene = new Scene(root, 1920, 1000);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}
}
