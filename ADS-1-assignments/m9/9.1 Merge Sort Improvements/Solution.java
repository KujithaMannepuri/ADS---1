import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for merge sort.
 */
public final class Solution {
    /**
     * constructor.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort ip = new MergeSort();
        while (sc.hasNext()) {
            String[] ipArr = sc.nextLine().split(",");
            ip.sorting(ipArr);
            System.out.println(ip.tostring(ipArr));
            System.out.println();
        }
    }
}




