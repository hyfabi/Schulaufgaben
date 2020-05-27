package at.application.model;

import java.util.Optional;

import at.application.internet.Client;
import at.application.internet.Server;
import at.application.view.GameFieldButton;
import at.application.view.GameView;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Border;
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
public class GameHandler{

	public GameData gd;
	public GameView gv;
	private int turn, realTurn;
	public final boolean PLAYER_IS_PLAYING_MRX;
	public Ai ai;

	public Server server;
	public Client client;

	public int getRealTurn(){
		return realTurn;
	}

	public GameHandler(GameView gv, int i, boolean cheat, boolean pipm){
		PLAYER_IS_PLAYING_MRX = pipm;
		this.gv = gv;
		gd = new GameData(i, cheat, pipm);
		if(!PLAYER_IS_PLAYING_MRX){
			ai = new MrxAi(this, gd.mrx, gd.players);
			ai.run();
		}else
			ai = new DetectiveAi(this);
		init();
	}

	public GameHandler(GameData g, GameView gv, boolean pipm){
		PLAYER_IS_PLAYING_MRX = pipm;
		this.gd = g;
		this.gv = gv;
		init();
	}

	private void init(){
		if(PLAYER_IS_PLAYING_MRX)
			turn = 0;
		else
			turn = 1;
		turn();
	}

	public void turn(){
		PlayableObject p;
		if(gd.PLAYER_IS_PLAYING_MRX){
			p = gd.mrx;
			gv.gf.paintFigures(gd.players, gd.mrx);
			gv.showCards(p.gettT(), p.getbT(), p.getuT(), turn);
			ai.run();
		}else{
			if(turn == gd.players.length){
				turn = 1;
				realTurn++;
				ai.run();
			}
			p = gd.players[turn];
			if(realTurn == 24)
				win(true);
			if(realTurn == 3 || realTurn == 8 || realTurn == 13 || realTurn == 18){
				gv.gf.paintFigures(gd.players, gd.mrx);
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText("Achtung!");
				a.setContentText("Mr. X ist sichtbar!");
				a.showAndWait();
			}else
				gv.gf.paintFigures(gd.players, null);
			gv.showCards(p.gettT(), p.getbT(), p.getuT(), turn);
		}
		// TODO: in die View verschieben
		for(GameFieldButton b : gv.gf.bf.getButtons())
			if(b.g.number != p.getField())
				b.setBorder(null);
		GameFieldButton b = gv.gf.bf.getButtons().get(p.getField() - 1);
		b.setBorder(null);
		for(int i : b.g.tC)
			if(i > 0) gv.gf.bf.getButtons().get(i - 1)
						.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
									new CornerRadii(5), new BorderWidths(2), new Insets(-1))));
		for(int i : b.g.bC)
			if(i > 0) gv.gf.bf.getButtons().get(i - 1)
						.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
									new CornerRadii(5), new BorderWidths(2), new Insets(-1))));
		for(int i : b.g.uC)
			if(i > 0) gv.gf.bf.getButtons().get(i - 1)
						.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
									new CornerRadii(5), new BorderWidths(2), new Insets(-1))));

	}

	private void check(){
		for(Player p : gd.players)
			if(p.getField() == gd.mrx.getField())
				win(false);
	}

	private void win(boolean mrx){
		Dialog<ButtonType> a = new Dialog<>();
		if((PLAYER_IS_PLAYING_MRX && mrx) || (!PLAYER_IS_PLAYING_MRX && !mrx))
			a.setHeaderText("Gewonnen!");
		else
			a.setHeaderText("Verloren!");
		ButtonType btn1 = new ButtonType("Nochmal");
		ButtonType btn2 = new ButtonType("Beenden");
		a.getDialogPane().getButtonTypes()
					.addAll(btn1, btn2);
		Optional<ButtonType> bt = a.showAndWait();
		if(bt.isPresent())
			if(bt.get().getText() == "Nochmal")
				gv = null;
			else
				Platform.exit();
	}

// TODO: catch + keine selbe Position
	public void movement(String string){
		if(gd.PLAYER_IS_PLAYING_MRX){
			Mrx m = gd.mrx;
			GameFieldButtonData gfbdZ = gv.gf.bf.getButtons().get(Integer.parseInt(string) - 1).g;
			GameFieldButtonData gfbd = gv.gf.bf.getButtons().get(m.getField() - 1).g;
			boolean driven = false;
			if(gfbd.isUnderground() && gfbdZ.isUnderground()){
				for(int i : gfbd.uC)
					if(i == gfbdZ.number && m.getuT() > 0){
						m.driveU();
						driven = true;
						m.drive(gfbdZ.getNumber(), 'u', 0);
					}
			}else if(gfbd.isBus() && gfbdZ.isBus()){
				for(int i : gfbd.bC)
					if(i == gfbdZ.number && m.getbT() > 0){
						m.driveB();
						driven = true;
						m.drive(gfbdZ.getNumber(), 'b', 0);
					}
			}else{
				for(int i : gfbd.tC)
					if(i == gfbdZ.number && m.gettT() > 0){
						m.driveT();
						driven = true;

						m.drive(gfbdZ.getNumber(), 't', 0);// TODO: turn
					}
			}
			if(driven){
				m.setField(gfbdZ.getNumber());
				gv.list.setItems(m.getLastFields());
			}

		}else{
			PlayableObject p = gd.players[turn];
			GameFieldButtonData gfbdZ = gv.gf.bf.getButtons().get(Integer.parseInt(string) - 1).g;
			GameFieldButtonData gfbd = gv.gf.bf.getButtons().get(p.getField() - 1).g;
			if(gfbd.isUnderground() && gfbdZ.isUnderground()){
				for(int i : gfbd.uC)
					if(i == gfbdZ.number && p.getuT() > 0){
						p.driveU();
						p.setField(gfbdZ.getNumber());
						turn++;
					}
			}else if(gfbd.isBus() && gfbdZ.isBus()){
				for(int i : gfbd.bC)
					if(i == gfbdZ.number && p.getbT() > 0){
						p.driveB();
						p.setField(gfbdZ.getNumber());
						turn++;
					}
			}else{
				for(int i : gfbd.tC)
					if(i == gfbdZ.number && p.gettT() > 0){
						p.driveT();
						p.setField(gfbdZ.getNumber());
						turn++;
					}
			}

		}
		check();
		turn();
	}

	public int getTurn(){
		return turn;
	}
}
