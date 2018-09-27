import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        while (line != 0) {
            BalancedPrnths parenthesis = new BalancedPrnths();
            String[] input = sc.nextLine().split("");
            if (parenthesis.balancing(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            line--;
        }
    }
}


