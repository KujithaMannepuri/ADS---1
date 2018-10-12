import java.util.Scanner;

class Node {
	Book data;
	int val;
	Node left;
	Node right;
	Node(Book b, int v) {
		this.data = b;
		this.val = v;
	}
}

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
	String getname() {
		return this.name;
	}
	String getauthor() {
		return this.author;
	}
	Float getprice() {
		return this.price;
	}
}

class BinarySearchTree<Key extends Comparable<Key>, Value> {
	Node root;
	Book book;
	int value;
	BinarySearchTree() {

	}
	Integer get(Book key) {
		Node x = root;
		while (x != null) {
			int cmp = key.getname().compareTo(x.data.getname());
			if (cmp < 0) {
				x = x.left;
			}
	        if (cmp > 0) {
	        	x = x.right;
	        }
	        if (cmp == 0) {
	        	return x.val;
	        } 	
		}
		return null;
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
			x.left = put(x.left, key, val);
		}
		else if (cmp > 0) {
			x.right = put(x.right, key, val);
		}
		else if (cmp == 0) {
			x.val = val;
		}
		return x;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(",");
			switch(token[0]) {
				case "get":
				Book ip1 = new Book(token[1], token[2], Float.parseFloat(token[3]));
				Integer i = bst.get(ip1);
				System.out.println(i);
				break;
				case "put":
				Book ip2 = new Book(token[1], token[2], Float.parseFloat(token[3]));
				bst.put(ip2, Integer.parseInt(token[4]));
				break;
				default:
				break;
			}
		}
	}
}
