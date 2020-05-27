/**
 * 
 */
package at.maurutschek.application.view;

import java.util.ArrayList;
import java.util.Random;

import at.maurutschek.application.model.Karte;
import at.maurutschek.application.model.Resources;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class SpielFeld extends BorderPane{
	private int laenge, breite, felder;
	public VBox rootV;
	public Color color = Color.HOTPINK;
	Resources r = new Resources();
	ArrayList<Karte> cards;

	/**
	 * @return the breite
	 */
	public int getBreite(){
		return breite;
	}

	/**
	 * @return the laenge
	 */
	public int getLaenge(){
		return laenge;
	}

	/**
	 * @return the felder
	 */
	public int getFelder(){
		return felder;
	}

	public SpielFeld(int laenge, int breite){
		this.laenge = laenge;
		this.breite = breite;
		init();
	}

	/**
	 * @param laenge
	 *        the laenge to set
	 */
	public void setLaenge(int laenge){
		this.laenge = laenge;
		init();
	}

	/**
	 * @param breite
	 *        the breite to set
	 */
	public void setBreite(int breite){
		this.breite = breite;
		init();
	}

	public SpielFeld(){
		laenge = 2;
		breite = 2;
		felder = -1;
		init();
	}

	public void init(){

		this.rootV = null;
		generateGame();
		setCenter(rootV);
	}

	// TODO Exceptionhandling
	public void generateGame(){
		rootV = new VBox(10);
		felder = laenge * breite;
		if(felder % 2 == 1)
			felder--;
		ArrayList<Node> y = cardDeck();
		cards = (ArrayList<Karte>) y.clone();
		for(int i = 0; i < laenge; i++){
			HBox h = new HBox(10);
			for(int x = 0, x1 = felder; x < breite && x1 > 0; x++, x1--){
				h.getChildren().add(y.remove(0));
			}
			rootV.getChildren().add(h);
		}
	}

	/*
	 * private ArrayList<Node> getRow( ArrayList<Node> cards, int c){
	 * ArrayList<Node> a = new ArrayList<>(); for(int i = 0; i < c; i++)
	 * a.add(cards.remove(0)); return a; }
	 */
	private ArrayList<Node> cardDeck(){
		ArrayList<Node> arr = new ArrayList<>();
		ArrayList<ImageView> x = r.getPics(felder / 2);
		for(int i = 0; i < x.size(); i++){
			Karte k = new Karte(color, x.get(i), i);
			arr.add(new Karte(k));
			arr.add(new Karte(k));
		}
		return cardMixing(arr);
	}

	private ArrayList<Node> cardMixing(ArrayList<Node> a){
		ArrayList<Node> x = new ArrayList<>();
		Random rnd = new Random();
		for(int i = a.size(); i > 0; i--)
			x.add(a.remove(rnd.nextInt(a.size())));

		return x;
	}

	/**
	 * 
	 */
	public void setColor(Color p){
		if(!p.isOpaque())
			return;
		this.color = p;
		init();
	}

}
