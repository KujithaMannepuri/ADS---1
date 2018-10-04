import java.util.Scanner;

/**
 * node class.
 */
 class Node {
    /**
     * variable data.
     */
 private String data;
 /**
  * variable next.
  */
 private Node next;

 /**
  * constructor.
  *
  * @param      val  The value
  */
  Node(final String val) {
    this.data = val;
 }

 public String getData() {
    return data;
 }

 public Node getNext() {
    return next;
 }

 public void setNext(Node n) {
    next = n; 
 }

 public void setData(String s) {
    data = s;
 }
}

/**
 * List of linkeds.
 */
 class LinkedList {
    /**
     * variable head.
     */
    private Node head;
    /**
     * variable size.
     */
    private int size;

    /**
     * constructor.
     */
    LinkedList() {
        head = null;
        size = 0;
    }

    // void insertAt(int pos, String data) {
    //  Node obj = new Node(data);
    //  if (pos == 0) {
    //      obj.next = head;
    //      head = obj;
    //      size++;
    //      return;
    //  }
    //  Node previous = null;
    //  Node temp = head;
    //  int count = 0;
    //  while (temp != null) {
    //      if (count == pos) {
    //          previous.next = obj;
    //          obj.next = temp;
    //          size++;
    //          return;
    //      }
    //      previous = temp;
    //      temp = temp.next;
    //      count++;
    //  }
    // }
    /**
     * insertAt function.
     *
     * @param      pos        The position
     * @param      data       The data
     *
     * @throws     Exception  { exception_description }
     */
    public void insertAt(final int pos,
    final String data) throws Exception {
        if (pos < 0 || pos > size) {
            throw new Exception();
        }
        Node obj = new Node(data);
        // if (pos == 0) {
        //  obj.next = head;
        //  head = obj;
        //  size++;
        //  return;
        // }
        head = insertAt(pos, head, obj, 0);
    }

    /**
     * { function_description }.
     *
     * @param      pos    The position
     * @param      first  The first
     * @param      obj    The object
     * @param      count  The count
     *
     * @return     { description_of_the_return_value }
     */
    public Node insertAt(final int pos,
final Node first, final Node obj, final int count) {
        if (pos == count) {
            obj.setNext(first);
            size++;
            return obj;
        }
        first.setNext(insertAt(pos, first.getNext(), obj, count + 1));
        return first;
    }

    /**
     * { function_description }.
     */
    public void reverse() {
        reverse(null, head);
    }

    /**
     * { function_description }.
     *
     * @param      previous  The previous
     * @param      current   The current
     */
    public void reverse(final Node previous, final Node current) {
        if (current != null) {
            reverse(current, current.getNext());
            current.setNext(previous);
        } else {
            head = previous;
        }
    }

    /**
     * { function_description }.
     */
    public void tostring() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.getData() + ", ";
            temp = temp.getNext();
        }
        System.out.println(str.substring(0, str.length() - 2));
    }
}

/**
 * solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (sc.hasNextLine()) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
                case "insertAt":
                try {
list.insertAt(Integer.parseInt(token[1]), token[2]);
                list.tostring();
            } catch (Exception e) {
System.out.println("Can't insert at this position.");
            }
                break;
                case "reverse":
                try {
                list.reverse();
                list.tostring();
            } catch (Exception e) {
                System.out.println("No elements to reverse.");
            }
                default:
                break;
            }
        }
    }
}

