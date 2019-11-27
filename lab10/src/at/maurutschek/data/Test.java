package at.maurutschek.data;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab10
 *
 */
public class Test{

	public static void main(String[] args){
		Test t = new Test();
		t.generiereSchueler(
					"Hans Huber 2EHIF Faecher Mathematik:1 Deutsch:2 POS:4 Englisch:2 Biologie:4 Geographie:0 BSP:1");
	}

	public Schueler generiereSchueler(String s){
		ArrayList<Fach> faecher = new ArrayList<Fach>();
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
		return new Schueler(eSc[0] + " " + eSc[1], LocalDate.now().minusYears(12), eSc[2], faecher);
	}
}
