package application;

import application.view.MyPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

public class Main extends Application{
	public static Game g = new Game();

	@Override
	public void start(Stage primaryStage){
		try{
			MyPane root = new MyPane();
			Scene scene = new Scene(root, 500, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		System.out.println(33 >>> 32);
		launch(args);
	}
}
