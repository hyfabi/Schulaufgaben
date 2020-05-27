package application.controll;

import application.model.Geschaeft;
import application.model.Kleidungsstueck;
import application.view.MyPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;


public class Handler implements EventHandler<ActionEvent>{

	String data;
	MyPane mp;
	Geschaeft ge;
	
	public Handler(MyPane mp, Geschaeft ge) {
		
		this.mp = mp;
		this.ge = ge;
	}
	
	@Override
	public void handle(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() instanceof MenuItem) {
			data = String.valueOf(((MenuItem) ae.getSource()).getUserData());
		}
		
		switch (data) {
		
		
		//case "Add": ge.obs.add(new Kleidungsstueck(mp.tMarke.getText(),mp.cpFarbe.getValue(),mp.dp.getValue(),mp.cbGroesse.getValue(),true,Integer.parseInt(mp.tPreis.getText())));System.out.println(ge.obs.toString());;break;
	
	}

	
}
}
