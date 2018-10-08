import java.util.Scanner;

/**
 * Class for minimum heap.
 *
 * @param      <E>   { parameter_description }
 */
class MinHeap<E extends Comparable<E>> {
    /**
     * new array.
     */
    private E[] newArr;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     */
    protected MinHeap(final E[] arr) {
        this.newArr = arr;
    }
    /**
     * Determines if minimum heap.
     *
     * @param      arr1  The arr 1
     *
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap(final E[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            if (!less(arr1[i], arr1[i + 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final E i, final E j) {
        return i.compareTo(j) <= 0;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    String ip = sc.nextLine();
    switch (ip) {
        case "Integer":
        int n1 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n1; i++) {
            String s1 = sc.nextLine();
            String[] token = s1.split(",");
            Integer[] arr1 = new Integer[token.length];
            for (int j = 0; j < token.length; j++) {
                arr1[j] = Integer.parseInt(token[j]);
            }
        MinHeap<Integer> intgr = new MinHeap<Integer>(arr1);
        System.out.println(intgr.isMinHeap(arr1));
        }
        break;
        case "Float":
            int n2 = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n2; i++) {
                String s2 = sc.nextLine();
                if (s2.equals("")) {
                    System.out.println("false");
                } else {
                String[] token = s2.split(",");
                Float[]  arr2 = new Float[token.length];
                for (int j = 0; j < token.length; j++) {
                    arr2[j] = Float.parseFloat(token[j]);
                }
                MinHeap<Float> flt = new MinHeap<Float>(arr2);
                System.out.println(flt.isMinHeap(arr2));
            }
            }
            break;
            case "Double":
            int n3 = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n3; i++) {
                String s3 = sc.nextLine();
                String[] token = s3.split(",");
                Double[]  arr3 = new Double[token.length];
                for (int j = 0; j < token.length; j++) {
                    arr3[j] = Double.parseDouble(token[j]);
                }
                MinHeap<Double> dble = new MinHeap<Double>(arr3);
                System.out.println(dble.isMinHeap(arr3));
            }
            break;
            case "String":
            int n4 = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n4; i++) {
                String[] token = sc.nextLine().split(",");
                MinHeap<String> str = new MinHeap<String>(token);
                System.out.println(str.isMinHeap(token));

            }
            break;
            default:
            break;
    }
 }
}
