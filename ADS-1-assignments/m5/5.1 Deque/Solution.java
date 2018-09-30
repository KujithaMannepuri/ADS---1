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
     * size.
     *
     * @return size.
     */
    public int size() {
        return size;
    }
    /**
     * Pushes a left.
     *
     * @param      num  The num
     */
    public void pushLeft(final int num) {
        if (first == null) {
            //Node oldfirst = first;
            first = new Node();
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
            last = new Node();
            last.num = num;
            last.next = null;
            temp.next = last;
        }
        size++;
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
     * to string to display.
     *
     * @return  string.
     */
    public String display() {
        if (size != 0) {
            String s = "[";
            Node temp = first;
            while (temp != null) {
                s += temp.num + ", ";
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