/**
 * 
 */
package at.application.model;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class Player extends PlayableObject{

	/**
	 * @param tT
	 * @param bT
	 * @param uT
	 * @param cheat
	 * @param startField
	 */
	public Player(boolean cheat, int pos){
		super(10, 8, 4, cheat, pos, pos);
	}

}
