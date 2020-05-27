/**
 * 
 */
package application.view;

import java.util.Optional;

import application.controller.ListController;
import application.controller.MenuController;
import application.model.Buisness;
import application.model.Clothing;
import application.model.Size;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab26
 *
 */
public class RootPane extends BorderPane{

	public ListView<Clothing> lv;
	public Buisness b;
	GridPane gp;
	ListController lc;
	MenuController mc;

	public TextField tf1 = new TextField();
	public TextField tf2 = new TextField();
	public ColorPicker cp = new ColorPicker();
	public DatePicker dp = new DatePicker();

	private ObservableList<Size> sizes = FXCollections.observableArrayList(Size.values());
	public ComboBox<Size> cb = new ComboBox<>(sizes);
	public CheckBox chb = new CheckBox();

	public RootPane(){
		b = new Buisness(this);
		lv = new ListView<>(b.getClothes());
		mc = new MenuController(this);
		gp = new GridPane();
		lc = new ListController(this);
		init();
	}

	private void init(){
		initGrid();
		initMenu();
		initMiscellaneous();
	}

	/**
	 * 
	 */
	private void initMiscellaneous(){
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv.setPrefWidth(450);
		lv.getSelectionModel().selectedItemProperty().addListener(lc);
		setCenter(lv);
	}

	/**
	 * 
	 */
	private void initMenu(){
		MenuItem m1 = new MenuItem("Add"), m2 = new MenuItem("Del"), m3 = new MenuItem("Save"),
					m4 = new MenuItem("Load"), m5 = new MenuItem("Sort");
		Menu menu1 = new Menu("Clothing", null, m1, m2, m3, m4), menu2 = new Menu("Sort", null, m5);
		MenuBar mb = new MenuBar(menu1, menu2);
		setTop(mb);

		m1.setOnAction(mc);
		m2.setOnAction(mc);
		m3.setOnAction(mc);
		m4.setOnAction(mc);
		m5.setOnAction(mc);
	}

	/**
	 * 
	 */
	private void initGrid(){
		BorderPane bp1 = new BorderPane();
		bp1.setTop(gp);

		gp.addRow(0, new Label("Brand: "), tf1);
		tf1.textProperty().addListener(x -> lv.refresh());
		gp.addRow(1, new Label("Color: "), cp);
		cp.valueProperty().addListener(x -> lv.refresh());
		gp.addRow(2, new Label("Date: "), dp);
		dp.valueProperty().addListener(x -> lv.refresh());
		gp.addRow(3, new Label("Size: "), cb);
		cb.valueProperty().addListener(x -> lv.refresh());
		gp.addRow(4, new Label("Male: "), chb);
		chb.selectedProperty().addListener(x -> lv.refresh());
		gp.addRow(5, new Label("Price: "), tf2);
		tf2.textProperty().addListener(x -> lv.refresh());

		gp.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
								new BorderWidths(5), new Insets(5))));
		gp.setPadding(new Insets(10));
		gp.setHgap(5);
		gp.setVgap(5);
		setRight(bp1);

		Label l = new Label("0");
		ComboBox<Size> cbx = new ComboBox<>(sizes);
		HBox h = new HBox(10);
		h.setAlignment(Pos.TOP_CENTER);
		h.getChildren().addAll(cbx, l);
		bp1.setCenter(h);

		cbx.valueProperty().addListener((	x,
											y,
											z) -> {
			int i = 0;
			for(Clothing c : lv.getItems())
				if(c.getSize().get() == z)
					i++;
			l.setText(i + "");
		});
	}

	public void add(){
		Dialog<Clothing> d = new Dialog<>();

		GridPane gpx = new GridPane();

		TextField tf1x = new TextField(), tf2x = new TextField();
		ColorPicker cpx = new ColorPicker();
		DatePicker dpx = new DatePicker();
		ComboBox<Size> cbx = new ComboBox<>(sizes);
		CheckBox chbx = new CheckBox();
		Label exc = new Label();

		exc.setTextFill(Color.RED);
		d.setTitle("New Clothing");
		d.setHeaderText("Please fill in here!");
		d.getDialogPane().setPrefSize(500, 300);
		gpx.setMinSize(500, 300);
		gpx.addRow(0, new Label("Brand: "), tf1x);
		gpx.addRow(1, new Label("Color: "), cpx);
		gpx.addRow(2, new Label("Date: "), dpx);
		gpx.addRow(3, new Label("Size: "), cbx);
		gpx.addRow(4, new Label("Male: "), chbx);
		gpx.addRow(5, new Label("Price: "), tf2x);
		gpx.addRow(6, exc);

		ButtonType btn1 = new ButtonType("Fertig");

		d.getDialogPane().setContent(gpx);
		d.getDialogPane().getButtonTypes().addAll(btn1);
		d.setResultConverter(new Callback<ButtonType, Clothing>(){

			@Override
			public Clothing call(ButtonType param){
				try{
					return new Clothing(tf1x.getText(), cpx.getValue(), dpx.getValue(),
								cbx.getValue(), chbx.isSelected(),
								Integer.parseInt(tf2x.getText()));
				}catch(Exception e){
					exc.setText(e.getMessage());
				}
				return null;
			}
		});

		Optional<Clothing> o = d.showAndWait();
		if(o.isPresent())
			lv.getItems().add(o.get());
		lv.refresh();
	}

	/**
	 * 
	 */
	public void del(){
		lv.getItems().removeAll(lv.getSelectionModel().getSelectedItems());
		lv.refresh();
	}
}
