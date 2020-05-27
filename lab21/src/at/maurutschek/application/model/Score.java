/**
 * 
 */
package at.maurutschek.application.model;

import java.io.Serializable;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class Score implements Serializable{

	private static final long serialVersionUID = 4515919378821823833L;
	private String name;
	private int versuche;
	private int sl, sb;

	public Score(String name, int versuche, int sl, int sb){
		setName(name);
		setVersuche(versuche);
		setSb(sb);
		setSl(sl);
	}

	public int getSl(){
		return sl;
	}

	public void setSl(int sl){
		this.sl = sl;
	}

	public int getSb(){
		return sb;
	}

	public void setSb(int sb){
		this.sb = sb;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getVersuche(){
		return versuche;
	}

	public void setVersuche(int versuche){
		this.versuche = versuche;
	}

	@Override
	public String toString(){
		return "Name=" + name + ", Versuche=" + versuche + ",Spielfled=" + sl + "x" + sb;
	}

}
