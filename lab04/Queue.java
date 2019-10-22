package at.maurutschek.data;

public class Queue {

	private Lied[] queue;
	private int freiePos;

	public Queue(int maxGroesse) {
		if (maxGroesse > 0) {
			queue = new Lied[maxGroesse];
		} else {
			queue = new Lied[100];
		}
	}

	public Queue() {
		queue = new Lied[100];
	}

	public Lied enqueue(Lied s) {
		if (freiePos >= 0 && freiePos < queue.length) {
			queue[freiePos] = s;
			freiePos++;
			return s;
		} else {
			return null;
		}
	}

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

	public void printAllElements() {
		for (int i = 0; i < freiePos; i++) {
			System.out.println("Stelle: " + i);
			System.out.println(queue[i].toString());
		}
	}

	public void printFreiePos() {
		System.out.println("FreiePos:");
		System.out.println(freiePos);
	}
}
