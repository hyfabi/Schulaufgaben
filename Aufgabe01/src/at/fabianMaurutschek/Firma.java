package at.fabianMaurutschek;

public class Firma {
	Mitarbeiter[] angestellte = new Mitarbeiter[20];
	
	public void anstellen(Mitarbeiter m) {//Dies funktioniert nur wenn es keine lücken im arry gibt
		for(int i = 0; i < angestellte.length; i++) {
			if(angestellte[i] == null) {//Überprüfen ob es einen freien platz gibt
				angestellte[i] = m;
				return;
			}else if(angestellte[i].equals(m)){
				System.out.println("Mitarbeiter schon vorhanden");// <- Selbsterklärend
				return;
			}
		}
		System.out.println("Keine freien PLätze mehr vorhanden!"); //das auch
	}
	
	public boolean kuendigen(String nachname, String vorname) {
		for(int i = 0; i < angestellte.length &&angestellte[i] != null; i++) {
			if(angestellte[i].getNachname() == nachname && angestellte[i].getVorname() == vorname ) {
				//schiebe alle anderen mitarbeiter im array um eins nach vorn
				for(int x = i; x < angestellte.length && angestellte[x] != null;x++) { //überprüfe beim verschieben ob es einen mitarbeiter gibt den man verschieben will
					angestellte[x] = angestellte[x+1]; 
				}
				return true; // hier wird die methode geschlossen
			}
		}
		return false; // hier auch falls er keinen findet
	}
	
	public Mitarbeiter teuerster() {
		int max = 0;
		for(int i = 0; i < angestellte.length && angestellte[i] != null; i++) {// ermittle was das größte gehalt ist
			if(angestellte[i].getGehalt()>max) {
				max = angestellte[i].getGehalt();
			}
		}
		for(int i = 0; i < angestellte.length && angestellte[i] != null; i++) { //ermittle zu wem das größte gehalt zählt
			if(angestellte[i].getGehalt() == max) {
				return angestellte[i]; //gib den mitarbeiter(mit dem größten gehalt zurück (+methode wird dadurch beendet)
			}
		}
		return null; //fehler falls es keinen mitarbeiter gibt
	}
	
	public void anzeigen() { // ich wusste nicht genau was wir da machen mussten
		System.out.println("Alle Mitarbeiter:");
		for(int i = 0; i < angestellte.length && angestellte[i] != null; i++) {
			angestellte[i].ausgeben();
		}
		System.out.println("Teuerster Mitarbeiter:");
		teuerster().ausgeben();
	}
}
