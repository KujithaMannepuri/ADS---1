import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * Variable first.
     */
    private Node first;
    /**
     * Variable last.
     */
    private Node last;
    /**
     * Variable size.
     */
    private int size;
    /**
     * Constructor.
     */
    Deque() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     * Class for node.
     */
    class Node {
        /**
         * variable data.
         */
        private int data;
        /**
         * variable next.
         */
        private Node next;
    }
    /**
     * {Method to get size}.
     *
     * @return     {returns Integer}
     */
    public int getsize() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }
    /**
     * Method to push element to right.
     *
     * @param data  The data
     */
    public void popRight( int data) {
        if (last == null) {
            last = new Node();
            last.data = data;
            last.next = null;
            first = last;
        } else {
            Node temp = last;
            last = new Node();
            last.data = data;
            last.next = null;
            temp.next = last;
        }
    }
    /**
     * pops first element.
     *
     * @return returns integer.
     */
    public int popLeft() {
        if (first != null) {
            int temp = first.data;
            first = first.next;
            return temp;
        }
        return last.data;
    }
    
}
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
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(" ");
            int num1 = Integer.parseInt(token[0]);
            int num2 = Integer.parseInt(token[1]);
            String str = "";
            Deque deq = new Deque();
            for (int i = 0; i < num1; i++) {
                deq.popRight(i);
            }
            while (!deq.isEmpty()) {
                for (int i = 0; i < num2 - 1; i++) {
                    deq.popRight(deq.popLeft());
                }
                str += deq.popLeft() + " ";
            }
            System.out.print(str.substring(0, str.length() - 1));
            System.out.println();
        }
    }
}