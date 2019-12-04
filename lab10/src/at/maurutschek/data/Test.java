package at.maurutschek.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab10
 *
 */
public class Test{

	public static void main(String[] args){
		Test t = new Test();
		Schule s = new Schule();
		Schueler s1 = t.generiereSchueler(
					"Hans Huber 2EHIF Faecher Mathematik:1 Deutsch:2 POS:4 Englisch:2 Biologie:4 Geographie:0 BSP:1"),
					s2 = t.generiereSchueler(
								"Anna Schmied 2AHIF Faecher Mathematik:3 Deutsch:1 POS:1 Englisch:2 Biologie:4 Geographie:3 BSP:1");
		s.addSchueler(s1);
		System.out.println(s.getSchueler(s1.getSchluessel()));
		System.out.println(s2.besteFaecher());
	}

	public Schueler generiereSchueler(String s){
		Random rnd = new Random();
		ArrayList<Fach> faecher = new ArrayList<>();
		String fs = s.substring(s.indexOf("Faecher") + 8);
		String[] f = fs.split(" ");
		for(String eF : f){
			String[] eeF = eF.split(":");
			try{
				faecher.add(new Fach(Byte.parseByte(eeF[1]), eeF[0]));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		String[] eSc = s.trim().split(" ");
		System.out.println();
		return new Schueler(eSc[0] + " " + eSc[1],
					LocalDate.now().minusYears(10).minusDays(rnd.nextInt(365 * 5)), eSc[2],
					faecher);
	}
}
