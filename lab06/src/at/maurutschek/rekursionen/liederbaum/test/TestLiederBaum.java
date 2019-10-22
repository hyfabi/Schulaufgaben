package at.maurutschek.rekursionen.liederbaum.test;

import at.maurutschek.rekursionen.liederbaum.data.Lied;
import at.maurutschek.rekursionen.liederbaum.data.LiederBaum;

/**
 * Testklasse für Lied/LiederBaumKnoten/Liederbaum. Überprüft alle Methoden
 * 
 * @author Fabian Maurutschek
 *
 */
public class TestLiederBaum {

	public static void main(String[] args) throws Exception {
		Lied l1 = new Lied("b", "a b", "C:\\", 100);
		LiederBaum lb = new LiederBaum(l1);
		System.out.println(lb.vorhanden(l1));
		System.out.println(lb.add(new Lied("a", "a b", "C:\\", 100)));
		System.out.println(lb.add(new Lied("c", "a b", "C:\\", 100)));
		System.out.println(lb.add(new Lied("d", "a b", "C:\\", 100)));
		lb.ausgeben();
		System.out.println(lb.sumLiederLaenge());
	}
}
