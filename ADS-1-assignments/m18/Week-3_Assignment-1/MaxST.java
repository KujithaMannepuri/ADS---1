import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Class for maximum pq.
 *
 * @param      <Key>  The key
 */
public class MaxST<Key> implements Iterable<Key> {
    /**
     * key array.
     */
    private Key[] pq;
    /**
     * Integer n.
     */
    private int n;
    /**
     * variable comparator.
     */
    private Comparator<Key> comparator;  

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue.
     * Time complexity is 1.
     */
    public MaxST(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     * Time complexity is 1.
     */
    public MaxST() {
        this(1);
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator    The comparator
     */
    public MaxST(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue using the given comparator.
     * Time complexity is 1.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MaxST(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Time complexity is N.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MaxST(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
    /**
     *Time complexity is 1.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     * Time complexity is 1.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }
    /**
     * Returns a largest key on this priority queue.
     * Time complexity is 1.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * resize.
     * Time complexity is N.
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * Adds a new key to this priority queue.
     * Time complexity is 1.
     *
     * @param  x the new key to add to this priority queue
     */
    public void insert(Key x) {

        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }
    /**
     * exchange.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     *Time complexity is 1.
     * less function.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    /**
     *Time complexity is 1.
     * delMax function.
     *
     * @return     { description_of_the_return_value }
     */
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiteing and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }
    /**
     *Time complexity is N.
     * sink function.
     *
     * @param      k     { parameter_description }
     */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    /**
     * swim function.
     * Time complexity is logN.
     *
     * @param      k     { parameter_description }
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    
    /**
     *Time complexity is 1.
     * Determines if maximum heap.
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }
    /**
     *  Time complexity is 1.
     * Determines if maximum heap.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
    /**
     *Time complexity is 1.
     * Iterator function.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**
     * Class for heap iterator.
     * Time complexity is 1.
     */
    private class HeapIterator implements Iterator<Key> {
        /**
         * variable copy.
         */
        private MaxST<Key> copy;
        /**
         * Constructs the object.
         */
        public HeapIterator() {
            if (comparator == null) {
                copy = new MaxST<Key>(size());
            } else {
                copy = new MaxST<Key>(size(), comparator);
            }
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }
        /**
         *Time complexity is 1.
         * remove function.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * Determines if it has next.
         *
         * @return True if has next, False otherwise.
         */
        public boolean hasNext()  { 
            return !copy.isEmpty();
        }
        /**
         * next.
         * Time complexity is 1.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}
