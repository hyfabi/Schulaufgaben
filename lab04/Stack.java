package at.maurutschek.data;

public class Stack {
	LiederListknoten root;

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

	public Lied pop() {
		if (root == null)
			return null;
		Lied l = root.getLied();
		root.setNext(root.getNext());
		return l;
	}

	public Lied peek() {
		if (root == null)
			return null;
		return root.getLied();
	}
}
