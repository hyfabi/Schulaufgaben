/**
 * 
 */
package application.model;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class GameObject{
	private int x, y;

	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}

	public GameObject(int x, int y){
		super();
		this.x = x;
		this.y = y;
	}

}
