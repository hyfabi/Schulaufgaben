package at.maurutschek.data;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application{
	public static Pane p;

	ArrayList<MyCircle> allC = new ArrayList<>();

	public static void main(String[] args){
		launch(args);
	}

	class MyCircle extends Circle{
		private int r, g, b;
		private double iR, iG, iB;

		public MyCircle(){
			final int colorswitch = 2;

			Random rnd = new Random();
			r = rnd.nextInt(256);
			g = rnd.nextInt(256);
			b = rnd.nextInt(256);
			setFill(Color.rgb(r, g, b));

			iR = rnd.nextInt(colorswitch) + 1;
			iG = rnd.nextInt(colorswitch) + 1;
			iB = rnd.nextInt(colorswitch) + 1;

			if(rnd.nextBoolean())
				iR *= -1;
			if(rnd.nextBoolean())
				iG *= -1;
			if(rnd.nextBoolean())
				iB *= -1;
		}

		public void coloring(){
			if(r + iR >= 255 || r + iR <= 0)
				iR *= -1;
			if(g + iG >= 255 || g + iG <= 0)
				iG *= -1;
			if(b + iB >= 255 || b + iB <= 0)
				iB *= -1;
			r += iR;
			g += iG;
			b += iB;
			try{
				setFill(Color.rgb(r, g, b));
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void start(Stage primaryStage){
		p = new Pane();
		p.autosize();
		primaryStage.setTitle("");
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
		AnimationTimer t = new AnimationTimer(){

			@Override
			public void handle(long now){
				for(MyCircle c : allC){
					c.coloring();
				}

			}
		};

		Button b = new Button();
		b.setText("xD");
		b.setOnAction((x) -> {
			for(int i = 0; i < 1000; i++){
				MyCircle c = new MyCircle();
				c.setCenterX(Math.random() * 2000);
				c.setCenterY(Math.random() * 1000);
				c.setRadius(25);

				allC.add(c);

				t.start();

				c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
				p.getChildren().add(c);
			}
		});
		p.getChildren().add(b);

		CheckBox checkBox = new CheckBox("Check that!");
		checkBox.setLayoutY(550);
		checkBox.setLayoutX(550);
		p.getChildren().add(checkBox);

		ChoiceBox<String> cb = new ChoiceBox<String>(
					FXCollections.observableArrayList("Fabian ist nice"));
		cb.setLayoutX(655);
		cb.setLayoutY(655);
		p.getChildren().add(cb);

		TextField f = new TextField();
		f.setLayoutX(300);
		f.setLayoutY(300);
		p.getChildren().add(f);

		Line l = new Line();
		l.setStartX(300);
		l.setStartY(300);
		l.setEndX(100);
		l.setEndY(100);
		p.getChildren().add(l);

		Circle c = new Circle();
		c.setCenterX(100);
		c.setCenterY(100);
		c.setRadius(50);
		c.setFill(Color.HOTPINK);
		p.getChildren().add(c);

		Slider slider = new Slider();
		slider.setMin(0);
		slider.setMax(200);
		slider.setValue(140);
		slider.setLayoutX(700);
		slider.setLayoutY(300);
		p.getChildren().add(slider);

	}

}
