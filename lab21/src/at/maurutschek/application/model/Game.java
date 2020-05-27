package at.maurutschek.application.model;

import java.util.Optional;

import at.maurutschek.application.controller.CardController;
import at.maurutschek.application.controller.MenuController;
import at.maurutschek.application.view.Main;
import at.maurutschek.application.view.MyPane;
import javafx.animation.PauseTransition;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class Game{
	public static CardController cc = new CardController();
	public MenuController mc;
	private MyPane my;
	private String name = "No Name";
	private Stage s;

	Resources r = new Resources();

	public Game(MyPane my, Stage s){
		this.s = s;
		this.my = my;
		mc = new MenuController(my);
		aktTiltle();
	}

	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @param name
	 *        the name to set
	 */
	public void setName(String name){
		this.name = name;
		aktTiltle();
	}

	// TODO Fix
	// TODO fragen: unterschied zwischen stage und window
	public void changeColor(){
		Dialog<Color> d = new Dialog<>();
		DialogPane dp = new DialogPane();
		Window window = d.getDialogPane().getScene().getWindow();
		window.setOnCloseRequest(event -> window.hide());
		d.setWidth(1);
		d.setHeight(1);
		dp.setMaxSize(1, 1);
		d.setTitle("Neue Farbe");
		d.setDialogPane(dp);
		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setLayoutY(0);
		colorPicker.setLayoutX(0);
		colorPicker.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
		colorPicker.setOnAction(event -> {
			Main.root.b.setColor(colorPicker.getValue());
			if(Main.DEBUG)
				System.out.println("Farbe gesetzt");
			window.hide();
		});
		colorPicker.setOnHiding(e -> {
			PauseTransition p = new PauseTransition(Duration.millis(1));
			p.play();
			p.setOnFinished(e1 -> {
				colorPicker.show();
			});
			if(Main.DEBUG)
				System.out.println("Hiding");
		});
		dp.getChildren().add(colorPicker);
		d.show();
		colorPicker.show();
	}

	/**
	 * 
	 */
	public void changeName(){
		TextInputDialog dialog = new TextInputDialog("Name");
		dialog.setTitle("Name");
		dialog.setHeaderText("Bitte geben Sie Ihren Namen ein.");
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent()){
			String s1 = "" + result.get();
			if(!s1.isEmpty())
				setName(s1);
		}
	}

	/**
	 * 
	 */
	public void aktTiltle(){
		s.setTitle(my.b.getBreite() + "x" + my.b.getLaenge() + "MEMORY (" + name + ")");
	}
}
