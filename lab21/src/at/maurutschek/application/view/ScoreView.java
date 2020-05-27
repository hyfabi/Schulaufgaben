/**
 * 
 */
package at.maurutschek.application.view;

import at.maurutschek.application.model.Score;
import at.maurutschek.application.model.Scores;
import javafx.scene.control.TextArea;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class ScoreView extends TextArea{
	public Scores s;
	public int felder;

	public ScoreView(int felder, Finished f){
		s = new Scores(felder, this, f);
		this.felder = felder;
		init();
	}

	/**
	 * 
	 */
	public void reload(){
		for(Score sc : s.scores)
			setText(getText() + "\n" + sc.toString());
	}

	private void init(){
		setEditable(false);
		reload();
	}

}
