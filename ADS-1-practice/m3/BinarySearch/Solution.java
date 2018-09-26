import java.util.Scanner;
import java.util.Arrays;

class BinarySearch {
	int BinarySearch(int arr[], int element) {
		int last = arr.length - 1;
		int first = 0;
		for(int i = 0; i < arr.length; i++) {
			int mid = (first + last)/2;
			if(element == arr[mid]) {
				return mid;
			}
			if(arr[mid] < element) {
				first = mid + 1;
			}
			if(arr[mid] > element) {
				last = mid - 1;
			}
		}
		return -1;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearch bs = new BinarySearch();
		int num = scan.nextInt();
		int[] array = new int[num];
		for(int i = 0; i < num; i++) {
			array[i] = scan.nextInt();
		}
		int element = scan.nextInt();
		Arrays.sort(array);
		int res = bs.BinarySearch(array,element);
		if(res == -1) {
			System.out.println(element +" "+ "not found");

		}
		else {
			System.out.println(element +" "+ "found");
		}
	}
}
