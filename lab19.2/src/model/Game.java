/**
 * 
 */
package model;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab19.2
 *
 */
public class Game{
	public int mbm = 1;

	private Label l = new Label();
	private double count;
	public static final boolean DEBUG = false;

	public Game(){
		automatischesUpdate();
	}

	public Label getL(){
		return l;
	}

	public double getCount(){
		return count;
	}

	public boolean buy(int costs){
		if(count >= costs){
			setCount(costs * -1);
			return true;
		}
		return false;
	}

	public void setCount(double d){
		if(DEBUG)
			System.out.println(this.count + d);
		this.count += d;
		l.setText((int) (this.count) + "");
	}

	public void automatischesUpdate(){
		PauseTransition pause = new PauseTransition(Duration.millis(500));
		pause.setOnFinished(e -> {
			if(ExtraClickers.JUNGE.isEnabled())
				setCount(ExtraClickers.JUNGE.getGeld());
			if(ExtraClickers.ALABA.isEnabled())
				setCount(ExtraClickers.ALABA.getGeld());
			if(ExtraClickers.RONALDO.isEnabled())
				setCount(ExtraClickers.RONALDO.getGeld());
			automatischesUpdate();
		});
		pause.play();

	}
}
