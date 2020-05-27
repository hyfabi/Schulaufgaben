package application.view;

import java.io.File;

import application.controller.Controller;
import application.controller.Controller2;
import application.model.Art;
import application.model.Bestellung;
import application.model.Kunde;
import application.model.Kundenverwaltung;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootPane extends BorderPane{

	private Kundenverwaltung kv = new Kundenverwaltung();
	private ListView<Kunde> lvKunden = new ListView<>(kv.getKunden());
	private ListView<Bestellung> lvBestellungen = new ListView<>();
	private Stage primaryStage;
	private Label lKundenBestellung = new Label("Bestellungen von ... :");
	private Controller c;
	private Controller2 c2;
	private ComboBox<Art> cb;

	public ComboBox<Art> getCb(){
		return cb;
	}

	public Kundenverwaltung getKv(){
		return kv;
	}

	public ListView<Kunde> getLvKunden(){
		return lvKunden;
	}

	public ListView<Bestellung> getLvBestellungen(){
		return lvBestellungen;
	}

	public Stage getPrimaryStage(){
		return primaryStage;
	}

	public Label getlKundenBestellung(){
		return lKundenBestellung;
	}

	public Controller getC(){
		return c;
	}

	public RootPane(Stage primaryStage){
		c = new Controller(this);
		c2 = new Controller2(this);
		this.primaryStage = primaryStage;
		lvKunden = new ListView<>();
		lvKunden.setPrefWidth(350);
		lvBestellungen.setPrefWidth(400);
		init();
	}

	public void init(){
		initMenu();
		initKundenverwaltung();
	}

	public void initMenu(){
		MenuBar mb = new MenuBar();
		Menu mKunde = new Menu("Kunde");
		MenuItem miSpeichern = new MenuItem("Speichern");
		miSpeichern.setUserData("speichern");
		miSpeichern.setOnAction(c2);
		MenuItem miLaden = new MenuItem("Laden");
		miLaden.setUserData("laden");
		miLaden.setOnAction(c2);
		MenuItem miDelBestellungen = new MenuItem("Bestellungen entfernen");
		miDelBestellungen.setUserData("delBestellungen");
		miDelBestellungen.setOnAction(c2);
		MenuItem miAddBestellung = new MenuItem("Bestellung hinzufügen");
		miAddBestellung.setUserData("addBestellung");
		miAddBestellung.setOnAction(c2);
		mb.getMenus().addAll(mKunde);
		mKunde.getItems().addAll(miAddBestellung, miDelBestellungen, miSpeichern, miLaden);
		setTop(mb);
	}

	public File getDir(){
		// Erg�nzen - gibt ein Directory zur�ck
		return null;
	}

	public File getFile(){
		// Erg�nzen - gibt ein File zur�ck
		return null;
	}

	public void initKundenverwaltung(){
		lvKunden.addEventHandler(MouseEvent.MOUSE_CLICKED, c);
		HBox hb = new HBox();
		hb.setPadding(new Insets(20));
		hb.setSpacing(10);

		HBox hbKunden = new HBox();
		cb = new ComboBox<>();
		cb.getItems().add(Art.privatkunde);
		cb.getItems().add(Art.firma);
		cb.getItems().add(Art.premium);
		cb.getSelectionModel().selectedItemProperty().addListener(c);
		hbKunden.setPadding(new Insets(10));
		hbKunden.setSpacing(10);
		hbKunden.getChildren().addAll(new Label("Kunden:     Filter:"), cb);

		VBox vbKunden = new VBox();
		vbKunden.getChildren().addAll(hbKunden, lvKunden);

		ToggleGroup tg = new ToggleGroup();
		RadioButton rb1 = new RadioButton("...nach Namen");
		RadioButton rb2 = new RadioButton("...nach Datum");
		RadioButton rb3 = new RadioButton("...nach Anzahl");
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);
		rb1.setUserData("name");
		rb2.setUserData("datum");
		rb3.setUserData("anzahl");
		rb1.setOnAction(c2);
		rb2.setOnAction(c2);
		rb3.setOnAction(c2);

		VBox vbSortiert = new VBox();
		lvBestellungen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		vbSortiert.getChildren().addAll(new Label("Sortiert..."), rb1, rb2, rb3);

		HBox hbSortDel = new HBox();
		Button bDelete = new Button("Löschen");
		bDelete.setUserData("delete");
		bDelete.setOnAction(c2);

		hbSortDel.getChildren().addAll(vbSortiert, bDelete);
		hbSortDel.setPadding(new Insets(20));
		hbSortDel.setSpacing(40);
		hbSortDel.setAlignment(Pos.CENTER);

		VBox vbBestellungen = new VBox();
		vbBestellungen.getChildren().addAll(lKundenBestellung, lvBestellungen, hbSortDel);

		hb.getChildren().addAll(vbKunden, vbBestellungen);
		setCenter(hb);

	}

}
