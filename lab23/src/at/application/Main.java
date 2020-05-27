package at.application;

import at.application.view.MyPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static final boolean EDITOR = false, DEBUG = true;

	@Override
	public void start(Stage primaryStage){
		try{
			MyPane root = new MyPane();
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
