package at.maurutschek.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab22.1
 *
 */
public class MyCircle extends MyShape{

	double radius;

	public double getRadius(){
		return radius;
	}

	public void setRadius(double radius){
		this.radius = radius;
	}

	public MyCircle(Paint paint, double x, double y, double radius){
		super(paint, x, y);
		setRadius(radius);
	}

	@Override
	public Shape paint(){
		return new Circle(getX(), getY(), this.radius, getPaint());
	}

	@Override
	public String toString(){
		return String.format("Circle: " + getPaint() + " X: " + getX() + " Y: " + getY() + " R: "
					+ getRadius());
	}

}
