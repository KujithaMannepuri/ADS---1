import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
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
        final int thousand = 1000;
        while (sc.hasNextLine()) {
            String[] token = sc.nextLine().split(" ");
            int ip1 = Integer.parseInt(token[0]);
            int ip2 = Integer.parseInt(token[1]);
            int n = thousand;
            MinPQ<Cubesum> pq = new MinPQ<Cubesum>();
                for (int i = 1; i <= n; i++) {
                pq.insert(new Cubesum(i, i));
            }
            int pair = 1;
            Cubesum prev = new Cubesum(0, 0);
            int pairCount = 0;
            while (!pq.isEmpty()) {
                Cubesum cs = pq.delMin();
                if (prev.sum == cs.sum) {
                    pair++;
                    if (pair == ip2) {
                        pairCount = pairCount + 1;
                    }
                    if (pairCount == ip1) {
                        System.out.println(prev.sum);
                        break;
                    }
                } else {
                    pair = 1;
                }
                prev = cs;
                if (cs.j < n) {
                    pq.insert(new Cubesum(cs.i, cs.j + 1));
                }
            }
        }
    }
}
