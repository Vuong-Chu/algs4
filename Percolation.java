import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    private boolean[][] site;
    private WeightedQuickUnionUF quickUnionUF;
    private int open = 0;
    private int sizeGrid;
    // creates n-by-n site, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Values are out of range");
        } else {
            sizeGrid = n;
            quickUnionUF = new WeightedQuickUnionUF(sizeGrid * sizeGrid + 2);
            site = new boolean[sizeGrid+1][sizeGrid+1];
            for (int i = 1; i <= sizeGrid; i++) {
                for (int j = 1; j <= sizeGrid; j++) {
                    site[i][j] = false;
                }
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > sizeGrid || col < 1 || col > sizeGrid) {
            throw new IllegalArgumentException("Values are out of range");
        }
        if (isOpen(row, col)) {
            return;
        }
        int index = from2Dto1D(row, col);
            open += 1;
            site[row][col] = true;
        if (row == 1) {
            quickUnionUF.union(index, 0);
            if (col == 1 && isOpen(row, col + 1)) {
                    quickUnionUF.union(index, index + 1);
            } else if (col == sizeGrid && isOpen(row, col - 1)) {
                    quickUnionUF.union(index, index - 1);
            } else {
                if (col != 1 && isOpen(row, col - 1)) {
                    quickUnionUF.union(index, index - 1);
                }
                if (col != sizeGrid && isOpen(row, col + 1)) {
                    quickUnionUF.union(index, index + 1);
                }
            }
            if (isOpen(row+1, col)) {
                quickUnionUF.union(index, index + sizeGrid);
            }
        } else if (row == sizeGrid) {
            quickUnionUF.union(index, sizeGrid * sizeGrid+1);
            if (col == 1 && isOpen(row, col + 1)) {
                    quickUnionUF.union(index, index + 1);
            } else if (col == sizeGrid && isOpen(row, col - 1)) {
                    quickUnionUF.union(index, index - 1);
            } else {
                if (col != sizeGrid && isOpen(row, col + 1)) {
                    quickUnionUF.union(index, index + 1);
                }
                if (col != 1 && isOpen(row, col - 1)) {
                    quickUnionUF.union(index, index - 1);
                }
            }
            if (isOpen(row-1, col)) {
                quickUnionUF.union(index, index - sizeGrid);
            }
        } else {
            if (col != sizeGrid && isOpen(row, col + 1)) {
                quickUnionUF.union(index, index + 1);
            }
            if (col != 1 && isOpen(row, col - 1)) {
                quickUnionUF.union(index, index - 1);
            }
            if (isOpen(row-1, col)) {
                quickUnionUF.union(index, index - sizeGrid);
            }
            if (isOpen(row+1, col)) {
                quickUnionUF.union(index, index + sizeGrid);
            }
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > sizeGrid || col < 1 || col > sizeGrid) {
            throw new IllegalArgumentException("Values are out of range");
        } else {
            return site[row][col];
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > sizeGrid || col < 1 || col > sizeGrid) {
            throw new IllegalArgumentException("Values are out of range");
        } else {
            int index = from2Dto1D(row, col);
            return isOpen(row, col) && quickUnionUF.find(index) == quickUnionUF.find(0) ? true : false;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return open;
    }

    // does the system percolate?
    public boolean percolates() {
        return quickUnionUF.find(sizeGrid*sizeGrid+1) == quickUnionUF.find(0);
    }

    public int from2Dto1D(int row, int col){
        return (row - 1) * sizeGrid + col;
    }


    // test client (optional)
//    public static void main(String[] args) {
//        Percolation per = new Percolation(3);
//        per.open(1,1);
//        per.open(2,1);
//        per.open(3,1);
//        System.out.println(per.isOpen(2,1));
//        System.out.println(per.isFull(2,1));
//        System.out.println(per.percolates());
//    }
}