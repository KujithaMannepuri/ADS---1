import java.util.Scanner;
 class Percolation {
/**
 * grid matrix.
 */
    private boolean[][] grid;
    /**
     * top variable.
     */
    private int top = 0;
    /**
     * bottom variable.
     */
    private int bottom;
    /**
     * size variable.
     */
    private int size;
    /**
     * variable for weighted quick union.
     */
    private WeightedQuickUnionUF qf;

    /**
     * constructor for percolation class.
     * @param n integer variable.
     */
     Percolation(final int n) {
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        grid = new boolean[size][size];
    }

    /**
     * @param i integer variable.
     * @param j integer variable.
     * open method for percolation class.
     */
    public void open(final int i, final int j) {
        grid[i - 1][j - 1] = true;
        if (i == 1) {
            qf.union(component(i, j), top);
        }
        if (i == size) {
            qf.union(component(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            qf.union(component(i, j), component(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            qf.union(component(i, j), component(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            qf.union(component(i, j), component(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            qf.union(component(i, j), component(i + 1, j));
        }
    }

    /**
     * checks if the given block is open or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is open.
     */
    public boolean isOpen(final int i, final int j) {
        return grid[i - 1][j - 1];
    }

    /**
     * checks if block is full or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is full.
     */
    public boolean isFull(final int i, final int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return qf.connected(top, component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checks for percolation.
     * @return returns true if percolation is possible.
     */
    public boolean percolates() {
        return qf.connected(top, bottom);
    }
    /**
     * method to find the component at given indices.
     *
     * @param      i  integer variable.
     * @param      j  integer variable.
     *
     * @return returns the component value.
     */
    private int component(final int i, final int j) {
        return size * (i - 1) + j;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * constructor for solution class.
     */
    protected Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Percolation p = new Percolation(size);
        while (sc.hasNext()) {
            p.open(sc.nextInt(), sc.nextInt());
        }
        System.out.println(p.percolates());
    }
}
