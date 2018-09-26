import java.util.Scanner;

/**
 * Class for sorted array.
 */
class SortedArray {
    /**
     * arrone.
     */
    private int[] arrone;
    /**
     * arrtwo.
     */
    private int[] arrtwo;
    /**
     * Constructs the object.
     * @param      array1    A 1
     * @param      array2    A 2
     */
    SortedArray(final int[] array1, final int[] array2) {
        this.arrone = array1;
        this.arrtwo = array2;
    }
    /**
     * getting sorted elements.
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     *
     * @return   sorted array
     */
    public String sort(final int[] arr1, final int[] arr2) {
        int i = 0;
        int j = 0, k = 0;
        int[] arr = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        String str = "";
        int ind = 0;
        for (ind = 0; ind < arr.length - 1; ind++) {
            str += arr[ind] + ",";
        } str += arr[ind];
        return str;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = Integer.parseInt(sc.nextLine());
        int size2 = Integer.parseInt(sc.nextLine());
        String[] arrList1 = sc.nextLine().split(",");
        String[] arrList2 = sc.nextLine().split(",");
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        for (int i = 0; i < size1; i++) {
            array1[i] = Integer.parseInt(arrList1[i]);
        }
        for (int j = 0; j < size2; j++) {
            array2[j] = Integer.parseInt(arrList2[j]);
        }
        SortedArray sa = new SortedArray(array1, array2);
        System.out.println(sa.sort(array1, array2));

    }
}
