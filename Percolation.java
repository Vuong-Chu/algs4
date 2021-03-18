import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    private static boolean[][] grid;
    private static WeightedQuickUnionUF UF;
    private int open = 0;
    private static int N;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if(n<=0){
            throw new IllegalArgumentException();
        }else {
            N=n;
            UF = new WeightedQuickUnionUF(N * N + 2);
            grid = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = false;
                }
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= N){
            throw new IllegalArgumentException();
        }else {
            int index = row * N + col;
            if (!isOpen(row, col)) {
                open++;
                grid[row][col] = true;
                if(row == 0){
                    UF.union(index, N);
                    if(col!=N-1){
                        if(isOpen(row,col+1)){
                            UF.union(index, index+1);
                        }
                    }
                    if(isOpen(row+1,col)){
                        UF.union(index, index+N);
                    }
                    if(col!=0){
                        if(isOpen(row,col-1)){
                            UF.union(index, index-1);
                        }
                    }
                }else{
                    if(col != N-1){
                        if(isOpen(row,col+1)){
                            UF.union(index, index+1);
                        }
                    }
                    if(row != N-1) {
                        if (isOpen(row + 1, col)) {
                            UF.union(index, index + N);
                        }
                    }
                    if(col!=0) {
                        if (isOpen(row, col - 1)) {
                            UF.union(index, index - 1);
                        }
                    }
                    if(isOpen(row-1,col)){
                        UF.union(index, index-N);
                    }
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= N){
            throw new IllegalArgumentException();
        }else {
            return grid[row][col];
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= N){
            throw new IllegalArgumentException();
        }else {
            int index = row * N + col;
            return isOpen(row, col) && UF.connected(index, N) ? true : false;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return open;
    }

    // does the system percolate?
    public boolean percolates(){
        return UF.connected(N+1,N);
    }

    // test client (optional)
    public static void main(String[] args){
        Percolation per = new Percolation(20);
        System.out.println(per.isOpen(StdRandom.uniform(20),StdRandom.uniform(20)));
    }
}