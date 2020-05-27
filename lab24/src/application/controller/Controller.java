/**
 * 
 */
package application.controller;

import application.model.Art;
import application.model.Kunde;
import application.view.RootPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab24
 *
 */
public class Controller implements EventHandler<Event>, ChangeListener<Art>{

	RootPane rp;

	public Controller(RootPane rp){
		this.rp = rp;
	}

	@Override
	public void handle(Event event){
		if(event instanceof MouseEvent){
			showBestellungen();
			return;
		}
		if(event.getSource() instanceof Node){
			String s = (String) ((Node) (event.getSource())).getUserData();
			switch(s){

			}
			return;
		}

	}

	private void showBestellungen(){
		rp.getLvBestellungen().getItems().clear();
		if(rp.getLvKunden().getSelectionModel().getSelectedItem() != null)
			rp.getLvBestellungen().getItems().addAll(
						rp.getLvKunden().getSelectionModel().getSelectedItem().getBestellungen());
	}

	@Override
	public void changed(ObservableValue<? extends Art> observable,
						Art oldValue,
						Art newValue){
		rp.getLvKunden().getItems().clear();
		for(Kunde k : rp.getKv().getKunden())
			if(k.getArt() == newValue)
				rp.getLvKunden().getItems().add(k);
	}

}
