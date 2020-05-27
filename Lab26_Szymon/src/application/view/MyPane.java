package application.view;

import application.controll.Handler;
import application.model.Geschaeft;
import application.model.Kleidungsstueck;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class MyPane extends BorderPane{
	public TextField tMarke;
	Geschaeft geschaeft;
	Handler handler;
	ListView<Kleidungsstueck> lv;
	Kleidungsstueck ks;
	public ColorPicker cpFarbe;
	public DatePicker dp;
	public ComboBox<Groesse> cbGroesse;
	public TextField tPreis;
	
	public MyPane() {
		geschaeft = new Geschaeft();
		handler = new Handler(this,geschaeft);
		ks = new Kleidungsstueck();
		initTop();
		initLeft();
		initRight();
	}

    public void initTop() {
    	
    	MenuBar mb1 = new MenuBar();
    	Menu m1 = new Menu("Kleidung");
    	Menu m2 = new Menu("Sort");
    	MenuItem mt1= new MenuItem("Add");
    	mt1.setOnAction(handler);
    	mt1.setUserData("Add");
    	MenuItem mt2= new MenuItem("Del");
    	MenuItem mt3= new MenuItem("Save");
    	MenuItem mt4= new MenuItem("Load");
    	
    	
    	m1.getItems().addAll(mt1,mt2,mt3,mt4);
    	mb1.getMenus().addAll(m1,m2);
    	
    	
    	setTop(mb1);
    	
    }

	public void initLeft(){
		
	 lv = new ListView<Kleidungsstueck>(geschaeft.getMitarbeiter());
	
     lv.setPrefWidth(1000);
	 
     lv.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Kleidungsstueck>() {

				// TODO Auto-generated method stub
						
				
					

					@Override
					public void changed(ObservableValue<? extends Kleidungsstueck> arg0, Kleidungsstueck oldM,
							Kleidungsstueck newM) {
						// TODO Auto-generated method stub
						if(oldM!=null)
						{
							tMarke.textProperty().unbindBidirectional(oldM.getMarkeProperty());
							dp.valueProperty().unbindBidirectional(oldM.getDatumProperty());
							cpFarbe.valueProperty().unbindBidirectional(oldM.getFarbeProperty());
							cbGroesse.valueProperty().unbindBidirectional(oldM.getGroesseProperty());
							tPreis.textProperty().unbindBidirectional(oldM.getPreisProperty());;
							}
						if(newM!=null)
						{
							tMarke.textProperty().bindBidirectional(newM.getMarkeProperty());
							dp.valueProperty().bindBidirectional(newM.getDatumProperty());
							cpFarbe.valueProperty().bindBidirectional(newM.getFarbeProperty());
							cbGroesse.valueProperty().bindBidirectional(newM.getGroesseProperty());
							tPreis.textProperty().bindBidirectional(newM.getPreisProperty(), new NumberStringConverter());

						}
					}
					
				});
     
		setLeft(lv);
	}
	
	public void initRight() {
		
		GridPane gp = new GridPane();
		VBox vb1 = new VBox();
		FlowPane fp1 = new FlowPane();
		
		Label l11 = new Label();
		ComboBox<Groesse> cbGroesse2 = new ComboBox<Groesse>();
		cbGroesse2.getItems().addAll(Groesse.XS,Groesse.S,Groesse.M,Groesse.L,Groesse.XL,Groesse.XXL);
		fp1.setHgap(20);
		fp1.setPadding(new Insets(10));
		fp1.getChildren().addAll(l11,cbGroesse2);
		
		Label l1 = new Label("Marke/Bezeichnung:");
		Label l2 = new Label("Farbe:");
		Label l3 = new Label("Einkaufsdatum:");
		Label l4 = new Label("Größe:");
		Label l5 = new Label("Mann");
		Label l6 = new Label("Preis:");
		
		 tMarke = new TextField();
		tPreis = new TextField();
		 dp = new DatePicker();
		
		
		 cpFarbe = new ColorPicker();
		cpFarbe.setValue(Color.WHITE);
		
	 cbGroesse = new ComboBox<Groesse>();
	    cbGroesse.getItems().addAll(Groesse.XS,Groesse.S,Groesse.M,Groesse.L,Groesse.XL,Groesse.XXL);
		
		gp.add(l1, 0, 0);
		gp.add(tMarke, 1, 0);
		
		gp.add(l2, 0, 1);
		gp.add(cpFarbe, 1, 1);
		
		gp.add(l3, 0, 2);
		gp.add(dp, 1, 2);
		
		gp.add(l4, 0, 3);
		gp.add(cbGroesse, 1, 3);
		
		gp.add(l5, 0, 4);
			
	    gp.add(l6, 0, 5);
	    gp.add(tPreis, 1, 5);
		
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(20));
		gp.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10), new BorderWidths(10))));
		
		
		//test
//		if(lv.getSelectionModel().getSelectedItem() != null) {
//			tMarke.textProperty().bind(geschaeft.obs.get(0).getMarkeProperty());
//		}
		
		tMarke.textProperty().bindBidirectional(ks.getMarkeProperty());
		
		vb1.getChildren().addAll(gp,fp1);
		setRight(vb1);
}

	
	
}