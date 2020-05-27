package at.maurutschek.application.model;

import java.util.ArrayList;
import java.util.Random;

import at.maurutschek.application.view.Main;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab21
 *
 */
public class Resources{
	public ArrayList<ImageView> images;

	public Resources(){
		images = new ArrayList<>();
		load();
		rotate();
	}

	/**
	 * 
	 */
	private void rotate(){
		if(images == null)
			return;
		RotateTransition r = new RotateTransition(Duration.ONE);
		for(ImageView i : images){
			r = new RotateTransition(Duration.millis(1), i);
			r.setAxis(new Point3D(0, 100, 0));
			r.setByAngle(180);
			r.play();
			if(Main.DEBUG)
				System.out.println("r");
			i.setTranslateX(20);
		}
	}

	public ArrayList<ImageView> getImages(){
		return images;
	}

	private void load(){
		for(int i = 1; i <= 50; i++){
			System.out.println(i);
			try{
				images.add(new ImageView("" + i + ".jpg"));
			}catch(Exception e){
				try{
					images.add(new ImageView("" + i + ".JPG"));
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}

		}
	}

	public ArrayList<ImageView> getPics(int anz){
		ArrayList<ImageView> a = new ArrayList<>(), temp = (ArrayList<ImageView>) images.clone();

		Random rnd = new Random();

		for(int i = 0; i < anz; i++){
			a.add(temp.remove(rnd.nextInt(temp.size())));
		}
		return a;
	}
}
