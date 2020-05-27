/**
 * 
 */
package at.maurutschek.view;

import at.maurutschek.model.MyCircle;
import at.maurutschek.model.MyRectangle;
import at.maurutschek.model.MyZeichnung;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import t.maurutschek.controller.MenuController;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab22.1
 *
 */
public class MyPane extends BorderPane{
	Pane p = new Pane();
	GridPane h = new GridPane();
	public TextArea ta = new TextArea();
	MenuBar m = new MenuBar();
	public MyZeichnung my = new MyZeichnung(ta);
	MenuController mc = new MenuController(this);

	public MyPane(){
		setCenter(p);
		setLeft(h);
		setBottom(ta);
		setTop(m);
		init();
	}

	private void init(){
		h.setPadding(new Insets(10));
		h.setHgap(5);
		h.setVgap(5);
		h.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		Menu me = new Menu("Start");
		m.getMenus().add(me);

		MenuItem mi1 = new MenuItem("Speicher in File"), mi2 = new MenuItem("Lies vom File"),
					mi3 = new MenuItem("Sortiere nach X"),
					mi4 = new MenuItem("Exit");
		mi1.setOnAction(mc);
		mi2.setOnAction(mc);
		mi3.setOnAction(mc);
		mi4.setOnAction(mc);
		me.getItems().addAll(mi1, mi2, mi3, mi4);

		ta.setEditable(false);
		ta.setMaxHeight(100);

		Button btn1 = new Button("Add Circle"), btn2 = new Button("Add Rectangle");

		h.add(new Label("X"), 0, 0);
		h.add(new Label("Y"), 0, 1);
		h.add(new Label("Radius"), 0, 2);
		h.add(new Label("Width"), 0, 3);
		h.add(new Label("Height"), 0, 4);
		h.add(new Label("Color"), 0, 5);
		h.add(btn1, 0, 6);

		TextField tf1 = new TextField(), tf2 = new TextField(), tf3 = new TextField(),
					tf4 = new TextField(), tf5 = new TextField();
		ColorPicker cp = new ColorPicker();

		h.add(tf1, 1, 0);
		h.add(tf2, 1, 1);
		h.add(tf3, 1, 2);
		h.add(tf4, 1, 3);
		h.add(tf5, 1, 4);
		h.add(cp, 1, 5);
		h.add(btn2, 1, 6);

		btn1.setOnAction(x -> {
			try{
				MyCircle mc1 = new MyCircle(cp.getValue(), Double.parseDouble(tf1.getText()),
							Double.parseDouble(tf2.getText()), Double.parseDouble(tf3.getText()));
				p.getChildren().add(mc1.paint());
				my.add(mc1);
			}catch(Exception e){
				ta.setText(ta.getText() + "\n Fehler: " + e.getMessage());
			}
		});
		btn2.setOnAction(x -> {
			try{
				MyRectangle mr = new MyRectangle(cp.getValue(), Double.parseDouble(tf1.getText()),
							Double.parseDouble(tf2.getText()), Double.parseDouble(tf4.getText()),
							Double.parseDouble(tf5.getText()));
				p.getChildren().add(mr.paint());
				my.add(mr);
			}catch(Exception e){
				ta.setText(ta.getText() + "\n Fehler: " + e.getMessage());
			}

		});
	}
}
