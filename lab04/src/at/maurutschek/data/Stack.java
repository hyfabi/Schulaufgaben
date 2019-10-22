package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1
 * 
 * Bei der Queue werden LiederLiederListKnoten welche zuerst hinzugefügt werden als letztes gelöscht
 * 
 */
public class Stack {
	LiederListknoten root;

	/**
	 * Fügt ein Lied ganz oben ein
	 * @param l: Lied was hinzugefügt werden soll
	 * @return Lied welches hinzugefügt wurde
	 */
	public Lied push(Lied l) {
		if (l == null)
			return null;
		if (root == null) {
			root = new LiederListknoten(l, null);
			return l;
		}
		root = new LiederListknoten(l, root);
		return l;
	}

	/**
	 * Nimmt den ersten LiedListKnoten von ganz oben und löscht es dabei aus dem Stack
	 * @return Das Lied welches im Liederlistknoten ganz oben zu finden ist oder null falls der Stack leer ist
	 */
	public Lied pop() {
		if (root == null)
			return null;
		Lied l = root.getLied();
		root.setNext(root.getNext());
		return l;
	}

	/**
	 * Nimmt den ersten LiedListKnoten von ganz oben (Wird nicht gelöscht!)
	 * @return Das Lied welches im Liederlistknoten ganz oben zu finden ist oder null falls der Stack leer ist
	 */
	public Lied peek() {
		if (root == null)
			return null;
		return root.getLied();
	}
}
