/**
 * 
 */
package at.application.model;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public abstract class PlayableObject{
	protected int tT, bT, uT;
	private boolean cheat;
	private int startField;
	private int field;

	public PlayableObject(int i, int j, int k, boolean cheat, int startField, int field){
		super();
		this.tT = i;
		this.bT = j;
		this.uT = k;
		this.cheat = cheat;
		this.startField = startField;
		this.field = field;
	}

	public int getField(){
		return field;
	}

	public void setField(int field){
		if(field > 0 && field < 200)
			this.field = field;
		else
			throw new RuntimeException();
	}

	public int gettT(){
		return tT;
	}

	public boolean driveT(){
		if(tT > 0){
			this.tT--;
			return true;
		}
		return false;
	}

	public int getbT(){
		return bT;
	}

	public boolean driveB(){
		if(bT > 0){
			this.bT--;
			return true;
		}
		return false;
	}

	public int getuT(){
		return uT;
	}

	public boolean driveU(){
		if(uT > 0){
			this.uT--;
			return true;
		}
		return false;
	}

	public boolean isCheat(){
		return cheat;
	}

	public int getStartField(){
		return startField;
	}

}
