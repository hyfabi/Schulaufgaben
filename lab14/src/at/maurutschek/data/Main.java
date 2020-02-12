/**
 * 
 */
package at.maurutschek.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Lvl1
 *
 */
public class Main{

	int places;
	int totalCars;
	static ArrayList<Integer> time = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Main m = new Main();
		System.out.println(m.start());
	}

	/**
	 * 
	 */
	private int start(){
		input(new File("C:\\Users\\spamm\\OneDrive\\Desktop\\input.3"));
		int max = 0, now = 0;
		for(int i = 0; i < time.size(); i++){
			if(now > max)
				max = now;
			if(time.get(i) > 0)
				now++;
			if(time.get(i) < 0)
				now--;
		}
		return max;
	}

	public void input(File f){
		Scanner s;
		String a = "";
		try{
			s = new Scanner(f);
			a = s.nextLine();
			System.out.println(a);
			String a1[] = a.split(" ");
			places = Integer.parseInt(a1[0]);
			totalCars = Integer.parseInt(a1[1]);

			a = s.nextLine();
			System.out.println(a);
			a1 = a.split(" ");
			for(String s1 : a1)
				time.add(Integer.parseInt(s1));
			s.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
