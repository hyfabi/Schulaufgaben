package at.application.view;

import at.application.model.GameHandler;
import at.application.model.Mrx.MrxListItem;
import at.application.model.ResourceLoading;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class GameView extends BorderPane{

	public Label l1 = new Label("1"), l2 = new Label("2"), l3 = new Label("4");
	public Label name = new Label("Mr X.");
	public GridPane gp = new GridPane();
	public BorderPane bp = new BorderPane(gp);
	public GameHandler gh;
	public GameField gf;
	public ListView<MrxListItem> list;

	public GameView(int i, boolean cheat, boolean l){
		gf = new GameField(i, l);
		gh = new GameHandler(this, i, cheat, l);
		gf.bf.getGfbc().setGh(gh);
		init();

	}

	private void init(){
		initPane();
		initMenu();
		initGrid();
		initList();
	}

	private void initPane(){
		setCenter(gf);
		gp.setMinWidth(650);
		gp.setMaxWidth(650);
		gp.setPadding(new Insets(20));
		gp.setVgap(5);
		gp.setHgap(5);
		gp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
					new CornerRadii(30), new BorderWidths(5))));
		bp.setPadding(new Insets(10));
		setLeft(bp);
		bp.setTop(name);
		name.setFont(new Font("Times New Roman OS", 80));
		name.setAlignment(Pos.TOP_CENTER);
		name.setPadding(new Insets(10));
	}

	private void initList(){
		list = new ListView<>();
		bp.setBottom(list);
	}

	private void initGrid(){
		l1.setFont(new Font("Arial", 70));
		l1.setTextFill(Color.rgb(218, 212, 80));
		l2.setFont(new Font("Arial", 70));
		l2.setTextFill(Color.rgb(26, 178, 128));
		l3.setFont(new Font("Arial", 70));
		l3.setTextFill(Color.rgb(255, 72, 43));
		ImageView i1 = new ImageView("cards/t.png"), i2 = new ImageView("cards/b.png"),
					i3 = new ImageView("cards/u.png");
		i1.setFitWidth(100);
		i1.setPreserveRatio(true);
		i2.setFitWidth(100);
		i2.setPreserveRatio(true);
		i3.setFitWidth(100);
		i3.setPreserveRatio(true);
		gp.add(i1, 0, 0);
		gp.add(l1, 1, 0);
		gp.add(i2, 0, 1);
		gp.add(l2, 1, 1);
		gp.add(i3, 0, 2);
		gp.add(l3, 1, 2);
	}

	public void showCards(	int t,
							int b,
							int u,
							int s){
		l1.setText(t + "x");
		l2.setText(b + "x");
		l3.setText(u + "x");
		switch(s){
			case 0:
				gp.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(30), null)));
			break;
			case 1:
				name.setText("Detective Red");
				name.setTextFill(Color.rgb(255, 0, 0, 0.9));
				name.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5),
										null)));
				gp.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(30),
										null)));
			break;
			case 2:
				name.setText("Detective Green");
				name.setTextFill(Color.rgb(0, 255, 0, 0.9));
				name.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5),
										null)));
				gp.setBackground(new Background(
							new BackgroundFill(Color.rgb(255, 255, 0, 0.5), new CornerRadii(30),
										null)));
			break;
			case 3:
				name.setText("Detective Yellow");
				name.setTextFill(Color.rgb(255, 255, 0, 0.9));
				name.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5),
										null)));
				gp.setBackground(new Background(
							new BackgroundFill(Color.rgb(255, 255, 0, 0.5), new CornerRadii(30),
										null)));
			break;
			case 4:
				name.setTextFill(Color.rgb(0, 255, 255, 0.9));
				name.setText("Detective Blue");
				name.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5),
										null)));
				gp.setBackground(new Background(
							new BackgroundFill(Color.rgb(0, 255, 255, 0.5), new CornerRadii(30),
										null)));
			break;
			case 5:
				name.setTextFill(Color.rgb(197, 1, 80, 0.9));
				name.setText("Detective Purple");
				name.setBackground(new Background(
							new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5),
										null)));
				gp.setBackground(new Background(
							new BackgroundFill(Color.rgb(197, 1, 80, 0.5), new CornerRadii(30),
										null)));
			break;
		}
	}

	private void initMenu(){
		Menu men1 = new Menu("Spiel");
		MenuItem m1 = new MenuItem("Spiel speichern");
		men1.getItems().add(m1);
		MenuBar mb = new MenuBar(men1);

		m1.setOnAction(x -> ResourceLoading.save(gh.gd));
		setTop(mb);
	}
}
