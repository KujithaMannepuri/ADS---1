import java.util.Scanner;
import java.util.Arrays;
class Stock {
	String name;

	Stock(String n, Float p) {
		this.name = n;
	}
}

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
class BinarySearchST {


}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MinST min = new MinST();
		MaxST max = new MaxST();
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