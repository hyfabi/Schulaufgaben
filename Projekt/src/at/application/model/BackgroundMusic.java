/**
 * 
 */
package at.application.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class BackgroundMusic{

	ArrayList<String> paths = new ArrayList<>();
	int songList;
	MediaPlayer mp;

	public BackgroundMusic(){
		super();
		searchForMusic();
		paths = mix(paths);
		start();
	}

	public void start(){
		Media m = new Media(new File(paths.get(songList)).toURI().toString());
		mp = new MediaPlayer(m);

		mp.setOnEndOfMedia(() -> {
			System.out.println("finished");
		});
		mp.play();
	}

	public static ArrayList<String> mix(ArrayList<String> a){
		ArrayList<String> oldA = new ArrayList<>(a);
		ArrayList<String> newA = new ArrayList<>();
		Random rnd = new Random();
		for(int i = 0; i < a.size(); i++)
			newA.add(oldA.remove(rnd.nextInt(oldA.size())));
		return newA;
	}

	private void searchForMusic(){
		File f = new File(System.getProperty("user.dir") + "\\res\\bgmusic");
		if(f.exists() && f.isDirectory()){
			for(File x : f.listFiles())
				if(x.isFile())
					paths.add(x.getAbsolutePath());
		}else
			throw new RuntimeException();
	}

}
