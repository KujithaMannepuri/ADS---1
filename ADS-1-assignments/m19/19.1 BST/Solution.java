import java.util.Scanner;

class Book implements Comparable {
    
    private String name;
    
    private String author;
    
    private float price;
    
    Book(final String book,
                final String bAuthor, final float bPrice) {
        this.name = book;
        this.author = bAuthor;
        this.price = bPrice;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public float getPrice() {
        return this.price;
    }
    
    public int compareTo(final Object object) {
        Book that = (Book) object;
        return this.name.compareTo(that.name);
    }
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}

class BinarySearchTree {
    
    private final class Node {
        
        private Book key;
        
        private int val;
        
        private Node left;
        
        private Node right;
        
        private int size;
        
        private Node(final Book key1, final int val1, final int s) {
            this.key = key1;
            this.val = val1;
            this.size = s;
            left = null;
            right = null;
        }
    }

     private Node root;

    BinarySearchTree() {
        root = null;
    }
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    
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
    
    public void put(final Book key, final int val) {
        root = put(root, key, val);
    }
   
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

    public Book max() {
        return max(root).key;
    }
    
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    public Book min() {
        return min(root).key;
    }
    
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    public Book ceil(Book key) {
        Node x = ceil(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    
    private Node ceil(Node x, Book key) {
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
    
    public Book floor(Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    
    private Node floor(Node x, Book key) {
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
    
    public Book select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    
    private Node select(Node x, int k) {
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
}

public final class Solution {
    
    private Solution() {
      
    }
    
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
            default:
                break;
            }
        }
    }
}