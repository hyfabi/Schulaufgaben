/**
 * 
 */
package at.maurutschek.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab22.1
 *
 */
public abstract class MyShape{
	private Paint paint;
	private double x, y;

	public MyShape(Paint paint, double x, double y){
		setPaint(paint);
		setX(x);
		setY(y);
	}

	public abstract Shape paint();

	public Paint getPaint(){
		return paint;
	}

	public void setPaint(Paint paint){
		this.paint = paint;
	}

	public double getX(){
		return x;
	}

	public void setX(double x){
		this.x = x;
	}

	public double getY(){
		return y;
	}

	public void setY(double y){
		this.y = y;
	}

}
