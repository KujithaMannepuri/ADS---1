import java.util.Scanner;
import java.util.Arrays;
class ThreeSum {
	private int[] arr;
	private int size;
	ThreeSum(int[] arr2, int size1) {
		this.arr = arr2;
		this.size = size1;
	}
	private boolean Duplicates(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[i + 1]) {
				return true;
			}
		}
		return false;
	}
	public int binarySearch(int[] arr, int val) {
		int min = 0;
		int max = arr.length - 1;
		while (min <= max) {
			int mid = (min + max)/2;
			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] < val) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -1;
	}
	public int total(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int total1 = binarySearch(arr, -(arr[i] + arr[j]));
				if (total1 > j && total1 > 0) {
					count++;
				}
			}
		}
		return count;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//int num = Integer.parseInt(scan.nextLine());
		int num = scan.nextInt();
		int[] arr = new int[num];
		ThreeSum t_sum = new ThreeSum(arr, num);
		for (int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();			
		}
		System.out.println(t_sum.total(arr));
	}
}