package at.maurutschek.application.model;

import at.maurutschek.application.view.Main;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.CacheHint;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class Karte extends Pane{
	private Box rect;
	private ImageView i;
	private int rotationPosition, imgId;
	private RotateTransition r = new RotateTransition();
	private boolean aufgedeckt;

	public Box getRect(){
		return rect;
	}

	public void setRect(Box rect){
		this.rect = rect;
	}

	public ImageView getI(){
		return i;
	}

	public void setI(ImageView i){
		this.i = i;
	}

	public int getRotationPosition(){
		return rotationPosition;
	}

	public void setRotationPosition(int rotationPosition){
		this.rotationPosition = rotationPosition;
	}

	public RotateTransition getR(){
		return r;
	}

	public void setR(RotateTransition r){
		this.r = r;
	}

	public boolean isAufgedeckt(){
		return aufgedeckt;
	}

	public void setAufgedeckt(boolean aufgedeckt){
		this.aufgedeckt = aufgedeckt;
	}

	public void setImgId(int imgId){
		this.imgId = imgId;
	}

	private double boxWidth = 10;
	private int degree = 90;

	public void setBoxWidth(double d){
		this.boxWidth = d;
	}

	public void setDegree(int degree){
		this.degree = degree;
	}

	public double getBoxWidth(){
		return boxWidth;
	}

	public int getDegree(){
		return degree;
	}

	public Karte(Color color, ImageView i, int id){
		rect = new Box(100, 100, boxWidth);
		rect.setMaterial(new PhongMaterial(color));
		this.i = i;
		if(i == null)
			System.out.println("Null");
		this.imgId = id;
		init();
	}

	public Karte(Karte k){
		this.i = new ImageView(k.i.getImage());
		this.imgId = k.imgId;
		rect = new Box(100, 100, boxWidth);
		rect.setMaterial(k.rect.getMaterial());
		init();
	}

	private void init(){
		setCacheHint(CacheHint.ROTATE);
		rect.setCacheHint(CacheHint.ROTATE);
		rect.setCache(true);
		rect.setTranslateX(50);
		rect.setTranslateY(50);
		i.setTranslateZ(-(boxWidth / 2));
		i.setScaleX(-1);
		i.setFitHeight(99.5);
		i.setFitWidth(99.5);
		i.setLayoutX(0.5);
		i.setLayoutY(0.5);
		setMaxWidth(100);
		setMaxHeight(100);
		if(Main.DEBUG)
			rect.setDrawMode(DrawMode.FILL);
// rect.setMaterial(new PhongMaterial(null, this.i.getImage(), null, null,
// null));
		setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
					new CornerRadii(5), new BorderWidths(2))));
		getChildren().addAll(rect, i);
		rect.toFront();
		this.setOnMouseClicked(Game.cc);

	}

	public int getImgId(){
		return imgId;
	}

	public void startAnimation(boolean back){

		final Point3D AX = new Point3D(1, 1, 0);
		i.setRotate(-degree);
		r = new RotateTransition(Duration.millis(250), this);
		r.setAxis(AX);
		r.setByAngle(degree);
		r.setOnFinished((z) -> {
			if(rotationPosition == 1){
				rotationPosition = 0;
				if(back)
					Game.cc.allowAccess = true;
				return;
			}
			r.setAxis(new Point3D(AX.getX() * -1, AX.getY() * -1, AX.getZ() * -1));
			if(back)
				rect.toFront();
			else
				i.toFront();
			rotationPosition++;
			r.play();
		});
		r.play();
	}

	@Override
	public String toString(){
		return "Karte id:" + imgId + " [rect=" + rect + ", i=" + i + ", x=" + rotationPosition
					+ "]";
	}

}
