package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab16
 *
 */
public class MyPane extends Pane{

	private File f;

	public MyPane(File f){
		super();
		setF(f);

	}

	public File getF(){
		return f;
	}

	public void setF(File f){
		if(f != null && f.exists() && f.isFile()){
			this.f = f;
			init();
		}else{
			Label l = new Label("Das angegebene File wurde nicht gefunden!");
			l.setTextFill(Color.RED);
			getChildren().add(l);
		}
	}

	public void init(){
		readFile();
	}

	public void readFile(){
		Scanner s;
		try{
			s = new Scanner(f);
			while(s.hasNextLine())
				createObject(s.nextLine());
			s.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	public void createObject(String s){
		String a[] = s.split(",");
		switch(a[0]){
			case "Button":
				ImageView i = new ImageView(a[5]);
				i.setFitHeight(Integer.parseInt(a[2]));
				i.setFitWidth(Integer.parseInt(a[1]));
				Button b = new Button("", i);
				b.setLayoutX(Integer.parseInt(a[3]));
				b.setLayoutY(Integer.parseInt(a[4]));
				b.setMinHeight(Integer.parseInt(a[2]));
				b.setMaxWidth(Integer.parseInt(a[1]));
				getChildren().add(b);
			break;
			case "Label":
				Label l = new Label();
				if(a[1].contains(".")){
					ImageView i1 = new ImageView(a[1]);
					i1.setFitHeight(Integer.parseInt(a[3]));
					i1.setFitWidth(Integer.parseInt(a[2]));
					l.setGraphic(i1);
				}else
					l.setText(a[1]);
				l.setLayoutX(Integer.parseInt(a[4]));
				l.setLayoutY(Integer.parseInt(a[5]));
				l.setMinHeight(Integer.parseInt(a[3]));
				l.setMaxWidth(Integer.parseInt(a[2]));

				getChildren().add(l);
			break;
			case "TextField":
				TextField tf = new TextField();
				tf.setLayoutX(Integer.parseInt(a[3]));
				tf.setLayoutY(Integer.parseInt(a[4]));
				tf.setMaxHeight(Integer.parseInt(a[2]));
				tf.setMaxWidth(Integer.parseInt(a[1]));
				getChildren().add(tf);
			break;
		}
	}

}
