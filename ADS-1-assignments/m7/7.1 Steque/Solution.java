import java.util.Scanner;

class Solution {
	public static void main(final String[] args) {
	Scanner sc = new Scanner(System.in);
	Steque ste = new Steque();
	String num = sc.nextLine();
	while (sc.hasNext()) {
		String[] token = sc.nextLine().split(" ");
		// if(token.length==1 && !token[0].equals("pop")){
		// 	ste = new Steque();
		// 	System.out.println();
		// 	continue;
		// }
		switch (token[0]) {
			case "push":
				ste.push(token[1]);
				ste.printStack();
			break;
			case "pop":
			try{
			ste.pop();
			ste.printStack();
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			break;
			case "enqueue":
			ste.enqueue(token[1]);
			ste.printStack();
			break;
			default:
			System.out.println();
			ste = new Steque();
			break;
		}
	}
}
}