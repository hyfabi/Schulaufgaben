import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Fabian Maurutschek
 * @version 1.0 Level1
 *
 */
public class Simulation{
	public ArrayList<Drone> drones = new ArrayList<>();
	final int targetX = -1, targetY = 0;

	public static ArrayList<ArrayList<Drone>> feld = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public static void main(String args[]){

		final int startX = 2, startY = 1;
		Drone d = new Drone(0, startX, startY, "N");
		@SuppressWarnings("unused")
		Simulation sim = new Simulation(d);

	}

	public Simulation(Drone d){
		drones.add(d);
		while(sc.hasNextLine())
			command(sc.nextLine());
	}

	public void command(String s){
		String[] a = s.split(" ");
		switch(a[0]){
			case "STATUS":
				for(Drone d : drones)
					if(d.id == Integer.parseInt(a[1])){
						System.out.println(d.toString());
					}
			break;
			case "DIRECTION":
				for(Drone d : drones)
					if(d.id == Integer.parseInt(a[1]))
						d.setDirection(a[2]);
				System.out.println("OK");
			break;
			case "SPEED":
				for(Drone d : drones)
					if(d.id == Integer.parseInt(a[1]))
						d.setSpeed(a[2]);
				System.out.println("OK");
			break;
			case "TICK":
				tick();
			break;
			default:
				sc.close();
				System.out.println("Closed");
			break;
		}
	}

	public void tick(){
		for(Drone d : drones){
			d.fahren();
			if(d.x == targetX && d.y == targetY)
				System.out.println("SUCCESS");
			else
				System.out.println("1");
		}
	}
}
