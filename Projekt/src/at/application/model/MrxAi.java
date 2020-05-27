/**
 * 
 */
package at.application.model;

import java.util.Random;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class MrxAi extends Ai{

	Mrx m;
	Player[] players;

	GameFieldButtonData g;

	public MrxAi(GameHandler gh, Mrx m, Player[] players){
		super(gh);
		this.m = m;
		this.players = players;
	}

	@Override
	public void run(){
		g = getButtonData();
		driveRandom();
	}

	protected void drive(int i){
		System.out.println(i);
		GameFieldButtonData gfbdZ = gh.gv.gf.bf.getButtons().get(i).g;
		GameFieldButtonData gfbd = gh.gv.gf.bf.getButtons().get(m.getField() - 1).g;
		boolean driven = false;
		if(gfbd.isUnderground() && gfbdZ.isUnderground()){
			for(int i1 : gfbd.uC)
				if(i1 + 1 == gfbdZ.number && m.getuT() > 0){
					driven = true;
					m.driveU();
					m.drive(gfbdZ.getNumber(), 'u', 0);
				}
		}else if(gfbd.isBus() && gfbdZ.isBus()){
			for(int i1 : gfbd.bC)
				if(i1 + 1 == gfbdZ.number && m.getbT() > 0){
					driven = true;
					m.driveB();
					m.drive(gfbdZ.getNumber(), 'b', 0);
				}
		}else{
			for(int i1 : gfbd.tC)
				if(i1 + 1 == gfbdZ.number && m.gettT() > 0){
					m.driveT();
					driven = true;
					m.drive(gfbdZ.getNumber(), 't', 0);// TODO: turn
				}
		}
		// TODO: Vllt etwas optimieren HEHEu
		if(!driven)
			driveRandom();
		if(Main.DEBUG)
			System.out.println("Test: " + i + " " + driven);
	}

	private GameFieldButtonData getButtonData(){
		return gh.gv.gf.bf.getButtons().get(m.getField() - 1).g;
	}

	private void driveRandom(){
		Random rnd = new Random();
		int rn = rnd.nextInt();
		if(rn < 0)
			rn *= -1;
		int x = rn % 3;
		if(x == 0 && g.isUnderground())
			driveRandom(g.uC);
		else if(x == 1 && g.isBus())
			driveRandom(g.bC);
		else
			driveRandom(g.tC);
	}

	private void driveRandom(int[] i){
		if(i.length < 2)
			driveRandom();
		Random rnd = new Random();
		int x = Math.abs(rnd.nextInt()) % i.length;
		if(check(i[x]))
			driveRandom();
		else
			drive(i[x]);
	}

	private boolean check(int i){
		for(Player p : players)
			if(p.getField() == (i + 1))
				return true;
		return false;
	}

}
