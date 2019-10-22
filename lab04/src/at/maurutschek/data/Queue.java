package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1
 * 
 * Bei der Queue werden Lieder welche zuerst hinzugefügt werden als erstes gelöscht
 * 
 */
public class Queue {

	private Lied[] queue;
	private int freiePos;

	/**
	 * Konstruktor
	 * @param maxGroesse: Freie Plätze im Array
	 */
	public Queue(int maxGroesse) {
		if (maxGroesse > 0) {
			queue = new Lied[maxGroesse];
		} else {
			queue = new Lied[100];
		}
	}

	/**
	 * Defaultkonstruktor
	 * 100 Plätze als standart
	 */
	public Queue() {
		queue = new Lied[100];
	}

	/**
	 * Fügt ein Lied in die Queue hinein
	 * @param fügt das Lied am Ende hinzu
	 * @return Das Lied selbst falls es hinzugefügt wurde
	 */
	public Lied enqueue(Lied s) {
		if (freiePos >= 0 && freiePos < queue.length) {
			queue[freiePos] = s;
			freiePos++;
			return s;
		} else {
			return null;
		}
	}

	/**
	 * Löscht das "älteste" Lied in der Queue
	 * @return das Lied oder null falls die Queue leer ist
	 */
	public Lied dequeue() {
		if (freiePos > 0 && freiePos < queue.length) {
			Lied temp = queue[0];
			queue[0] = null;
			for (int i = 0; i < freiePos; i++) {
				queue[i] = queue[i + 1];
			}
			freiePos--;
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * Name ist selbsterklärend
	 * Ausgeben von allen Liedern werden aufgerufen
	 */
	public void printAllElements() {
		for (int i = 0; i < freiePos; i++) {
			System.out.println("Stelle: " + i);
			System.out.println(queue[i].toString());
		}
	}

	/**
	 * Wird zum Debuggen meißt verwendet
	 * gibt die anzahl der Lieder zurück
	 */
	public void printFreiePos() {
		System.out.print("FreiePos:");
		System.out.print(freiePos);
	}
}
