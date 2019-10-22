package at.maurutschek.rekursionen.myutil;

import java.io.File;

/**
 * 
 * @author spamm
 *
 */
public class Test {

	public static int[] array = { 4, 6, 9, 16, 20, 21, 22, 32, 45, 48, 50, 51, 59, 67, 77, 81, 84, 90 };

	public static void main(String[] args) {
		Rekursionen r = new Rekursionen();
		File f = new File(System.getProperty("user.dir"));

		r.listFiles(f, "");
		System.out.println(r.getGroesse(f));
		for (int i = 0; i <= 91; i++)
			r.binSuche(array, i);
	}
}