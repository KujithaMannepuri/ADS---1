import java.util.Scanner;
import java.util.Arrays;

class Sorting {
	private int midVal = 7;
	int[] orgArray;
	int[] aux;
	
	Sorting() {

	}
	void sorting(int[] orgArray) {
		this.orgArray = orgArray;
		aux = new int[orgArray.length];
		sorting(orgArray, 0, orgArray.length - 1);
	}
	void sorting(int[] orgArray, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		sorting(orgArray, lo, mid);
		sorting(orgArray, mid + 1, hi);
		mergeSort(orgArray, lo, mid, hi);
	}
	public  boolean less(int i, int j) {
		return j > i;
	}

	void mergeSort(int[] orgArray, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int n = 0; n <= hi; n++) {
			aux[n] = orgArray[n];
		}
		for (int n = lo; n <= hi; n++) {
			if (i > mid) {
				orgArray[n] = aux[j++];
			}
			else if (j > hi) {
				orgArray[n] = aux[i++];
			}
			else if (less(aux[j], aux[i])) {
				orgArray[n] = aux[j++];
			}
			else {
				orgArray[n] = aux[i++];
			}
		}
	}

	public String toString() {
		System.out.println(Arrays.toString(orgArray));
		return "";
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] ipArr = sc.nextLine().split(",");
			int[] arr = new int[ipArr.length];
			for (int i = 0; i < ipArr.length; i++) {
				arr[i] = Integer.parseInt(ipArr[i]);
			}
			Sorting str = new Sorting();
			str.sorting(arr);
			System.out.println(str);
		}
	}
}