import java.util.Scanner;

/**
     * Class for node.
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
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
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
     * Pushes a right.
     *
     * @param      num  The num
     */
    public void pushRight(final int num) {
        if (last == null) {
            last = new Node();
            last.num = num;
            last.next = null;
            first = last;
        }   else {
            Node temp = last;
            Node last = new Node();
            last.num = num;
            last.next = null;
            temp.next = last;
        }
        size++;
    }
    /**
     * Pushes a left.
     *
     * @param      num  The num
     */
    public void pushLeft(final int num) {
        if (first == null) {
            //Node oldfirst = first;
            Node first = new Node();
            first.num = num;
            first.next = null;
            last = first;
        } else {
            Node oldlast = first;
            first = new Node();
            first.num = num;
            first.next = oldlast;
        }
        size++;
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
            Node num2 = first;
            while (num2 != null) {
                str += num2.num + ", ";
                num2 = num2.next;
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
        Scanner sc = new Scanner(System.in);
        int n;
        Deque link = new Deque();
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                link.pushLeft(Integer.parseInt(line[1]));
                System.out.println(link.toString());
                break;
            case "pushRight":
                link.pushRight(Integer.parseInt(line[1]));
                System.out.println(link.toString());
                break;
            case "popRight":
                if (!link.isEmpty()) {
                    link.popRight();
                    System.out.println(link.toString());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popLeft":
                if (!link.isEmpty()) {
                    link.popLeft();
                    System.out.println(link.toString());
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