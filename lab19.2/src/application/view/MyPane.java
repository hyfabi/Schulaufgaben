/**
 * 
 */
package application.view;

import application.Main;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.ExtraClickers;
import model.Game;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab19.2
 *
 */
public class MyPane extends BorderPane{

	FlowPane fpb = new FlowPane(), fpr = new FlowPane();
	BorderPane bpt = new BorderPane(), bp2 = new BorderPane();
	private boolean ballRotation;
	ImageView iv;
	private int clicks;

	public MyPane(){
		ballRotation = false;
		init();
		setBottom(bp2);
		bp2.setBottom(fpb);
		setTop(bpt);
		init2();
		cPS();
	}

	private void init2(){

	}

	private void init(){
		iv = new ImageView(
					"file:///" + System.getProperty("user.dir") + "\\gfx\\ball.png");
		iv.setFitWidth(100);
		iv.setPreserveRatio(true);

		ImageView i1 = new ImageView(
					"file:///" + System.getProperty("user.dir") + "\\gfx\\junge.jpg");
		i1.setFitWidth(100);
		i1.setPreserveRatio(true);
		ImageView i2 = new ImageView(
					"file:///" + System.getProperty("user.dir") + "\\gfx\\alaba.jpg");
		i2.setFitWidth(100);
		i2.setPreserveRatio(true);
		ImageView i3 = new ImageView(
					"file:///" + System.getProperty("user.dir") + "\\gfx\\ronaldo.jpg");
		i3.setFitWidth(100);
		i3.setPreserveRatio(true);
		Button b = new Button("", iv), b1 = new Button("", i1), b2 = new Button("", i2),
					b3 = new Button("", i3);

		Label l1 = new Label("Nicht gekauft\nKosten: 10"),
					l2 = new Label("Nicht gekauft\nKosten: 100"),
					l3 = new Label("Nicht gekauft\nKosten: 1000");

		VBox h1 = new VBox(10, b1, l1), h2 = new VBox(10, b2, l2), h3 = new VBox(10, b3, l3);

		b.setOnAction(x -> {
			Main.g.setCount(Main.g.mbm);
			ballRotation = true;
			clicks++;
			rotate();
		});

		b1.setOnAction(x -> {
			if(Main.g.buy(ExtraClickers.JUNGE.getKosten())){
				if(ExtraClickers.JUNGE.isEnabled())
					ExtraClickers.JUNGE.increment();
				else
					ExtraClickers.JUNGE.setEnabled(true);
				l1.setText("" + ("Level: " + ExtraClickers.JUNGE.getAnzahl()) + "\nKosten: "
							+ ExtraClickers.JUNGE.getKosten());
			}
		});
		b2.setOnAction(x -> {
			if(Main.g.buy(ExtraClickers.ALABA.getKosten())){
				if(ExtraClickers.ALABA.isEnabled())
					ExtraClickers.ALABA.increment();
				else
					ExtraClickers.ALABA.setEnabled(true);
				l2.setText("" + ("Level: " + ExtraClickers.ALABA.getAnzahl()) + "\nKosten: "
							+ ExtraClickers.ALABA.getKosten());
			}
		});
		b3.setOnAction(x -> {
			if(Main.g.buy(ExtraClickers.RONALDO.getKosten())){
				if(ExtraClickers.RONALDO.isEnabled())
					ExtraClickers.RONALDO.increment();
				else
					ExtraClickers.RONALDO.setEnabled(true);
				l3.setText("Level: " + ExtraClickers.RONALDO.getAnzahl() + "\nKosten: "
							+ ExtraClickers.RONALDO.getKosten());
			}
		});

		fpb.setAlignment(Pos.CENTER);
		fpb.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID,
					new CornerRadii(50), new BorderWidths(5))));

		fpb.getChildren().add(Main.g.getL());
		fpr.getChildren().addAll(h1, h2, h3);
		fpr.setHgap(10);
		this.setCenter(b);
		bpt.setRight(fpr);

	}

	public void rotate(){
		PauseTransition pause = new PauseTransition(Duration.millis(0.1));
		pause.setOnFinished(e -> {
			if(iv.getRotate() <= 360){
				if(iv.getRotate() >= 360){
					iv.setRotate(0);
					return;
				}
				iv.setRotate(iv.getRotate() + 1);
				if(Game.DEBUG)
					System.out.println("Ballrotation: " + iv.getRotate());
				rotate();
			}
		});
		pause.play();
	}

	public void cPS(){
		PauseTransition pause = new PauseTransition(Duration.millis(1000));
		pause.setOnFinished(e -> {
			bp2.setTop(new Label(clicks + " Cliks pro Sekunde"));

			clicks = 0;
			cPS();
		});
		pause.play();
	}
}
