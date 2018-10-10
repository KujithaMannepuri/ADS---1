import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
public class MinPQ<Key> implements Iterable<Key> {
    /**
     * { var_description }.
     */
    private Key[] pq;
    /**
     * { item_description }.
     */// store items at indices 1 to n
    private int n; 
    /**
     * { item_description }.
     */// number of items on priority queue
    private Comparator<Key> comparator;
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      initCapacity  The initialize capacity
     */
    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue.
     * Time complexity is 1.
     */
    public MinPQ() {
        this(1);
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator    The comparator
     */
    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      comparator  The comparator
     */
    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Constructs the object.
     * Time complexity is N.
     *
     * @param      keys  The keys
     */
    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i+1] = keys[i];
        }
        for (int k = n/2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }

    /**
     * Determines if empty.
     * Time complexity is 1.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * size method.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }.
     */
    public int size() {
        return n;
    }

    /**
     * minimum.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }.
     */
    public Key min() {
        if (isEmpty()) throw new
            NoSuchElementException("Priority queue underflow");
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
     * insert.
     * Time complexity is 1.
     *
     * @param      x     { parameter_description }
     */
    public void insert(Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);

        
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }
    /**
     * del minimum.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }.
     */
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }
    /**
     * swim method.
     * Time complexity is logN.
     *
     * @param      k     { parameter_description }
     */
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    /**
     * sink.
     * Time complexity is N.
     *
     * @param      k     { parameter_description }.
     */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    /**
     * greater.
     * Time complexity is 1.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * exchange.
     * Time complexity is 1.
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
     * Determines if minimum heap.
     * Time complexity is 1.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     * Time complexity is 1.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    /**
     * iterator.
     * Time complexity is 1.
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
        private MinPQ<Key> copy;
        public HeapIterator() {
            if (comparator == null) {
                copy = new MinPQ<Key>(size());
            } else {
                copy = new MinPQ<Key>(size(), comparator);
            }                   
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }
        /**
         * Determines if it has next.
         * Time complexity is 1.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**
         * remove.
         * Time complexity is 1.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next.
         * Time complexity is 1.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
