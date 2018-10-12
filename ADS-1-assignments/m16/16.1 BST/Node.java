/**
 * Class for node.
 */
class Node {
	 Book data;
	 int val;
	 Node left;
	 Node right;
	Node(final Book b, final int v) {
		this.data = b;
		this.val = v;
	} 
}