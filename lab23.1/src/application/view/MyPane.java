/**
 * 
 */
package application.view;

import java.util.ArrayList;
import java.util.Random;

import application.controller.Controller;
import application.controller.Game;
import application.model.Einstellung;
import application.model.GameObject;
import application.model.PaintEinstellungen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class MyPane extends BorderPane{

	PaintEinstellungen e;
	GridPane gp;
	Controller c;
	Game g;
	Label l1, l2, l3, l4, l5;
	Slider s;
	ArrayList<Button> buttons;
	ListView<Einstellung> list;
	TextField ta;
	GameObject maus = new GameObject(0, 0), katze = new GameObject(4, 4);

	public ListView<Einstellung> getList(){
		return list;
	}

	public TextField getTa(){
		return ta;
	}

	public GridPane getGp(){
		return gp;
	}

	public Controller getC(){
		return c;
	}

	public Game getG(){
		return g;
	}

	public Label getL1(){
		return l1;
	}

	public Label getL2(){
		return l2;
	}

	public Label getL3(){
		return l3;
	}

	public Label getL4(){
		return l4;
	}

	public Label getL5(){
		return l5;
	}

	public Slider getS(){
		return s;
	}

	public ArrayList<Button> getButtons(){
		return buttons;
	}

	public GameObject getMaus(){
		return maus;
	}

	public GameObject getKatze(){
		return katze;
	}

	public MyPane(){
		e = new PaintEinstellungen();
		c = new Controller(this);
		g = new Game(this);
		init();
	}

	public PaintEinstellungen getE(){
		return e;
	}

	public void changeToEinstellung(){
		gp = new GridPane();
		Button btn1 = new Button("Select"), btn2 = new Button("Select"),
					btn3 = new Button("Select"), btn4 = new Button("Select");
		btn1.setUserData("Maus");
		btn2.setUserData("Katze");
		btn3.setUserData("Gefangen");
		btn4.setUserData("Plan");
		btn1.setOnAction(c);
		btn2.setOnAction(c);
		btn3.setOnAction(c);
		btn4.setOnAction(c);

		l1 = new Label("Maus: " + e.getE().getAktE().getpM());
		l2 = new Label("Katze: " + e.getE().getAktE().getpK());
		l3 = new Label("Gefangen: " + e.getE().getAktE().getpG());
		l4 = new Label("Plan: " + e.getE().getAktE().getpP());
		l5 = new Label("Opacity");
		s.setMaxWidth(100);
		s.setValue(e.getE().getAktE().getOpacity());
		ta = new TextField(e.getE().getAktE().getName());
		Button btn5 = new Button("Add"), btn6 = new Button("Delete"),
					btn7 = new Button("Update");
		btn5.setUserData("Add");
		btn6.setUserData("Delete");
		btn7.setUserData("Update");
		btn5.setOnAction(c);
		btn6.setOnAction(c);
		btn7.setOnAction(c);
		ta.setMaxWidth(100);
		gp.addRow(0, l1, btn1, e.getMaus());
		gp.addRow(1, l2, btn2, e.getKatze());
		gp.addRow(2, l3, btn3, e.getGefangen());
		gp.addRow(3, l4, btn4, e.getPlan());
		gp.addRow(4, l5, s);
		gp.addRow(5, new Label("Name:"), ta);
		gp.addRow(6, btn5, btn6, btn7);
		setCenter(gp);
		list = new ListView<>(e.getE().getEinstellungen());
		list.setMaxWidth(100);
		list.addEventHandler(MouseEvent.MOUSE_CLICKED, x -> {
			Einstellung g1 = getList().getSelectionModel().getSelectedItem();
			e.getE().setAktE(g1);
			changeToEinstellung();
			list.getSelectionModel().select(g1);
		});
		setLeft(list);
	}

	public void changeToSpiel(){
		gp = null;
		gp = new GridPane();

		buttons = new ArrayList<>();
		gp.setBackground(new Background(new BackgroundImage(new Image(e.getE().getAktE().getpP()),
					null, null, null, null)));
		for(int x = 0; x < 5; x++)
			for(int y = 0; y < 5; y++){
				Button b = new Button();
				b.setOpacity(s.getValue());
				b.setPrefHeight(100);
				b.setPrefWidth(100);
				b.setUserData(x + " " + y);
				b.setOnAction(g);
				buttons.add(b);
				gp.add(b, x, y);
			}
		setCenter(gp);
		setLeft(null);
	}

	private void init(){
		initMenu();
		changeToSpiel();
		initField();
	}

	/**
	 * 
	 */
	private void initField(){
		ImageView k = e.getKatze(), m = e.getMaus();
		k.setFitWidth(60);
		k.setFitHeight(60);
		m.setFitHeight(60);
		m.setFitWidth(60);
		for(Button b : buttons){
			if(b.getUserData().equals("4 4"))
				b.setGraphic(k);
			if(b.getUserData().equals("0 0"))
				b.setGraphic(m);
		}
	}

	private void initMenu(){
		s = new Slider(0, 1, 1);
		MenuItem m1 = new MenuItem("Spiel"), m2 = new MenuItem("Einstellungen");
		Menu mm1 = new Menu("Spiel", null, m1), mm2 = new Menu("Einstellungen", null, m2);
		m1.setUserData("Spiel");
		m2.setUserData("Einstellungen");
		m1.setOnAction(c);
		m2.setOnAction(c);
		MenuBar mb = new MenuBar(mm1, mm2);
		setTop(mb);

		Label l = new Label();
		l.setBackground(
					new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(10), null)));
		setBottom(l);
	}

	public void reload(){
		l1 = new Label("Maus: " + e.getE().getAktE().getpM());
		l2 = new Label("Katze: " + e.getE().getAktE().getpK());
		l3 = new Label("Gefangen: " + e.getE().getAktE().getpG());
		l4 = new Label("Plan: " + e.getE().getAktE().getpP());
		l5 = new Label("Opacity");

	}

	public void showImage(	Object uD,
							ImageView i){
		if(!clipping(uD, katze))
			return;

		for(Button b : buttons)
			if(b.getGraphic() == i)
				b.setGraphic(null);
		for(Button b : buttons){
			if(b.getUserData().equals(uD))
				if(catched())
					b.setGraphic(e.getGefangen());
				else
					b.setGraphic(i);
		}
	}

	private boolean clipping(	Object ud,
								GameObject o){
		int xD = Integer.parseInt(((String) ud).split(" ")[0]);
		int yD = Integer.parseInt(((String) ud).split(" ")[1]);
		if(Math.abs(o.getX() - xD) > 0 && Math.abs(o.getY() - yD) > 0)
			return false;
		if(Math.abs(o.getX() - xD) == 1){
			o.setX(xD);
			return true;
		}else if(Math.abs(o.getY() - yD) == 1){
			o.setY(yD);
			return true;
		}
		return false;
	}

	private boolean catched(){
		if(katze.getX() == maus.getX() && katze.getY() == maus.getY())
			return true;
		return false;
	}

	public void mouseMove(){
		showmouse(false);
		Random rnd = new Random();
		int x = Math.abs(rnd.nextInt(4));
		if(x == 0){
			if((maus.getX() - 1) < 0)
				mouseMove();
			if(!clipping((maus.getX() - 1) + " " + maus.getY(), maus))
				mouseMove();
			else
				return;
		}else if(x == 1){
			if((maus.getY() - 1) < 0)
				mouseMove();
			if(!clipping(maus.getX() + " " + (maus.getY() - 1), maus))
				mouseMove();
			else
				return;
		}else if(x == 2){
			if((maus.getX() + 1) > 4)
				mouseMove();
			if(!clipping((maus.getX() + 1) + " " + maus.getY(), maus))
				mouseMove();
			else
				return;
		}else{
			if((maus.getX() + 1) > 4)
				mouseMove();
			if(!clipping(maus.getX() + " " + (maus.getY() + 1), maus)){
				mouseMove();
			}
		}

	}

	public void showmouse(boolean show){
		if(show){
			for(Button b : buttons)
				if(b.getUserData().equals(maus.getX() + " " + maus.getY()))
					b.setGraphic(e.getMaus());
				else if(b.getGraphic() == e.getMaus())
					b.setGraphic(null);
		}else
			for(Button b : buttons)
			if(b.getGraphic() == e.getMaus())
				b.setGraphic(null);
	}
}
