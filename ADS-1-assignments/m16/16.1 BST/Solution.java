class Book {
	String author;
	String name;
	Float price;
	Book() {

	}
	Book (String n, String a, Float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}
	String getauthor() {
		return this.author;
	}
	String getname() {
		return this.name;
	}
	Float getprice() {
		return this.price;
	}
}
class Node {
	Book data;
	int val;
	Node n1;
	Node n2;
	Node(Book k, int v) {
		this.data = (k);
		this.val = v;
	}
}
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	Node root;
	Book book;
	int value;
	BinarySearchTree() {

	}
	void put(Book key, int val) {
		root = put(root, key, val);
	}
	Node put(Node x, Book key, int val) {
		if (x == null) {
			return new Node(key, val);
		}
		int cmp = key.getname().compareTo(x.data.getname());
		if (cmp < 0) {
			x.n1 = put(x.n1, key, val);
		}
		else if (cmp > 0) {
			x.n2 = put(x.n2, key, val);
		}
		else if (cmp == 0) {
			x.val = val;
		}
		return x;
	}
	Integer get(Book key) {
		Node x = root;
		while (x != null) {
			int cmp = key.getname().compareTo(x.data.getname());
			if (cmp < 0) {
				x = x.n1;
			}
	        if (cmp > 0) {
	        	x = x.n2;
	        }
	        if (cmp == 0) {
	        	return x.val;
	        } 	
		}
		return null;
	}
}
