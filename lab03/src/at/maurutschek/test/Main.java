package at.maurutschek.test;

import at.maurutschek.daten.Lied;
import at.maurutschek.daten.LiederListknoten;
import at.maurutschek.daten.Liederliste;

public class Main {

	public static void main(String[] args) {
		
		
		Lied	l1 = new Lied(),
				l2 = new Lied(),
				l3 = new Lied(),
				l4 = new Lied();
		
		LiederListknoten lk4 = new LiederListknoten(l4, null),
						lk3 = new LiederListknoten(l3, lk4),
						lk2 = new LiederListknoten(l2, lk3),
						lk1 = new LiederListknoten(l1, lk2);
		
		Liederliste l = new Liederliste(lk1);
		
//		String t = "";
//        for(int y = 0; y < args.length;y++) {
//             t += args[y];
//        }
//        String[] pay = t.split("-");
//        for(int f = 0; f < pay.length; f += 3) {
//            System.out.println(l.add(new Lied(args[f],args[f+1] + " " +  args[f+2])));
//        }
		
		System.out.println(l.add(new Lied("Lol", "F M")));
		System.out.println(l.addNachlaenge(new Lied("Lol", "F M", "D:", 428)));
		System.out.println(l.del(l3));
		System.out.println(l.anzLieder());
		System.out.println("");
	}

}
