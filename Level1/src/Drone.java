
import java.util.Random;

public class Drone{

	// location
	// direction
	// speed

	public int x;
	public int y;
	public int speed; // from 0-5
	public int id;
	public String direction;
	public Random random = new Random();

	public Drone(int id, int x, int y, String direction){
		this.id = id;
		this.x = x;
		this.y = y;
		this.speed = 0;
		this.direction = direction;
	}

	public void setDirection(String direction){
		this.direction = direction;
	}

	public void fahren(){
		switch(direction){
			case "N":
				increaseY();
			break;
			case "NW":
				decreaseX();
				increaseY();
			break;
			case "NE":
				increaseX();
				increaseY();
			break;
			case "E":
				increaseX();
			break;
			case "SE":
				increaseX();
				decreaseY();
			break;
			case "S":
				decreaseY();
			break;
			case "SW":
				decreaseX();
				decreaseY();
			break;
			case "W":
				decreaseX();
			break;
			default:

			break;
		}
	}

	public void increaseX(){
		x += speed;
	}

	public void increaseY(){
		y += speed;
	}

	public void decreaseX(){
		x -= speed;
	}

	public void decreaseY(){
		y -= speed;
	}

	public void setSpeed(String s){
		speed = Integer.parseInt(s);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "X: " + x + " Y: " + y;
	}
}