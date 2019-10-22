package at.maurutschek.daten;

/**
 * Lab 02 POS: Liederverwaltung
 * Verwaltet Lieder in Arrays für gute Speicherung
 * @author Fabian Maurutschek
 */
public class Liederverwaltung {
	private Lied[] lieder;
	private int anzahl;
	
	/**
	 * Ersetllt das Array
	 * @param maxAnzahl: Arraygröße
	 */
	public Liederverwaltung(int maxAnzahl) {
		lieder = new Lied[maxAnzahl];
	}
	
	/**
	 * Fügt ein Lied hinzu
	 * @param l: Lied welches hinzugefügt wird
	 * @return Lied
	 */
	public Lied add(Lied l) {
		lieder[anzahl] = l;
		anzahl++;
		return l;
	}
	
	/**
	 * Löscht ein Lied von dem lieder-array
	 * @param titel: Titel von dem Lied welches gelöscht werden muss
	 * @return Lied welches gelöscht wurde (null -> kein Lied laut dem param vorhanden)
	 */
	public Lied del(String titel) {
		Lied l = null;
		for(int i = 0; i < anzahl; i++) {
			if(lieder[i].getTitel() == titel) {
				l = lieder[i];
				lieder[i] = null;
				for(int x = i; x < anzahl;x++) {
					lieder[x] = lieder[x+1];
				}
				anzahl--;
				break;
			}
		}
		return l;
	}
	
	/**
	 * @return Anzahl der gespeicherten Lieder im Array (Lied != null)
	 */
	public int anzLieder() {
		return anzahl;
	}
	
	/**
	 * Array wird nach Lied.laenge sortiert
	 */
	public void sortByLaenge() { //Bubblesort
		for(int n = anzahl; n > 0; n--){
			for(int i = 0; i < n-1; i++){
				if (lieder[i].getLaenge() > lieder[i+1].getLaenge()){
					Lied l = lieder[i];
					lieder[i] = lieder[i+1];
					lieder[i+1] = l;
				}
			}
		}
	}
	
	/**
	 * Array wird nach Lieder.titel sortiert (Alphabetisch)
	 */
	public void sortByName(){ //Selectionsort
		for (int i = 0; i < anzahl - 1; i++) {
			for (int j = i + 1; j < anzahl; j++) {
				if (lieder[i].getTitel().compareTo(lieder[j].getTitel()) >= 1) {
					Lied temp = lieder[i];
					lieder[i] = lieder[j];
					lieder[j] = temp;
				}
			}
		}
	}
	
	/**
	 * Ruft Lied.ausgeben() von allen Lieder instanzen im Array auf
	 */
	public void ausgeben() {
		for(int i = 0; i < anzahl; i++) {
			lieder[i].ausgeben();
		}
	}
}
