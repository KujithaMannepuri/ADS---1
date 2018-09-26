import java.util.Scanner;
import java.util.Arrays;
class No_Of_Pairs {
	int No_Of_Pairs(int[] arr) {
		int sum = 0;
		int count = 1;
		for(int i = 0; i < arr.length-1; i++) {
			if(i == arr.length-2 && arr[i] == arr[i+1]) {
				count++;
				sum += count * (count - 1)/2;
				break;
			}
			if(arr[i]== arr[i+1]) {
				count++;
			}
			if(count >= 1 && arr[i] != arr[i+1]) {
				sum += count * (count - 1)/2;
				count = 1;
			}
		}
		return sum;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		No_Of_Pairs pairs = new No_Of_Pairs();
		int num = scan.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int res = pairs.No_Of_Pairs(arr);
		System.out.println(res);
	}
}