package at.maurutschek.application.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;

public class Main extends Application{
	public static Scene scene;
	public static final boolean DEBUG = false;
	public static MyPane root;
	private static Stage s;
	Finished f = new Finished(this);

	// TODO soviele static wie möglich entfernen

	@Override
	public void start(Stage primaryStage){
		try{
			root = new MyPane(primaryStage, f);
			scene = new Scene(root, 1200, 800, false, SceneAntialiasing.DISABLED);
			primaryStage.setScene(scene);
			primaryStage.show();
			s = primaryStage;
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}

	public static void setScene(Scene scene){
		s.setScene(scene);
	}
}