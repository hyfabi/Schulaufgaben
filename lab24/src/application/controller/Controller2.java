/**
 * 
 */
package application.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.Optional;

import application.model.Bestellung;
import application.model.Kunde;
import application.view.RootPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab24
 *
 */
public class Controller2 implements EventHandler<ActionEvent>{
	RootPane rp;

	public Controller2(RootPane rp){
		this.rp = rp;
	}

	@Override
	public void handle(ActionEvent event){
		String s = "";
		if(event.getSource() instanceof MenuItem)
			s = (String) ((MenuItem) (event.getSource())).getUserData();
		else
			s = (String) ((Node) (event.getSource())).getUserData();
		switch(s){
			case "name":
				rp.getLvKunden().getSelectionModel().getSelectedItem().sortByArtikel();
				reload();
			break;
			case "datum":
				rp.getLvKunden().getSelectionModel().getSelectedItem().sortByDatum();
				reload();
			break;
			case "anzahl":
				rp.getLvKunden().getSelectionModel().getSelectedItem().sortByAnzahl();
				reload();
			break;
			case "delete":
				delete();
			break;
			case "laden":
				FileChooser fc = new FileChooser();
				File f = fc.showOpenDialog(rp.getPrimaryStage());
				if(f != null)
					rp.getLvKunden().getSelectionModel().getSelectedItem()
								.liesBestellungen(f);
			break;
			case "speichern":
				FileChooser fc1 = new FileChooser();
				File f1 = fc1.showSaveDialog(rp.getPrimaryStage());
				if(f1 != null)
					rp.getLvKunden().getSelectionModel().getSelectedItem()
								.speicherBestellungen(f1);
			break;
			case "delBestellungen":
				delete();
			break;
			case "addBestellung":
				addBestellung();
			break;
		}

	}

	/**
	 * 
	 */
	private void delete(){
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Bestellung Löschen");
		a.setHeaderText("Sollen die folgenden Bestellungen wirklich gelöscht werden?");
		a.getButtonTypes().add(new ButtonType("Abbrechen"));
		if(rp.getLvBestellungen().getSelectionModel()
					.getSelectedItems().size() > 0)
			a.setContentText(rp.getLvBestellungen().getSelectionModel()
						.getSelectedItems() + "");
		else if(rp.getLvKunden().getSelectionModel().getSelectedItems().size() > 0)
			a.setContentText(rp.getLvKunden().getSelectionModel()
						.getSelectedItems() + "");
		Optional<ButtonType> o = a.showAndWait();
		if(o.isPresent())
			if(o.get() == ButtonType.OK){
				if(rp.getLvBestellungen().getSelectionModel()
							.getSelectedItems().size() > 0)
					rp.getLvKunden().getSelectionModel().getSelectedItem().getBestellungen()
								.removeAll(rp.getLvBestellungen().getSelectionModel()
											.getSelectedItems());
				else if(rp.getLvKunden().getSelectionModel().getSelectedItems().size() > 0)
					rp.getKv().getKunden()
								.removeAll(rp.getLvKunden().getSelectionModel().getSelectedItems());

			}else if(o.get().getText() == "Abbrechen")
				return;
		reload();
	}

	/**
	 * 
	 */
	private void addBestellung(){
		if(rp.getLvKunden().getSelectionModel().getSelectedItem() == null)
			return;
		Kunde k = rp.getLvKunden().getSelectionModel().getSelectedItem();
		Dialog<Bestellung> d = new Dialog<>();
		d.setTitle("Bestellung von "
					+ rp.getLvKunden().getSelectionModel().getSelectedItem().getName());
		GridPane gp = new GridPane();
		TextField tf1 = new TextField(), tf2 = new TextField();
		DatePicker dp = new DatePicker(LocalDate.now());
		gp.addRow(0, new Label("Artikelbezichnung"), tf1);
		gp.addRow(1, new Label("Anzahl"), tf2);
		gp.addRow(2, new Label("Datum"), dp);
		Label err = new Label();
		err.setTextFill(Color.RED);
		gp.addRow(3, err);
		GridPane.setColumnSpan(err, new Integer(2));
		ButtonType ok = new ButtonType("Okay"), ab = new ButtonType("Abbrechen");
		d.getDialogPane().getButtonTypes().addAll(ok, ab);
		d.getDialogPane().setContent(gp);
		d.setResultConverter(new Callback<ButtonType, Bestellung>(){
			@Override
			public Bestellung call(ButtonType b){
				try{
					if(b.getText() == "Okay"){
						if(tf1.getText().toUpperCase().equals(tf1.getText().toLowerCase()))
							throw new Exception("Bezeichnung sollte keine Zahl sein"); // IKnow
						return new Bestellung(tf1.getText(), Integer.parseInt(tf2.getText()),
									dp.getValue());
					}

				}catch(Exception e){
					if(e instanceof NumberFormatException)
						err.setText("Anzahl muss eine Zahl sein");
					else
						err.setText(e.getMessage());
				}
				if(b.getText() == "Abbrechen")
					d.close();
				return null;
			}
		});
		Optional<Bestellung> b = d.showAndWait();
		if(b.isPresent())
			rp.getLvKunden().getSelectionModel().getSelectedItem().addBestellung(b.get());
		reload();
		rp.getLvKunden().getSelectionModel().select(k);
	}

	/**
	 * 
	 */
	private void reload(){
		Kunde k1 = rp.getLvKunden().getSelectionModel().getSelectedItem();
		Bestellung b = rp.getLvBestellungen().getSelectionModel().getSelectedItem();
		rp.getLvBestellungen().getItems().clear();
		rp.getLvBestellungen().getItems().addAll(
					rp.getLvKunden().getSelectionModel().getSelectedItem()
								.getBestellungen());
		rp.getLvKunden().getItems().clear();
		for(Kunde k : rp.getKv().getKunden())
			if(k.getArt() == rp.getCb().getValue())
				rp.getLvKunden().getItems().add(k);
		rp.getLvKunden().getSelectionModel().select(k1);
		rp.getLvBestellungen().getSelectionModel().select(b);
	}
}
