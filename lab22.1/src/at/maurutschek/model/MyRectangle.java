package at.maurutschek.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab22.1
 *
 */
public class MyRectangle extends MyShape{
	/**
	 * @param paint
	 * @param x
	 * @param y
	 */
	public MyRectangle(Paint paint, double x, double y, double width, double height){
		super(paint, x, y);
		setWidth(y);
		setHeight(y);
	}

	double width, height;

	public double getWidth(){
		return width;
	}

	public void setWidth(double width){
		this.width = width;
	}

	public double getHeight(){
		return height;
	}

	public void setHeight(double height){
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * @see at.maurutschek.model.MyShape#paint()
	 */
	@Override
	public Shape paint(){
		Rectangle r = new Rectangle(getX(), getY(), getWidth(), getHeight());
		r.setFill(getPaint());
		return r;
	}

	@Override
	public String toString(){
		return String.format("MyRectangle [width=%s, height=%s]", width, height);
	}

}
