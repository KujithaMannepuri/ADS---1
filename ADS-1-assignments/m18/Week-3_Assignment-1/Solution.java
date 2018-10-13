import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for stock.
 */
class Stock {
	/**
	 * { var_description }.
	 */
	String name;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 */
	Stock(String n) {
		this.name = n;
	}
}
/**
 * Class for node.
 */
class Node {
	Stock sName;
	Float fCount;
	Node left;
	Node right;

	Node(Stock name, Float count) {
		this.sName = name;
		this.fCount = count;
	}
}
/**
 * Class for binary search st.
 */
class BinarySearchST {


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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MinPQ min = new MinPQ();
		MaxPQ max = new MaxPQ();
		BinarySearchST bst = new BinarySearchST();
		int n1 = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < n1; j++) {
				String[] token = sc.nextLine().split(",");
				//System.out.println(Arrays.toString(token));
			}
		}
		int n2 = sc.nextInt();
		for (int k = 0; k < n2; k++){
			String[] tokens = sc.nextLine().split(",");
			//System.out.println(Arrays.toString(tokens));
			switch (tokens[0]) {
				case "get":
				break;
				case "Intersection":
				break;
				default:
				break;
			}
		}
	}
}