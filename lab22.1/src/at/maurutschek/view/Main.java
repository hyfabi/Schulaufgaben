package at.maurutschek.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			MyPane root = new MyPane();
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){

			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}

	/*
	 * Antworten: 1) event.getSorce() gibt das Objekt zurück 2)
	 */

}
