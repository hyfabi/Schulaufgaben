/**
 * 
 */
package at.application.model;

import java.util.ArrayList;

import at.application.view.ButtonField;
import at.application.view.GameFieldButton;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class DetectiveAi extends Ai{

	// Phase 1 get mobiliy

	private int lastSeenLoaction;
	ArrayList<GameFieldButton> fields;
	Player[] p;
	Player pN;

	public DetectiveAi(GameHandler gh){
		super(gh);
		fields = new ArrayList<>(gh.gv.gf.bf.getButtons());
		run();
	}

	public DetectiveAi(GameHandler gh, ArrayList<GameFieldButton> fields){
		super(gh);
		this.fields = fields;
	}

	/**
	 * 
	 */
	@Override
	public void run(){
		if(lastSeenLoaction == 0)
			getMobility();
	}

	/**
	 * 
	 */
	private void getMobility(){
		getNearestU();
	}

	private void getNearestU(){

	}

	private ArrayList<Integer> calcEffitientWay(GameFieldButtonData n){
		ArrayList<Integer> f = new ArrayList<>();
		for(GameFieldButton g : fields){
			GameFieldButtonData d = g.g;
			if(n.isUnderground() && fields.get(pN.getField() + 1).g.isUnderground())
				cEWU(n, fields.get(pN.getField() + 1).g);
		}
		return f;
	}

	public static void main(String[] args){
		ButtonField bf = new ButtonField();
		DetectiveAi da = new DetectiveAi(null, bf.getButtons());
	}

	/**
	 * 
	 */
	private ArrayList<Integer> cEWU(GameFieldButtonData t,
									GameFieldButtonData z){
		ArrayList<Integer> f = new ArrayList<>();
		int a = 0;
		for(int i : t.uC){
			if(i == z.getNumber())
				return f;
			f.remove(f.size() - 1);
			f.add(i);
			for(int i1 : fields.get(pN.getField() + 1).g.uC){
				if(i == z.number)
					return f;
				f.remove(f.size() - 1);
				f.add(i1);
			}
		}
		return f;
	}

}
