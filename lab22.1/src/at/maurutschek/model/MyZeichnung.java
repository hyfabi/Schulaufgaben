/**
 * 
 */
package at.maurutschek.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.TextArea;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab22.1
 *
 */
public class MyZeichnung implements Serializable{
	private static final long serialVersionUID = -87486013665954525L;
	ArrayList<MyShape> shapes = new ArrayList<>();
	TextArea ta;

	public MyZeichnung(TextArea ta){
		this.ta = ta;
	}

	private void akt(){
		for(MyShape m : shapes){
			ta.setText(ta.getText() + "\n" + m);
		}
	}

	public void add(MyShape m){
		if(!shapes.contains(m))
			shapes.add(m);

		akt();
	}

	public void save(File f) throws IOException{
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(MyShape m : shapes)
			oos.writeObject(m);
		oos.close();
		fos.close();
	}

	public void read(File f) throws Exception{
		FileInputStream fos = new FileInputStream(f);
		ObjectInputStream oos = new ObjectInputStream(fos);
		try{
			shapes.clear();
			while(true)
				shapes.add((MyShape) oos.readObject());
		}catch(Exception e){
			if(!(e instanceof NullPointerException))
				throw e;
		}

		oos.close();
		fos.close();
		ta.setText("");
		akt();
	}

	public void sortByX(){
		shapes.sort((	x1,
						x2) -> {
			return (int) (x1.getX() - x2.getX());
		});
		ta.setText("");
		akt();
	}

}
