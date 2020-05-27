/**
 * 
 */
package at.maurutschek.application.controller;

import at.maurutschek.application.model.Karte;
import at.maurutschek.application.view.Main;
import javafx.animation.Animation.Status;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class CardController implements EventHandler<MouseEvent>{
	private Karte k1, k2;
	public boolean allowAccess = true;

	public CardController(){
		allowAccess = true;
	}

	// TODO optimize
	@Override
	public void handle(MouseEvent event){
		Karte o = (Karte) event.getSource();
		if(event.getSource().equals(k1) || event.getSource().equals(k2)
					|| o.getR().getStatus() == Status.RUNNING || o.isAufgedeckt())
			return;
		if(Main.DEBUG)
			System.out.println(event.getSource());
		if(!allowAccess)
			return;
		if(k1 == null){
			k1 = (Karte) event.getSource();
			if(k1.getR().getStatus() == Status.STOPPED)
				k1.startAnimation(false);
			return;
		}

		k2 = (Karte) event.getSource();
		if(k2.getR().getStatus() == Status.STOPPED)
			k2.startAnimation(false);
		allowAccess = false;
		validate();
	}

	private void validate(){
		Main.root.sv.s.trys++;
		PauseTransition p = new PauseTransition(Duration.millis(k1.getR().getRate() + 1000));
		p.setOnFinished((x) -> {
			if(k1.getImgId() == k2.getImgId()){
				correct();
				return;
			}
			if(k1.getR().getStatus() == Status.STOPPED)
				k1.startAnimation(true);
			if(k2.getR().getStatus() == Status.STOPPED)
				k2.startAnimation(true);
			this.k1 = null;
			this.k2 = null;
		});
		p.play();
	}

	private void correct(){
		allowAccess = true;
		k1.setAufgedeckt(true);
		k2.setAufgedeckt(true);
		this.k1 = null;
		this.k2 = null;
		Main.root.sv.s.corect();
	}
}
