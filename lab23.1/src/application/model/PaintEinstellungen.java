/**
 * 
 */
package application.model;

import java.io.File;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class PaintEinstellungen{
	private ImageView maus, katze, gefangen, plan;
	private Einstellungen e;

	public ImageView getMaus(){
		if(maus == null)
			maus = new ImageView("3.jpg");
		maus.setFitWidth(50);
		maus.setFitHeight(50);
		return maus;
	}

	public void setMaus(){
		getE().getAktE().setpM(dialog().getAbsolutePath());
		maus = new ImageView("file:///" + getE().getAktE().getpM());
	}

	public ImageView getKatze(){
		if(katze == null)
			katze = new ImageView("1.jpg");
		katze.setFitWidth(50);
		katze.setFitHeight(50);
		return katze;
	}

	public void setKatze(){
		getE().getAktE().setpK(dialog().getAbsolutePath());
		katze = new ImageView("file:///" + getE().getAktE().getpK());
	}

	public ImageView getPlan(){
		if(plan == null)
			plan = new ImageView("4.png");
		plan.setFitWidth(50);
		plan.setFitHeight(50);
		return plan;
	}

	public void setPlan(){
		getE().getAktE().setpP(dialog().getAbsolutePath());
		plan = new ImageView("file:///" + getE().getAktE().getpP());
	}

	public double getOpacity(){
		return getE().getAktE().getOpacity();
	}

	public void setOpacity(){
		getE().getAktE().setOpacity(0);
	}

	public File dialog(){
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("./res/"));
		return fc.showOpenDialog(null);
	}

	public PaintEinstellungen(){
		e = new Einstellungen();
	}

	public ImageView getGefangen(){
		if(gefangen == null)
			gefangen = new ImageView("2.jpg");
		gefangen.setFitWidth(50);
		gefangen.setFitHeight(50);
		return gefangen;
	}

	public void setGefangen(){
		getE().getAktE().setpG(dialog().getAbsolutePath());
		gefangen = new ImageView("file:///" + getE().getAktE().getpG());
	}

	/**
	 * @return the e
	 */
	public Einstellungen getE(){
		return e;
	}

	/**
	 * @param e
	 *        the e to set
	 */
	public void setE(Einstellung e){
		this.e.setAktE(e);
	}

}
