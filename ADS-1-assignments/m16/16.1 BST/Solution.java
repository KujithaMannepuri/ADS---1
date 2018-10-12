import java.util.Scanner;

/**
 * Class for book.
 */
class Book {
	/**
	 * { var_description }.
	 */
	private String author;
	/**
	 * { var_description }.
	 */
	private String name;
	/**
	 * { var_description }.
	 */
	private Float price;
	/**
	 * Constructs the object.
	 */
	Book() {

	}
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 * @param      a     { parameter_description }
	 * @param      p     { parameter_description }
	 */
	Book(final String n, final String a, final Float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	String getname() {
		return this.name;
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	String getauthor() {
		return this.author;
	}
	/**
	 * getprice function.
	 *
	 * @return     { description_of_the_return_value }
	 */
	Float getprice() {
		return this.price;
	}
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	/**
	 * variable root.
	 */
	private Node root;
	/**
	 * variable book.
	 */
	private Book book;
	/**
	 * variable value.
	 */
	private int value;
	/**
	 * Constructs the object.
	 */
	BinarySearchTree() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	Integer get(final Book key) {
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
	/**
	 * { function_description }.
	 *
	 * @param      key   The key
	 * @param      val   The value
	 */
	public void put(final Book key, final int val) {
		root = put(root, key, val);
	}
	/**
	 * { function_description }.
	 *
	 * @param      x     { parameter_description }
	 * @param      key   The key
	 * @param      val   The value
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Node put(final Node x, final Book key, final int val) {
		if (x == null) {
			return new Node(key, val);
		}
		int cmp = key.getname().compareTo(x.data.getname());
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else if (cmp == 0) {
			x.val = val;
		}
		return x;
	}
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		final int three = 3;
		final int four = 4;
		BinarySearchTree bst = new BinarySearchTree();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(",");
			switch (token[0]) {
				case "get":
				Book ip1 = new Book(token[1], token[2],
				Float.parseFloat(token[three]));
				Integer i = bst.get(ip1);
				System.out.println(i);
				break;
				case "put":
				Book ip2 = new Book(token[1], token[2],
				Float.parseFloat(token[three]));
				bst.put(ip2, Integer.parseInt(token[four]));
				break;
				default:
				break;
			}
		}
	}
}
