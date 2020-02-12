/**
 * 
 */
package lvl2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Lvl1
 *
 */
public class Main{

	int places = 0;
	int totalCars;
	ArrayList<Integer> time = new ArrayList<>();
	HashMap<Integer, Integer> gewicht = new HashMap<>();
	ArrayList<Integer> cars = new ArrayList<>();
	ArrayList<Integer> kosten = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Main m = new Main();
		m.input3(new File("C:\\Users\\spamm\\OneDrive\\Desktop\\input.1"));
		System.out.println(m.start4());
		System.out.print(Math.ceil(m.gewicht.get(4) / 100));
	}

	/**
	 * @return
	 */
	private String start4(){

		int sum = 0;
		ArrayList<Integer> w = new ArrayList<>();
		int[] ar = new int[this.places];
		for(int i : time){
			if(i > 0){
				if(ar[ar.length - 1] != 0)
					w.add(i);
				for(int i1 = 0; i1 < ar.length; i1++){
					if(ar[i1] == 0){
						ar[i1] = i;
						sum += (int) (kosten.get(i1) * (Math.ceil(gewicht.get(i) / 100)));
						break;
					}
				}

			}else if(i < 0){
				for(int i1 = 0; i1 < ar.length; i1++){
					if(ar[i1] == i * -1){
						ar[i1] = 0;
						break;
					}
				}
				if(w.size() > 0){
					for(int i1 = 0; i1 < ar.length; i1++){
						if(ar[i1] == 0){
							ar[i1] = w.remove(0);
							sum += (int) (kosten.get(i1)
										* (Math.ceil(gewicht.get(ar[i1]) / 100)));
							break;
						}
					}
				}
			}
		}

		return "" + sum;
	}

	/**
	 * @return
	 */
	private String start3(){
		int sum = 0;
		ArrayList<Integer> w = new ArrayList<>();
		int[] ar = new int[this.places];
		for(int i : time){
			if(i > 0){
				if(ar[ar.length - 1] != 0)
					w.add(i);
				for(int i1 = 0; i1 < ar.length; i1++){
					if(ar[i1] == 0){
						ar[i1] = i;
						sum += kosten.get(i1);
						break;
					}
				}

			}else if(i < 0){
				for(int i1 = 0; i1 < ar.length; i1++){
					if(ar[i1] == i * -1){
						ar[i1] = 0;
						break;
					}
				}
				if(w.size() > 0){
					for(int i1 = 0; i1 < ar.length; i1++){
						if(ar[i1] == 0){
							ar[i1] = w.remove(0);
							sum += kosten.get(i1);
							break;
						}
					}
				}
			}
		}

		return "" + sum;
	}

	/**
	 * @return
	 */
	private String start2(){
		int wMax = 0, gMax = 0, wNow = 0, gNow = 0;
		for(Integer i : time){
			if(wMax < wNow)
				wMax = wNow;
			if(gMax < gNow)
				gMax = gNow;
			if(i > 0)
				if(gNow == places)
					wNow++;
				else
					gNow++;
			if(i < 0){
				gNow--;
				if(wNow > 0){
					wNow--;
					gNow++;
				}
			}

		}

		return "" + gMax + " " + wMax;
	}

	/**
	 * 
	 */
	private int start1(){
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

	public void input3(File f){
		Scanner s;
		String a = "";
		String a1[];
		try{
			s = new Scanner(f);
			a = s.nextLine();

			a1 = a.split(" ");
			places = Integer.parseInt(a1[0]);
			totalCars = Integer.parseInt(a1[1]);

			for(int i : time)
				if(i > 0)
					cars.add(i);

			a = s.nextLine();
			a1 = a.split(" ");
			for(String s1 : a1)
				kosten.add(Integer.parseInt(s1));

			a = s.nextLine();
			String[] aw = a.split(" ");

			a = s.nextLine();
			a1 = a.split(" ");
			for(String s1 : a1)
				time.add(Integer.parseInt(s1));

			for(int i : time)
				if(i > 0)
					cars.add(i);

			for(int i = 0; i < cars.size(); i++){
				gewicht.put(cars.get(i), Integer.parseInt(aw[i]));
			}

			s.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
