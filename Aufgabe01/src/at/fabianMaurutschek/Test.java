package at.fabianMaurutschek;

/**
 * 
 * @author Fabian Maurutschek
 * 
 * Wofür brauchen wir einen Testklasse?:
 * 
 * Diese Klasse wird bald "Main" heißen in dieser ist die lägendere main() methode enthalten. Die methode
 * wird ausgeführt wenn man den startknopf (der grüne links oben) drückt. In dem fall wollen wir testen ob man
 * keine fehler im code hat und deswegen benutzen wir die main() um alle anderen methoden von Mitarbeiter und
 * Firma zu überprüfen.
 *
 */
public class Test {

	public static void main(String[] args) {
		System.out.println("Mitarbeitertest: "); //Überprüfen ob man Mitarbeiter erstellen kann
		Mitarbeiter m1 = new Mitarbeiter("ab", "cd", 1, 100),
					m2 = new Mitarbeiter("ef", "gh", 1, 200),//4x
					m3 = new Mitarbeiter("ij", "kl", 1, 100),
					m4 = new Mitarbeiter("mn", "op", 1, 100);
		m1.ausgeben();//Die ausgeben Methode von verschieden Mitarbeitern
		m2.ausgeben();
		System.out.println("Firmatest");
		Firma f = new Firma(); // Die Firma wird erstellt
		f.anstellen(m1);//Alle Mitarbeiter werden zur Firma hinzugefügt (eingestellt)
		f.anstellen(m2);
		f.anstellen(m3);
		f.anstellen(m4);
		
		System.out.println("Kündigen funktioniert?: " + f.kuendigen("ab", "cd")); //Zum testen wird einer gekündigt
		f.anzeigen(); //Und de anzeigen methode der firma wird aufgerufen
	}

}
