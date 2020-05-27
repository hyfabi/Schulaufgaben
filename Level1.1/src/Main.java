import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Fabian Maurutschek
 * @version 1.0 Level1.1
 *
 */
public class Main{
	boolean d = false, p;
	ArrayList<People> people;

	public static void main(String[] args){
		Main m = new Main();
	}

	public Main(){
		try{
			Scanner s = new Scanner(new File("C:\\Users\\spamm\\OneDrive\\Desktop\\level1_1.log"));
			while(s.hasNextLine())
				p(s.nextLine());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}

	public void p(String s){
		try{
			int i = Integer.parseInt(s);
			if(!d)
				d = true;
			if(d)
				p = true;
		}catch(Exception e){
			if(!d)
				people.add(new People(s));
			if(d){
				String[] a = s.split(" ");
				for(int i = 0; i < people.size(); i++)
					if(people.get(i).name == a[0])
						people.get(i).follower.add(a[2]);
			}
		}

	}
}
