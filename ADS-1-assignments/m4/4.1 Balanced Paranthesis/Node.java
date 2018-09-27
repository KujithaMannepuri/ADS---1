
class Node {
    
    String paranthesis;
    
    Node next;
}

class Linkedlist {

    private Node start = null;
    
    void push(final String chr) {
        Node value = start;
        start = new Node();
        start.paranthesis = chr;
        start.next = value;
    }
    
    String pop() {
        if (start == null) {
            return "e";
        }
        String r = start.paranthesis;
        start = start.next;
        return r;
    }
    
    public Node gethead() {
        return start;
    }
}

class BalancedPrnths {
    
    BalancedPrnths() {

    }
    
    boolean matchPrnths (String str1, String str2) {
        if (str1.equals("{") && str2.equals("}")) {
            return true;
        }
        if (str1.equals("[") && str2.equals("]")) {
            return true;
        }
        if (str1.equals("(") && str2.equals(")")) {
            return true;
        }
        return false;
    }
    
    boolean balancing(final String[] array) {
        Linkedlist list = new Linkedlist();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(") || array[i].equals("[") || array[i].equals("{")) {
                list.push(array[i]);
            }
            if (array[i].equals(")") || array[i].equals("]") || array[i].equals("}")) {
                if (matchPrnths(list.pop(), array[i])) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return list.gethead() == null;
    }
}