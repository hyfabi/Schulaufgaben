/**
 * 
 */
package at.maurutschek.application.model;

import at.maurutschek.application.controller.ScoreHandling;
import at.maurutschek.application.view.Finished;
import at.maurutschek.application.view.Main;
import at.maurutschek.application.view.ScoreView;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class Scores extends ScoreHandling{
	protected int felder;
	public int trys;
	ScoreView sv;
	Finished f;

	@Override
	public void write(){
		super.write(this.scores);
	}

	public void read1(){
		this.scores.addAll(super.read());
		Main.root.sv.reload();
		Main.root.changeView();
	}

	public Scores(int felder, ScoreView scoreView, Finished f){
		this.f = f;
		this.felder = felder;
		sv = scoreView;
		if(Main.DEBUG)
			System.out.println("Felder: " + felder);

	}

	public void reload(int fe){
		this.felder = fe;

	}

	private void finished(){
		if(Main.DEBUG)
			System.out.println("Fertig");
		Score now = new Score(Main.root.g.getName(), trys, Main.root.b.getLaenge(),
					Main.root.b.getBreite());
		scores.add(now);
		f.showing(now);
		Main.root.sv.reload();
	}

	public void corect(){
		felder -= 2;
		if(felder <= 0)
			finished();
	}
}
