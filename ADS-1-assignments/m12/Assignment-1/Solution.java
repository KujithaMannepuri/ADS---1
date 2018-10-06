import java.util.Scanner;
import java.util.Arrays;
//import java.util.Date;
/**
 * Class for student information.
 */
class StudentInfo implements Comparable<StudentInfo> {
	String name;
	String dob;
	int marks1;
	int marks2;
	int marks3;
	int total;
	String category;
	/**
	 * constructor.
	 *
	 * @param      n     { parameter_description }
	 * @param      date  The date
	 * @param      m1    The m 1
	 * @param      m2    The m 2
	 * @param      m3    The m 3
	 * @param      tot   The total
	 * @param      cat   The cat
	 */
	StudentInfo(String n, String date, int m1, int m2, int m3, int tot, String cat) {
		this.name = n;
		this.dob = date;
		this.marks1 = m1;
		this.marks2 = m2;
		this.marks3 = m3;
		this.total = tot;
		this.category = cat;
	}

	/**
	 * { function_description }
	 *
	 * @param      info  The information
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(StudentInfo info) {
		if (this.total > info.total) {
			return 1;
		}
		if (this.total < info.total) {
			return -1;
		}
		if (this.marks3 > info.marks3) {
			return 1;
		}
		if (this.marks3 < info.marks3) {
			return -1;
		}
		if (this.marks2 > info.marks2) {
			return 1;
		}
		if (this.marks2 < info.marks2) {
			return -1;
		}
		return 0;
	}
}

/**
 * Class for insertion sort.
 */
class InsertionSort {
	StudentInfo[] arr;
	int size;
	/**
	 * Constructs the object.
	 */
	InsertionSort() {
		arr = new StudentInfo[1];
		size = 0;
	}

	/**
	 * add.
	 *
	 * @param      item  The item
	 */
	void add(StudentInfo item) {
		if (size < arr.length) {
			arr[size++] = item;
		} else {
			resize();
		}
	}

	/**
	 * resize.
	 */
	void resize() {
		arr = Arrays.copyOf(arr, arr.length * 2);
	}

	/**
	 * { function_description }
	 *
	 * @param      arr   The arr
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	boolean less(StudentInfo[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}

	/**
	 * sort function.
	 */
	void sort() {
		int min;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < 0; j++) {
				if(less(arr, j - 1, j)) {
					StudentInfo temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	void tostring() {

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
		Scanner sc = new Scanner(System.in);
		InsertionSort is = new InsertionSort();
		while (sc.hasNext()) {
			// if (sc.length = 1) {

			// }
			String[] token = sc.nextLine().split(",");
			StudentInfo info = new StudentInfo(token[0], token[1], Integer.parseInt(token[2]), Integer.parseInt(token[3]),
				Integer.parseInt(token[4]), Integer.parseInt(token[5]), token[6]);
			is.add(info);
		}
		is.sort();
		}
}