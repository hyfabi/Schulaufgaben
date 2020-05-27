/**
 * 
 */
package at.application.model;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public abstract class Ai{
	GameHandler gh;

	public Ai(GameHandler gh){
		super();
		this.gh = gh;

	}

	public abstract void run();

	// id = Feld-1

}
