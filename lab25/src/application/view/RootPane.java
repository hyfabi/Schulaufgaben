/**
 * 
 */
package application.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab25
 *
 */
public class RootPane extends BorderPane{

	ListView<Integer> l;
	GridPane gp = new GridPane();
	Slider s1 = new Slider(), s2 = new Slider();
	Rectangle r = new Rectangle(100, 100);
	ColorPicker cp = new ColorPicker();
	ComboBox<Integer> cb1 = new ComboBox<>(), cb2 = new ComboBox<>();
	Pane p = new Pane();

	public RootPane(){
		init();
		setBottom(gp);
		setLeft(p);
		setRight(l);
	}

	private void init(){
		initComponents();
		initGrid();
	}

	private void initComponents(){

		p.getChildren().add(r);

		for(int i = 0; i < 200; i++){
			cb1.getItems().add(i + 1);
			cb2.getItems().add(i + 1);
		}
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0; i < 365; i++)
			a.add(i + 1);
		l = new ListView<>(FXCollections.observableList(a));
		r.rotateProperty().bind(l.getSelectionModel().selectedItemProperty());
		l.setPrefWidth(100);
	}

	private void initGrid(){
		gp.addRow(0, new Label("Breite"), s1, new Label("Breite"), s2);
		gp.addRow(1, cp);
		GridPane.setColumnSpan(cp, 2);
		gp.addRow(2, new Label("X:"), cb1, new Label("Y:"), cb2);
		s1.valueProperty().bindBidirectional(r.widthProperty());
		s2.valueProperty().bindBidirectional(r.heightProperty());
		r.xProperty().bind(cb1.valueProperty());
		r.yProperty().bind(cb2.valueProperty());
		r.fillProperty().bind(cp.valueProperty());

	}

}
