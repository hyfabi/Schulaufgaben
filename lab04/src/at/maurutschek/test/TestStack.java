package at.maurutschek.test;

import at.maurutschek.data.Lied;
import at.maurutschek.data.Stack;

/**
 * Testklasse zur Überprüfung von Stack
 * @author Fabian Maurutschek
 *
 */
public class TestStack {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		System.out.println(s.push(new Lied()));
		System.out.println(s.peek());
		System.out.println(s.pop());
		if (args.length % 4 != 0) {
			throw new Exception("False Arguments");
		}
		for (int i = 0; i < args.length; i += 4) {
			System.out.println(s.push(new Lied(args[i], args[i + 1], args[i + 2], Long.parseLong(args[i + 3]))));
		}
	}
}
