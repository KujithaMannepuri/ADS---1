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
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        LinearProbingHashST<String, Integer> hashst = new
        LinearProbingHashST<>();
        for (int i = 0; i <= num; i++) {
            String[] token = s.nextLine().split(" ");
            switch (token[0]) {
                case "put": hashst.put(token[1],
                    Integer.parseInt(token[2]));
                break;
                case "display":
                    if (hashst.size() == 0) {
                    System.out.println("{}");
                } else {
                    String str = "";
                    for (String s1: hashst.keys()) {
                        str += s1 + ":" + hashst.get(s1) + ", ";
                    }
                    System.out.println("{" + str.substring(
                        0, str.length() - 2) + "}");
                }
                break;
                case "delete":
                hashst.delete(token[1]);
                break;
                case "get":
                System.out.println(hashst.get(token[1]));
                break;
                default:
                break;
            }
        }
    }
}
