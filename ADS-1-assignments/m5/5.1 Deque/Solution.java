import java.util.Scanner;
/**
 * node class.
 */
class Node {
        /**
         * variable num.
         */
        int num;
        /**
         * variable next.
         */
        Node next;
    }
// /**
//  * Class for deque.
//  */
class Deque {
    /**
     * variable first.
     */
    private Node first;
    /**
     * variable last.
     */
    private Node last;
    /**
     * size.
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
     * size.
     *
     * @return size.
     */
    public int size() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
			return true;
		}
		return false;
    }
    /**
     * Pushes to right.
     *
     * @param      num  The num
     */
    public void pushRight(final int num) {
        if (last == null) {
        	Node obj = new Node();
            obj = last;
            obj.num = num;
            obj.next = null;
            first = obj;
        }   else {
            Node temp = last;
            Node obj = new Node();
            obj = last;
            obj.num = num;
            obj.next = null;
            temp.next = obj;
        }
        size++;
    }
    /**
     * Pushes to left.
     *
     * @param      num  The num
     */
    public void pushLeft(final int num) {
        if (first == null) {
            //Node oldfirst = first;
            Node obj = new Node();
            //first = new Node();
            obj = first;
            obj.num = num;
            obj.next = null;
            last = obj;
        } else {
            Node temp = first;
            Node obj = new Node();
            //first = new Node();
            obj = obj;
            obj.num = num;
            obj.next = temp;
        }
        size++;
    }
    /**
     * pops from right.
     */
    public void popRight() {
        if (last != null) {
            Node temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
            size--;
        }
    }
    /**
     * pop from left.
     */
    public void popLeft() {
        if (first != null) {
            first = first.next;
            size--;
        }
    }
    /**
     * to string to toString.
     *
     * @return  string.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String str = "[";
            Node num1 = first;
            while (num1 != null) {
                str += num1.num + ", ";
                num1 = num1.next;
            }
            return str.substring(0, str.length() - 2) + "]";
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     *constructs object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int ip;
        Deque deq = new Deque();
        ip = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < ip; i++) {
            String[] token = scan.nextLine().split(" ");
            switch (token[0]) {
            case "pushLeft":
                deq.pushLeft(Integer.parseInt(token[1]));
                System.out.println(deq.toString());
                break;
            case "pushRight":
                deq.pushRight(Integer.parseInt(token[1]));
                System.out.println(deq.toString());
                break;
            case "popRight":
                if (!deq.isEmpty()) {
                    deq.popRight();
                    System.out.println(deq.toString());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popLeft":
                if (!deq.isEmpty()) {
                    deq.popLeft();
                    System.out.println(deq.toString());
                } else {
                    System.out.println("Deck is empty");
                }

                break;
            case "size":
                System.out.println(deq.size());
            default:
                break;
            }

        }
    }
}