package at.maurutschek.test;

import at.maurutschek.daten.Lied;
import at.maurutschek.daten.Liederverwaltung;

/**
 * Lab 02 POS: Lied, Liederverwaltung, Main(Test)
 * @author Fabian Maurutschek
 * @version v1
 */
public class Test {

	/**
	 * Testen von Liederverwaltung- und Lied-Methoden
	 */
	public static void main(String[] args) {
		
		//Lied-Test
		System.out.println("Lied Test:");
		//Erstelle Lied
		Lied l0 = new Lied();
		//Teste Lied.setInterpret()
		l0.setInterpret("123 456");
		//Teste Lied.ausgeben()
		l0.ausgeben();
		
		
		//Liederverwaltung-Test
		System.out.println("Liederverwaltung Test:");
		
		//Erstelle 1 Liederverwaltung
		Liederverwaltung lv = new Liederverwaltung(15);
		
		//Erstelle Lieder
	    Lied l1 = new Lied("a", "bc c","D:",500), 
			 l2 = new Lied(), 
			 l3 = new Lied("fd","d c");
		
		//Füge Lieder zur Liederverwaltungsarray hinzu
		lv.add(l1);
		lv.add(l2);
		lv.add(l3);
		lv.add(new Lied("xyz","Fabian Maurutschek"));
		
		//Lösche ein Lied ( l2 )
		lv.del(l2.getTitel());
		
		//Ausgeben von allen vorhandenen Liedern
		lv.ausgeben();
		
		//Sortieren nach Länge (+ausgeben)
		System.out.println("Sortieren nach Länge:");
		lv.sortByLaenge();
		lv.ausgeben();
		
		//Sortieren nach Titel (+ausgeben)
		System.out.println("Sortieren nach Titel:");
		lv.sortByName();
		lv.ausgeben();
	}

}
