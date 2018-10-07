import java.util.Scanner;

class Solution{
	Solution() {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ip = Integer.parseInt(sc.nextLine());
		QuickSort qs = new QuickSort();
		for (int i = 0; i < ip; i++) {
			int j = Integer.parseInt(sc.nextLine());
			String lines = sc.nextLine();
			String[] token = lines.split(" ");
			if (token[0].equals("")) {
				System.out.println("[]");
			} else {
				qs.sorting(token, j);
				System.out.println(qs.tostring(token));
			}
		}
	}
}
