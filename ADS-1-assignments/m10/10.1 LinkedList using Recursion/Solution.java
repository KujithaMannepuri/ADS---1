import java.util.Scanner;



/**
 * solution class.
 */
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		while(sc.hasNextLine()) {
			String[] token = sc.nextLine().split(" ");
			switch (token[0]) {
				case "insertAt":
				try{
				ll.insertAt(Integer.parseInt(token[1]), token[2]);
				ll.tostring();
			} catch (Exception e) {
				System.out.println("Can't insert at this position.");
			}
				break;
				case "reverse":
				try {
				ll.reverse();
				ll.tostring();
			} catch (Exception e) {
				System.out.println("No elements to reverse.");
			}
			}
		}
	}
}

