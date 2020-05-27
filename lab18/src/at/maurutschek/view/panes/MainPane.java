/**
 * 
 */
package at.maurutschek.view.panes;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab18
 *
 */
public class MainPane extends BorderPane{
	private FlowPane btnP = new FlowPane();
	private FlowPane btnDP = new FlowPane();

	public MainPane(){
		init();
		setPadding(new Insets(10));
		setTop(btnP);
		setBottom(btnDP);
	}

	public FlowPane getBtnPane(){
		return btnP;
	}

	private void init(){
		TextField tf = new TextField();
		Button b1 = new Button("New Button"), b2 = new Button("New Image Button");

		btnDP.getChildren().addAll(b1, tf, b2);
		btnDP.setHgap(10);
		btnDP.setVgap(10);
		btnDP.setAlignment(Pos.CENTER);
		b1.setOnAction((x) -> {
			Button btn = new Button(tf.getText());
			btn.setOnAction((y) -> getBtnPane().getChildren().remove(btn));
			btnP.getChildren().add(btn);
		});

		b2.setOnAction((x) -> {
			FileChooser fc = new FileChooser();
			fc.setTitle("Bild einfügen");
			fc.getExtensionFilters().add(new ExtensionFilter("Bilder", "*.png", "*.jpeg", "*.jpg"));
			File f = fc.showOpenDialog(new Stage());
			if(f != null && f.exists() && f.canRead()){
				ImageView i = new ImageView("file:///" + f.getAbsolutePath());
				i.setFitWidth(50);
				i.setPreserveRatio(true);
				Button btn = new Button(tf.getText(), i);
				btn.setOnAction((y) -> getBtnPane().getChildren().remove(btn));
				btnP.getChildren().add(btn);
			}

		});

	}

}
