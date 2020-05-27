/**
 * 
 */
package at.application.view;

import at.application.model.GameFieldButtonData;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class GameFieldButton extends Button{
	public GameFieldButtonData g;

	public GameFieldButton(GameFieldButtonData gfbd){
		g = gfbd;
		init();
	}

	private void init(){
		setFont(new Font(9));
		setMinSize(30, 25);
		setMaxSize(30, 25);
		setLayoutX(g.x);
		setLayoutY(g.y);
		if(g.isUnderground())
			setBackground(new Background(new BackgroundFill(Color.RED,
						new CornerRadii(5), new Insets(5))));

		else if(g.isBus())
			setBackground(new Background(new BackgroundFill(Color.GREENYELLOW,
						new CornerRadii(5), new Insets(5))));
		else
			setBackground(new Background(new BackgroundFill(Color.YELLOW,
						new CornerRadii(5), new Insets(5))));

		setText("" + g.number);
	}

	public static GameFieldButton getCopyButton(GameFieldButton g){
		System.out.println(g.g.x + " " + g.g.y);
		return new GameFieldButton(g.g);
	}

	@Override
	public String toString(){
		return g.toString();
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		GameFieldButton other = (GameFieldButton) obj;
		if(g.number != other.g.number)
			return false;
		return true;
	}

}
