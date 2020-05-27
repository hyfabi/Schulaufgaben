package application.view;

import java.time.LocalDate;

import application.model.Mitarbeiter;
import application.model.Rang;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MyPane extends BorderPane{
	private Mitarbeiter ma = new Mitarbeiter("Max Muster", LocalDate.of(2001, 12, 17));
	private TextField tf = new TextField();
	private Label lb = new Label();
	private DatePicker dp = new DatePicker();
	public Label lbName = new Label("xx");
	public Label lbGebDat = new Label();
	public ComboBox<Rang> cb1 = new ComboBox<>();

	public MyPane(){
		init();
	}

	public void init(){
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10));
		gp.setHgap(10);
		gp.setVgap(10);
		gp.add(new Label("Name:"), 0, 0);
		gp.add(tf, 1, 0);
		gp.add(lbName, 2, 0);
		gp.add(new Label("GebDat"), 0, 1);
		gp.add(dp, 1, 1);
		gp.add(lbGebDat, 2, 1);

		cb1.getItems().addAll(Rang.values());

		gp.addRow(2, new Label("Rang"), cb1);

		ma.rangProperty().bindBidirectional(cb1.valueProperty());

		ToggleGroup tg = new ToggleGroup();
		RadioButton rb1 = new RadioButton("Männlich"), rb2 = new RadioButton("Weiblich"),
					rb3 = new RadioButton("Anderes");
		tg.getToggles().addAll(rb1, rb2, rb3);

		gp.addRow(3, new Label("Geschlecht"), rb1);
		gp.add(rb2, 1, 4);
		gp.add(rb3, 1, 5);

		Button b = new Button("Show");
		b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0){
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Mitarbeiter");
				alert.setContentText(ma.toString());
				alert.show();
			}

		});
		gp.add(b, 2, 2);

		tf.textProperty().bindBidirectional(ma.nameProperty());
		// ma.nameProperty().bindBidirectional(tf.textProperty());
		ma.gebDatProperty().bindBidirectional(dp.valueProperty());
		lbName.textProperty().bind(ma.nameProperty());
		lbGebDat.textProperty().bind(dp.valueProperty().asString());

		setCenter(gp);

	}

}
