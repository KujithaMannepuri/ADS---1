/**
 * Class for node.
 */
class Node {
    /**
     * Data in string.
     */
    String data;
    /**
     * Next node.
     */
    Node next;
}

/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * An empty node.
     */
    private Node start = null;
    /**
     * Pushing an element into list.
     *
     * @param      ch    { given String }
     */
    void push(final String ch) {
        Node val = start;
        start = new Node();
        start.data = ch;
        start.next = val;
    }
    /**
     * Popping element from list.
     *
     * @return     { String value }
     */
    String pop() {
        if (start == null) {
            return "e";
        }
        String r = start.data;
        start = start.next;
        return r;
    }
    /**
     * First value.
     *
     * @return     { value }
     */
    public Node gethead() {
        return start;
    }
}
/**
 * Class for balanced.
 */
class Balanced {
    /**
     * Constructs the object.
     */
    Balanced() {

    }
    /**
     * Checking if the pair is matched or not.
     *
     * @param      str1  The string 1
     * @param      str2  The string 2
     *
     * @return     { a boolean }
     */
    boolean Matchingpair (String str1, String str2) {
        if (str1.equals("(") && str2.equals(")")) {
            return true;
        }
        if (str1.equals("[") && str2.equals("]")) {
            return true;
        }
        if (str1.equals("{") && str2.equals("}")) {
            return true;
        }
        return false;
    }
    /**
     * Balancing of parnathesis.
     *
     * @param      array  The array
     *
     * @return     { boolean based on matching }
     */
    boolean balancing(final String[] array) {
        Linkedlist ll = new Linkedlist();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(") || array[i].equals("[") || array[i].equals("{")) {
                ll.push(array[i]);
            }
            if (array[i].equals(")") || array[i].equals("]") || array[i].equals("}")) {
                if (Matchingpair(ll.pop(), array[i])) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return ll.gethead() == null;
    }
}