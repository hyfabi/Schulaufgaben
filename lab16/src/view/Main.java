package view;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			MyPane root = new MyPane(
						new File(System.getProperty("user.dir") + "\\res\\guiElements.txt"));
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setTitle("Ich mag Pizza!! ~Fabian");
			primaryStage.getIcons().add(new Image("1.jpg"));
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
}
