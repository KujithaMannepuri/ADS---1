import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for three sum.
 */
class ThreeSum {
	/**
	 * array.
	 */
	private int[] arr;
	/**
	 * array size.
	 */
	private int size;

	/**
	 * constructor.
	 *
	 * @param      arr2   The arr 2
	 * @param      size1  The size 1
	 */
	ThreeSum(final int[] arr2, final int size1) {
		this.arr = arr2;
		this.size = size1;
	}
	
	/**
	 * binary search function.
	 *
	 * @param      arr   The arr
	 * @param      val   The value
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int BinarySearch(final int[] arr, final int val) {
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

	/**
	 * total sum function.
	 *
	 * @param      arr   The arr
	 *
	 * @return     returns count of numbers.
	 */
	public int totalsum(final int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tot = BinarySearch(arr, -(arr[i] + arr[j]));
				if (tot > j && tot > 0) {
					count++;
				}
			}
		}
		return count;
	}
}

/**
 * Class for solution.
 */
class Solution {
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		//int num = Integer.parseInt(scan.nextLine());
		int num = scan.nextInt();
		int[] arr = new int[num];
		ThreeSum t_sum = new ThreeSum(arr, num);
		for (int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();			
		}
		System.out.println(t_sum.totalsum(arr));
	}
}