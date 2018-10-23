import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Class for book.
 */
class Book implements Comparable {
    /**
     * variable name.
     */
    private String name;
    /**
     * variable author.
     */
    private String author;
    /**
     * variable price.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      book     The book
     * @param      bAuthor  The author
     * @param      bPrice   The price
     */
    Book(final String book,
                final String bAuthor, final float bPrice) {
        this.name = book;
        this.author = bAuthor;
        this.price = bPrice;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * { function_description }.
     *
     * @param      object  The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Object object) {
        Book obj = (Book) object;
        return this.name.compareTo(obj.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * Node class.
     */
    private final class Node {
        /**
         * key variable.
         */
        private Book key;
        /**
         * val variable.
         */
        private int val;
        /**
         * variable size.
         */
        private int size;
        /**
         * { var_description }.
         */
        private Node left;
        /**
         * { var_description }.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      key1  The key 1
         * @param      val1  The value 1
         * @param      s     { parameter_description }
         */
        private Node(final Book key1, final int val1, final int s) {
            this.key = key1;
            this.val = val1;
            this.size = s;
            left = null;
            right = null;
        }
    }
    /**
     * variable root.
     */
     private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * size function.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(root);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final Book key) {
        Node x = root;
        while (x != null) {
            int comp = key.compareTo(x.key);
            if (comp < 0) {
                x = x.left;
            } else if (comp > 0) {
                x = x.right;
            } else if (comp == 0) {
                return x.val;
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final int val) {
        root = put(root, key, val);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Book key, final int val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int comp = key.compareTo(x.key);
        if (comp < 0) {
            x.left = put(x.left, key, val);
        } else if (comp > 0) {
            x.right = put(x.right, key, val);
        } else if (comp == 0) {
            x.val = val;
        }
        return x;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book ceil(final Book key) {
        Node x = ceil(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceil(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int comp = key.compareTo(x.key);
        if (comp == 0) {
            return x;
        }
        if (comp < 0) {
            Node t = ceil(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceil(x.right, key);
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int comp = key.compareTo(x.key);
        if (comp == 0) {
            return x;
        }
        if (comp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * { function_description }.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    // public int rank(Book key) {
    //     return rank(key, root);
    // }
    // private int rank(Book key, Node x) {
    //     if (x == null) {
    //         return 0;
    //     }
    //     int comp = key.compareTo(x.key);
    //     if (comp < 0) {
    //         return rank(key, x.left);
    //     } else if (comp > 0) {
    //         return 1 + size(x.left) + rank(key, x.right);
    //     } else {
    //         return size(x.left);
    //     }
    // }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     */
    public void delete(final Book key) {
        if (key == null) {
            throw new NoSuchElementException("calls delete() with a null key");
        }
        root = delete(root, key);
    }
    /**
     * delete function.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node delete(final Node x, final Book key) {
        Node p = x;
        if (p == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left  = delete(p.left,  key);
        } else if (cmp > 0) {
            p.right = delete(p.right, key);
        } else {
            if  (p.right == null) {
                return p.left;
            }
            if (p.left  == null) {
                return p.right;
            }
            Node temp = p;
            p = min(temp.right);
            p.right = deleteMin(temp.right);
            p.left = temp.left;
        }
        p.size = size(p.left) + size(p.right) + 1;
        return p;
    }
    /**
     * { function_description }.
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMax(root);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * { function_description }.
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMin(root);
    }
    /**
     * delete minimum function.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
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
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Book obj = new Book(tokens[1],
                tokens[2], Float.parseFloat(tokens[2 + 1]));
                bst.put(obj, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                obj = new Book(tokens[1], tokens[2],
                Float.parseFloat(tokens[2 + 1]));
                if (bst.get(obj) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(obj));
                }
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "floor":
                obj = new Book(tokens[1],
                tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.floor(obj));
                break;
            case "ceiling":
                obj = new Book(tokens[1],
                tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.ceil(obj));
                break;
            case "select":
System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "delete":
                obj = new Book(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1]));
                bst.delete(obj);
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            default:
                break;
            }
        }
    }
}
