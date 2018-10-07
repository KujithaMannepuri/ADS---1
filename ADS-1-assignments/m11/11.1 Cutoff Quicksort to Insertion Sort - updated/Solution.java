import java.util.Scanner;
class QuickSort {
	QuickSort() {

	}
	public boolean less(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}
	public void exchange(Comparable[] arr, int j, int min) {
		Comparable temp = arr[j];
		arr[j] = arr[min];
		arr[min] = temp;
	}
	public void InsertionSort(Comparable[] arr, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(arr[j], arr[j - 1]); j--) {
				exchange(arr, j, j - 1);
			}
		}
	}
	public int part(Comparable[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (less(arr[++i], arr[lo])) {
				if (i == hi) {
					break;
				}
			}
			while (less(arr[lo], arr[--j])) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exchange(arr, i, j);
		}
		exchange(arr, lo, j);
		return j;
	}
	public void sorting(Comparable[] arr, int cutoff) {
		sorting(arr, 0, arr.length - 1, cutoff);
	}
	public void sorting(Comparable[] arr, int lo, int hi, int cutoff) {
		if (hi <= lo + cutoff - 1) {
			InsertionSort(arr, lo, hi);
			System.out.println("insertionsort called");
			return;
		}
		int p = part(arr, lo, hi);
		System.out.println(tostring(arr));
		sorting(arr, lo, p - 1, cutoff);
		sorting(arr, p + 1, hi, cutoff);
	}
	public String tostring(Comparable[] arr) {
		String str = "[";
		for (int i = 0; i < arr.length - 1; i++) {
			str += arr[i] + ", ";
		}
		str += arr[arr.length - 1] + "]";
		return str;
	}
}

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
