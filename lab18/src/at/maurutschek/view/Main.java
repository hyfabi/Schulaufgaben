package at.maurutschek.view;

import at.maurutschek.view.panes.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage){
		try{
			MainPane root = new MainPane();
			Scene scene = new Scene(root, 800, 500);
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
