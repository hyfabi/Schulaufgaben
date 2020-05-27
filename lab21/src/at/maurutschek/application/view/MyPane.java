/**
 * 
 */
package at.maurutschek.application.view;

import java.util.Optional;

import at.maurutschek.application.model.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class MyPane extends BorderPane{
	public SpielFeld b;
	public ScoreView sv;
	boolean showingGame = true;
	public Game g;
	public Stage s;
	public SuperSecretSettingsPane sssp;
	Finished f;

	public MyPane(Stage s, Finished f){
		this.f = f;
// sssp = new SuperSecretSettingsPane(this);
		b = new SpielFeld();
		sv = new ScoreView(b.getFelder(), f);
		this.s = s;
		g = new Game(this, s);
		initMenu();
		init();
	}

	private void init(){
		b.setPadding(new Insets(10));
		setBackground(new Background(new BackgroundImage(new Image("hintergrund.jpg"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
					new BackgroundSize(getWidth(), getHeight(), false, false, false,
								true))));
	}

	public void changeView(){
		showingGame = !showingGame;
		if(showingGame)
			setCenter(b);
		else
			setCenter(sv);
	}

	private void initMenu(){
		MenuItem mi1 = new MenuItem("Benutzerangabe"), mi2 = new MenuItem("Länge"),
					mi3 = new MenuItem("Breite"),
					mi4 = new MenuItem("Color"),
					mi5 = new MenuItem("Anzeigen"), mi6 = new MenuItem("Sort by Player"),
					mi7 = new MenuItem("Sort by Ergebnis"), mi8 = new MenuItem("Speichern"),
					mi9 = new MenuItem("Lesen");

		Menu m1 = new Menu("Spiel", null, mi1, mi2, mi3, mi4),
					m2 = new Menu("Ergebnisse", null, mi5, mi6, mi7, mi8, mi9);
		MenuBar m = new MenuBar(m1, m2);

		for(Menu a : m.getMenus())
			for(MenuItem x : a.getItems())
				x.setOnAction(g.mc);

		setTop(m);
		setCenter(b);
	}

// TODO ExceptionHandling
	public void changeSpielFeld(boolean laenge){
		TextInputDialog dialog;
		if(laenge){
			dialog = new TextInputDialog("2");
			dialog.setTitle("Länge des Spielfelds");
			dialog.setHeaderText("Bitte wählen Sie die Länge");
			Optional<String> result = dialog.showAndWait();
			if(result.isPresent()){
				String s1 = "" + result.get();
				if(!s1.isEmpty())
					if(s1.toUpperCase().equals(s1.toLowerCase()))
						b.setLaenge(Integer.parseInt(s1));
			}
		}else{
			dialog = new TextInputDialog("2");
			dialog.setTitle("Breite des Spielfelds");
			dialog.setHeaderText("Bitte wählen Sie die Breite");
			Optional<String> result = dialog.showAndWait();
			if(result.isPresent()){
				String s1 = "" + result.get();
				if(!s1.isEmpty())
					if(s1.toUpperCase().equals(s1.toLowerCase()))
						b.setBreite(Integer.parseInt(s1));
			}
		}
		sv = new ScoreView(b.getFelder(), f);
	}

}
