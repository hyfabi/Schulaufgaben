/**
 * 
 */
package at.maurutschek.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab20
 *
 */
public class MainPane extends BorderPane{

	private FlowPane mainFlowPane;

	public MainPane(){
		mainFlowPane = new FlowPane(10, 10);
		init1();
		init2();

	}

	private void init2(){
		setCenter(mainFlowPane);
		mainFlowPane.autosize();
		mainFlowPane.setPadding(new Insets(10));
	}

	public void init1(){

		MenuBar mb = new MenuBar();
		Menu m1 = new Menu("File"), m2 = new Menu("Ergebnis");
		mb.getMenus().addAll(m1, m2);
		setTop(mb);

		Button bw1 = new Button("", new ImageView(new Image("1.png", 100, 100, true, true))),
					bw2 = new Button("", new ImageView(new Image("2.png", 100, 100, true, true))),
					bw3 = new Button("", new ImageView(new Image("2.png", 100, 100, true, true))),
					b1 = new Button("+"),
					b2 = new Button("-"),
					b3 = new Button("*");

		bw1.setPrefWidth(100);
		bw1.setPrefHeight(100);

		b1.setPrefWidth(100);
		b1.setPrefHeight(100);
		b2.setPrefWidth(100);
		b2.setPrefHeight(100);
		b3.setPrefWidth(100);
		b3.setPrefHeight(100);

		FlowPane h1 = new FlowPane(10, 0, bw1, bw2, bw3);

		FlowPane h2 = new FlowPane(10, 0, b1, b2, b3);
		h2.setAlignment(Pos.CENTER);

		TextArea ta = new TextArea();
		ta.setMaxHeight(100);
		setBottom(ta);

		mainFlowPane.getChildren().addAll(h1, h2);
	}

}
