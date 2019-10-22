package at.maurutschek.test;

import at.maurutschek.data.Lied;
import at.maurutschek.data.Queue;

/**
 * Testklasse zur Überprüfung von Queue
 * @author Fabian Maurutschek
 *
 */
public class TestQueue {

	public static void main(String[] args) throws Exception {
		Queue q = new Queue();
		System.out.println(q.enqueue(new Lied()));
		System.out.println(q.dequeue());
		if (args.length % 4 != 0) {
			throw new Exception("False Arguments");
		}
		for (int i = 0; i < args.length; i += 4) {
			System.out.println(q.enqueue(new Lied(args[i], args[i + 1], args[i + 2], Long.parseLong(args[i + 3]))));
		}
	}
}