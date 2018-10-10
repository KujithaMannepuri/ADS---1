import java.util.Scanner;
/**
 * Class for solution.
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
        int num = sc.nextInt();
        MinPQ<Float> minpq = new MinPQ<Float>(num);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(num);
        Float dMedian = 0.0f;
        for (int i = 0; i < num; i++) {
            Float val = sc.nextFloat();
            if (val > dMedian) {
                minpq.insert(val);
            } else {
                maxpq.insert(val);
            }
            if (maxpq.size() - minpq.size() > 1) {
                minpq.insert(maxpq.delMax());  
            }
            if (maxpq.size() > minpq.size()) {
                dMedian = maxpq.max();
                System.out.println(dMedian);
            }
            if (minpq.size() == maxpq.size()) {
                dMedian = (minpq.min() + maxpq.max()) / 2;
                System.out.println(dMedian);
            }
            if (minpq.size() - maxpq.size() > 1) {
                maxpq.insert(minpq.delMin());
            }
            if (minpq.size() > maxpq.size()) {
                dMedian = minpq.min();
                System.out.println(dMedian);
            }
        }
    }
}
