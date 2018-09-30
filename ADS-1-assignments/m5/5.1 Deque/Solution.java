import java.util.Scanner;

/**
     * Class for node.
     */
class Node {
        /**
         * variable.
         */
         int item;
        /**
         * variable.
         */
         Node next;
    }
/**
 * Class for deque.
 */
class Deque {
    /**
     * variable.
     */
    private Node first;
    /**
     * last variable.
     */
    private Node last;
    /**
     * count variable.
     */
    private int count;
    /**
     * Constructs the object.
     */
    Deque() {
        first = null;
        last = null;
        count = 0;
    }

    
    
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * size.
     *
     * @return count.
     */
    public int size() {
        return count;
    }
    /**
     * Pushes a left.
     *
     * @param      item  The item
     */
    public void pushLeft(final int item) {
        if (first == null) {
            //Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = null;
            last = first;
        } else {
            Node oldlast = first;
            first = new Node();
            first.item = item;
            first.next = oldlast;
        }
        count++;
    }
    /**
     * Pushes a right.
     *
     * @param      item  The item
     */
    public void pushRight(final int item) {
        if (last == null) {
            last = new Node();
            last.item = item;
            last.next = null;
            first = last;
        }   else {
            Node temp = last;
            last = new Node();
            last.item = item;
            last.next = null;
            temp.next = last;
        }
        count++;
    }
    /**
     * pop from left.
     */
    public void popLeft() {
        if (first != null) {
            first = first.next;
            count--;
        }
    }
    /**
     * pop from right.
     */
    public void popRight() {
        if (last != null) {
            Node temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
            count--;
        }
    }
    /**
     * to string to display.
     *
     * @return  string.
     */
    public String display() {
        if (count != 0) {
            String s = "[";
            Node temp = first;
            while (temp != null) {
                s += temp.item + ", ";
                temp = temp.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
        return "[]";
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
        Scanner sc = new Scanner(System.in);
        int n;
        Deque link = new Deque();
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                link.pushLeft(Integer.parseInt(line[1]));
                System.out.println(link.display());
                break;
            case "pushRight":
                link.pushRight(Integer.parseInt(line[1]));
                System.out.println(link.display());
                break;
            case "popRight":
                if (!link.isEmpty()) {
                    link.popRight();
                    System.out.println(link.display());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popLeft":
                if (!link.isEmpty()) {
                    link.popLeft();
                    System.out.println(link.display());
                } else {
                    System.out.println("Deck is empty");
                }

                break;
            case "size":
                System.out.println(link.size());
            default:
                break;
            }

        }
    }
}