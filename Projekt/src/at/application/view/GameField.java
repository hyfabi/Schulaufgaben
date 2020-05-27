/**
 * 
 */
package at.application.view;

import at.application.controller.KeyHandler;
import at.application.controller.MouseHandler;
import at.application.model.Mrx;
import at.application.model.Player;
import javafx.scene.CacheHint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class GameField extends BorderPane{

	public ButtonField bf = new ButtonField();
	KeyHandler kh = new KeyHandler(this);
	MouseHandler mh = new MouseHandler(this);

	ImageView[] playerImgs;
	ImageView mrxI = new ImageView("figures/0.png");

	public GameField(int players, boolean l){
		playerImgs = new ImageView[players + 1];

		getChildren().add(bf);
		setOnKeyPressed(kh);
		setOnMouseClicked(mh);
		setBackground(new Background(
					new BackgroundImage(new Image("background.jpg", 0, 950, true, true),
								BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
								null, BackgroundSize.DEFAULT)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
					CornerRadii.EMPTY, new BorderWidths(3))));
		mrxI.setFitWidth(15);
		mrxI.setPreserveRatio(true);
		mrxI.setCacheHint(CacheHint.QUALITY);
		for(int i = 1; i < players + 1; i++){
			playerImgs[i] = new ImageView("figures/" + i + ".png");
			playerImgs[i].setFitWidth(15);
			playerImgs[i].setPreserveRatio(true);
			playerImgs[i].setCacheHint(CacheHint.QUALITY);
			getChildren().add(playerImgs[i]);
		}
	}

	public void paintFigures(	Player[] pl,
								Mrx mrx){
		if(mrx == null)
			getChildren().remove(mrxI);
		else{
			getChildren().remove(mrxI);
			mrxI.setX(bf.getButtons().get(mrx.getField() - 1).getLayoutX() + 8);
			mrxI.setY(bf.getButtons().get(mrx.getField() - 1).getLayoutY() - 20);
			getChildren().add(mrxI);
		}
		for(int i = 1; i < pl.length; i++){
			playerImgs[i].setX(bf.getButtons().get(pl[i].getField() - 1).getLayoutX() + 8);
			playerImgs[i].setY(bf.getButtons().get(pl[i].getField() - 1).getLayoutY() - 20);
		}

	}
}
