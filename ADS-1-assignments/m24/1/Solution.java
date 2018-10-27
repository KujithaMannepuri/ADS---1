import java.util.Scanner;

// class StudentInfo {
// 	int rollNum;
// 	String name;
// 	Double marks;
// 	StudentInfo(int num, String stdnt, Double m) {
// 		this.rollNum = num;
// 		this.name = stdnt;
// 		this.marks = m;
// 	}
// }

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        SeparateChainingHashST<Integer, String> hashSt1 = new
                    SeparateChainingHashST<Integer, String>();
        SeparateChainingHashST<Integer, Double> hashSt2 = new
                    SeparateChainingHashST<Integer, Double>();
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
        	String[] token1 = sc.nextLine().split(",");
			hashSt1.put(Integer.parseInt(token1[0]), token1[1]);
			hashSt2.put(Integer.parseInt(token1[0]), Double.parseDouble(token1[2]));
		}
		int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
        	String[] token2 = sc.nextLine().split(" ");
				if (token2[2].equals("1")){
					if (hashSt1.get(Integer.parseInt(token2[1])) == null) {
						System.out.println("Student doesn't exists...");
					}
					else {
						System.out.println(hashSt1.get(Integer.parseInt(token2[1])));
					}
				} else if (token2[2].equals("2")){
					if (hashSt2.get(Integer.parseInt(token2[1])) == null) {
						System.out.println("Student doesn't exists...");
					}
					else {
						System.out.println(hashSt2.get(Integer.parseInt(token2[2])));
					}
		}
	}
}
}
