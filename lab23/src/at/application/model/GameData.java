/**
 * 
 */
package at.application.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class GameData implements Serializable{

	private static final long serialVersionUID = 61527006484985378L;
	public final int DETECTIVES_COUNT;
	public final boolean PLAYER_IS_PLAYING_MRX;

	public Player[] players;
	public Mrx mrx;
	public int round;

	private boolean cheat;

	public GameData(int i, boolean cheat, boolean l){
		PLAYER_IS_PLAYING_MRX = l;
		this.cheat = cheat;
		DETECTIVES_COUNT = i;
		players = new Player[DETECTIVES_COUNT + 1];

		init();
	}

	private void init(){
		ArrayList<Integer> arr = new ArrayList<>();
		while(true){
			if(arr.size() == (DETECTIVES_COUNT + 2))
				break;
			int i = ResourceLoading.getRandomStartField();
			if(!arr.contains(i))
				arr.add(i);
		}
		for(int i = 0; i < arr.size() - 1; i++)
			players[i] = new Player(cheat, arr.get(i));
		mrx = new Mrx(cheat, arr.get(arr.size() - 1), DETECTIVES_COUNT);
	}

}
