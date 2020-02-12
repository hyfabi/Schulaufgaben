package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			primaryStage.setMaximized(true);
// primaryStage.setOpacity(0.2);
			Pane root = new Pane();
			Scene scene = new Scene(root);
			primaryStage.getIcons().add(new Image("80d4f429-82ca-4caf-87ca-15b433b03b52.jpg"));

			TextField tf = new TextField("10");
			tf.setLayoutX(200);
			Button btn1 = new Button("Finished");
			btn1.setLayoutX(400);
			Slider s = new Slider(0, 50, 25);
			Pane p2 = new Pane();

			btn1.setOnAction((x) -> {
				paint(p2, s.getValue(), Integer.parseInt(tf.getText()));
			});

			root.getChildren().add(s);
			p2.setLayoutY(50);
			root.getChildren().addAll(p2, tf, btn1);

			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void paint(	Pane p2,
						double w,
						double n){
		p2.getChildren().clear();
		double y = 0;
		for(int i = 0; i < n; i++){
			for(int x = 0; x < n; x++){
				if(i % 2 == 1)
					y = w;
				else
					y = 0;

				if(x % 2 == 0){
					Rectangle r = new Rectangle(w, w);
					r.setFill(Color.BLACK);
					r.setX(x * w + y);
					r.setY(i * w + 30);
					p2.getChildren().add(r);
				}
			}
		}
	}

	public static void main(String[] args){
		launch(args);
	}
}
