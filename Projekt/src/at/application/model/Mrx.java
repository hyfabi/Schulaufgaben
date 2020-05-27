/**
 * 
 */
package at.application.model;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class Mrx extends PlayableObject implements Serializable{

	private static final long serialVersionUID = 3223634999053727283L;
	private int black;
	private ObservableList<MrxListItem> lastFields;

	public Mrx(boolean cheat, int startField, int black){
		super(4, 3, 3, cheat, startField, startField);
		this.black = black;
		ArrayList<MrxListItem> m = new ArrayList<>();
		lastFields = FXCollections.observableList(m);
	}

	public void addCard(char a){
		switch(a){
			case 't':
				tT++;
			break;
			case 'b':
				bT++;
			break;
			case 'u':
				uT++;
			break;
		}
	}

	public ObservableList<MrxListItem> getLastFields(){
		return lastFields;
	}

	public void drive(	int n,
						char kind,
						int turn){
		lastFields.add(new MrxListItem(n, kind, turn));
	}

	public int getBlack(){
		return black;
	}

	public class MrxListItem{
		public int field;
		public char kind;
		public int turn;

		public MrxListItem(int field, char kind, int turn){
			super();
			this.field = field;
			this.kind = kind;
			this.turn = turn;
		}

		@Override
		public String toString(){
			String art = "";
			switch(kind){
				case 'u':
					art = "U-Bahn";
				break;
				case 'b':
					art = "Bus";
				break;
				case 't':
					art = "Taxi";
				break;
			}
			return art;
		}

	}
}
