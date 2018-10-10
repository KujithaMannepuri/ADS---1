import java.util.Scanner;
import java.util.NoSuchElementException;

class BinarySearchST<Key extends Comparable<Key>, Value> {
    
    private static final int INIT_CAPACITY = 2;
    
    private Key[] keys;
    
    private Value[] val;
    
    private int num = 0;
    
    BinarySearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        val = (Value[]) new Object[capacity];
    }
    
    BinarySearchST() {
        this(INIT_CAPACITY);
    }
    
    public int size() {
        return num;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }
    
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < num && keys[i].compareTo(key) == 0) {
            return val[i];
        }
        return null;
    }
    
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int lo = 0, hi = num - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                 hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    
    public void put(final Key key, final Value val1)  {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val1 == null) {
            delete(key);
            return;
        }
        int i = rank(key);

        
        if (i < num && keys[i].compareTo(key) == 0) {
            val[i] = val1;
            return;
        }

       
        if (num == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = num; j > i; j--)  {
            keys[j] = keys[j - 1];
            val[j] = val[j - 1];
        }
        keys[i] = key;
        val[i] = val1;
        num++;

        assert check();
    }
    
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i == num || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < num - 1; j++)  {
            keys[j] = keys[j + 1];
            val[j] = val[j + 1];
        }
        num--;
        keys[num] = null;
        val[num] = null;
        final int four = 4;
        if (num > 0 && num == keys.length / four) {
            resize(keys.length / 2);
        }
        assert check();
    }
    
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }
    
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Symbol table underflow error");
        }
        delete(max());
    }
  
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called min() with empty symbol table");
        }
        return keys[0];
    }

   
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called max() with empty symbol table");
        }
        return keys[num - 1];
    }

   
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < num && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == num) {
            return null;
        } else {
            return keys[i];
        }
    }

    
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
     private void resize(final int capacity) {
        assert capacity >= num;
        Key[]   keyTemp = (Key[])   new Comparable[capacity];
        Value[] valTemp = (Value[]) new Object[capacity];
        for (int i = 0; i < num; i++) {
            keyTemp[i] = keys[i];
            valTemp[i] = val[i];
        }
        val = valTemp;
        keys = keyTemp;
    }
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
    private boolean check() {
        return isSorted() && rankCheck();
    }
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size() - 1; i++) {
            s += keys[i] + " " + val[i] + "\n";
        }
        s += keys[i] + " " + val[i];
        return s;
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchST<String, Integer> ip
            = new BinarySearchST<String, Integer>();
        String[] lines = sc.nextLine().split(" ");
        for (int i = 0; i < lines.length; i++) {
            ip.put(lines[i], i);
        }
        while (sc.hasNextLine()) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
                case "keys":
                    System.out.println(ip);
                    break;
                case "contains":
                    System.out.println(ip.contains(token[1]));
                    break;
                case "floor":
                    System.out.println(ip.floor(token[1]));
                    break;
                case "rank":
                    System.out.println(ip.rank(token[1]));
                    break;
                case "get":
                    System.out.println(ip.get(token[1]));
                    break;
                case "max":
                    System.out.println(ip.max());
                    break;
                case "deleteMin":
                    ip.deleteMin();
                    break;
                default:
                    break;
            }
        }
    }
}
