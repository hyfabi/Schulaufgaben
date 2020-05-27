/**
 * 
 */
package at.application.model;

import java.io.Serializable;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class GameFieldButtonData implements Serializable{

	private static final long serialVersionUID = -6435694617260249034L;
	private boolean underground, bus;
	public int number;
	public double x, y;
	public int[] tC, bC, uC;

	public GameFieldButtonData(	double d,
								double e,
								boolean bus,
								boolean underground,
								int i,
								int[] tC,
								int[] bC,
								int[] uC){
		x = d;
		y = e;
		this.underground = underground;
		this.bus = bus;
		this.number = i;
		this.tC = tC;
		this.bC = bC;
		this.uC = uC;
	}

	public boolean isUnderground(){
		return underground;
	}

	public void setUnderground(boolean underground){
		this.underground = underground;
	}

	public boolean isBus(){
		return bus;
	}

	public void setBus(boolean bus){
		this.bus = bus;
	}

	public int getNumber(){
		return number;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public double getX(){
		return x;
	}

	public void setX(double x){
		this.x = x;
	}

	public double getY(){
		return y;
	}

	public void setY(double y){
		this.y = y;
	}

	public static GameFieldButtonData getCopyButton(GameFieldButtonData g){
		System.out.println(g.x + " " + g.y);
		return new GameFieldButtonData(g.x, g.y, g.underground, g.bus, g.number, g.tC, g.bC, g.uC);
	}

	public static GameFieldButtonData get(String s){
		String[] arr = s.split(",");
		if(arr.length != 8)
			return null;
		return new GameFieldButtonData(Double.parseDouble(arr[1]),
					Double.parseDouble(arr[2]),
					Boolean.parseBoolean(arr[3]), Boolean.parseBoolean(arr[4]),
					Integer.parseInt(arr[0]), getArrayItems(arr[5]), getArrayItems(arr[6]),
					getArrayItems(arr[7]));
	}

	@Override
	public String toString(){
		String out = number + "," + x + "," + y + "," + bus +
					"," + underground + "," + giveListItems(tC) + "," + giveListItems(bC) + ","
					+ giveListItems(uC);
		return out;
	}

	private static int[] getArrayItems(String s){
		String[] ss = s.split(":");
		int[] arr = new int[ss.length];
		for(int i = 0; i < ss.length; i++)
			arr[i] = Integer.parseInt(ss[i]);
		return arr;
	}

	private String giveListItems(int[] arr){
		String out = "";
		for(int i : arr)
			out += i + ":";
		return out;

	}

}
