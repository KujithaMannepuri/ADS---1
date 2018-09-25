import java.util.*;
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
class Percolation {
	int[][] grid;
	int opensite;
	int size;
	WeightedQuickUnionUF wqunion;
	Percolation(int size) {
		grid = new int[size][size];
		opensite = 0;
		wqunion = new WeightedQuickUnionUF((size * size) + 2);
		size = size;
	}
	public void open(int row, int col) {
		row = row - 1;
		col = col - 1;
		grid[row][col] = 1;
		opensite++;
		if (row == 0) {
			wqunion.union(0, component(row, col));
		}
		if (row == size - 1) {
			wqunion.union(((size * size) + 1), component(row, col));
		}
		if (row > 0) {
			if (grid[row + 1][col] == 1) {
				wqunion.union(component(row, col), component(row + 1, col));
			}
		}
		if (row <= size - 1) {
			if (grid[row - 1][col] == 1) {
				wqunion.union(component(row, col), component(row - 1, col));
			}
		}
		if (col > 0) {
			if (grid[row][col + 1] == 1) {
				wqunion.union(component(row, col), component(row, col + 1));
			}
		}
		if (col <= size - 1) {
			if (grid[row][col + 1] == 1) {
				wqunion.union(component(row, col), component(row, col - 1));
			}
		}

	}
	public int component(int i, int j) {
		return ((i * size) + j) + 1;
	}
	public boolean isOpen(int row, int col) {
		return grid[row-1][col-1] == 1;
	}
	public boolean isFull(int row, int col) {
		return grid[row-1][col-1] == 0;
	}
	public int numberOfOpenSites() {
		return opensite;
	}
	public boolean percolates() {
		return wqunion.connected(0,(size * size) + 1);
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ip = sc.nextInt();
		Percolation grids = new Percolation(ip);
		while (sc.hasNext()) {
			grids.open(sc.nextInt(), sc.nextInt());
		}
		System.out.println(grids.percolates());
	}
}