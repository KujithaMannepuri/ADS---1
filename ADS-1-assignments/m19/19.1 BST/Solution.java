import java.util.Scanner;

class BookDetails implements Comparable {
    
    private String name;
    
    private String author;
    
    private float price;
    
    BookDetails(final String book,
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
        BookDetails that = (BookDetails) object;
        return this.name.compareTo(that.name);
    }
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}

class BinarySearchTree {
    
    private Node root;
    
    private final class Node {
        
        private BookDetails key;
        
        private int val;
        
        private Node left;
        
        private Node right;
        
        private int size;
        
        private Node(final BookDetails key1, final int val1, final int s) {
            this.key = key1;
            this.val = val1;
            this.size = s;
            left = null;
            right = null;
        }
    }
    
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
    
    public int get(final BookDetails key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return -1;
    }
    
    public void put(final BookDetails key, final int val) {
        root = put(root, key, val);
    }
   
    private Node put(final Node x, final BookDetails key, final int val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
    
    public BookDetails min() {
        return min(root).key;
    }
    
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
   
    public BookDetails max() {
        return max(root).key;
    }
    
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    
    public BookDetails floor(BookDetails key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    
    private Node floor(Node x, BookDetails key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    
    public BookDetails ceil(BookDetails key) {
        Node x = ceil(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    
    private Node ceil(Node x, BookDetails key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceil(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceil(x.right, key);
    }
    
    public BookDetails select(int k) {
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
    
    // public int rank(BookDetails key) {
    //     return rank(key, root);
    // }
    
    // private int rank(BookDetails key, Node x) {
    //     if (x == null) {
    //         return 0;
    //     }
    //     int cmp = key.compareTo(x.key);
    //     if (cmp < 0) {
    //         return rank(key, x.left);
    //     } else if (cmp > 0) {
    //         return 1 + size(x.left) + rank(key, x.right);
    //     } else {
    //         return size(x.left);
    //     }
    // }
}

public final class Solution {
    
    // private Solution() {
      
    // }
    
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bstobj = new BinarySearchTree();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                BookDetails deobj = new BookDetails(tokens[1],
                                                    tokens[2], Float.parseFloat(tokens[2 + 1]));
                bstobj.put(deobj, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                deobj = new BookDetails(tokens[1], tokens[2],
                                        Float.parseFloat(tokens[2 + 1]));
                if (bstobj.get(deobj) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bstobj.get(deobj));
                }
                break;
            case "max":
                System.out.println(bstobj.max());
                break;
            case "min":
                System.out.println(bstobj.min());
                break;
            case "select":
                System.out.println(bstobj.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                deobj = new BookDetails(tokens[1],
                                        tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bstobj.floor(deobj));
                break;
            case "ceiling":
                deobj = new BookDetails(tokens[1],
                                        tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bstobj.ceil(deobj));
                break;
            default:
                break;
            }
        }
    }
}