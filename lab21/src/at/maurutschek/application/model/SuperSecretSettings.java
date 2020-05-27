package at.maurutschek.application.model;

import at.maurutschek.application.view.MyPane;
import javafx.animation.RotateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class SuperSecretSettings{
	MyPane my;
	Karte k = new Karte(Color.AQUA, new ImageView(), -1);
	RotateTransition r = new RotateTransition(Duration.seconds(2));
	Box b = k.getRect();
	Point3D p3d = new Point3D(1, 1, 1);

	public SuperSecretSettings(MyPane my){
		this.my = my;
	}

	public void start(){
		k.setOnMouseClicked(null);
		AnchorPane anp = new AnchorPane(k);
		anp.setPadding(new Insets(50));
		my.sssp.setLeft(anp);
		Slider s = new Slider(0, 200, b.getWidth()), s1 = new Slider(0, 200, b.getHeight()),
					s2 = new Slider(0, 200, b.getDepth()), s3 = new Slider(0, 10, 1),
					s4 = new Slider(0, 10, 1), s5 = new Slider(0, 10, 1);
		CheckBox cb1 = new CheckBox();
		cb1.setOnAction(x -> {
			if(b.getDrawMode() == DrawMode.LINE)
				b.setDrawMode(DrawMode.FILL);
			else
				b.setDrawMode(DrawMode.LINE);
		});
		s.setOnMouseDragged(x -> b.setWidth(s.getValue()));
		s1.setOnMouseDragged(x -> b.setHeight(s1.getValue()));
		s2.setOnMouseDragged(x -> b.setDepth(s2.getValue()));
		s3.setOnMouseDragged(x -> {
			p3d = new Point3D(s3.getValue(), p3d.getY(), p3d.getZ());
			r.setAxis(p3d);
			r.stop();
			r.play();
		});
		s4.setOnMouseDragged(x -> {
			p3d = new Point3D(p3d.getX(), s4.getValue(), p3d.getZ());
			r.setAxis(p3d);
			r.stop();
			r.play();
		});
		s5.setOnMouseDragged(x -> {
			p3d = new Point3D(p3d.getX(), p3d.getY(), s5.getValue());
			r.setAxis(p3d);
			r.stop();
			r.play();
		});

		add("Width", s);
		add("Height", s1);
		add("Depth", s2);
		add("Line", cb1);

		my.sssp.vbox.getChildren().add(new Label("Point 3D"));

		add("X:", s3);
		add("Y:", s4);
		add("Z:", s5);

		rotate();
	}

	private void add(	String t,
						Node n){
		my.sssp.vbox.getChildren().add(new HBox(10, new Label(t), n));
	}

	/**
	 * 
	 */
	private void rotate(){
		b.setCacheHint(CacheHint.QUALITY);
		r.setNode(b);
// r.setAutoReverse(true);
		r.setAxis(p3d);
		r.setByAngle(360);
		r.setOnFinished(x -> rekursion());
		r.setCycleCount(Integer.MAX_VALUE);
		r.play();
	}

	private void rekursion(){
		r.play();
	}
}
