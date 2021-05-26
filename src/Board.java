import edu.princeton.cs.algs4.StdRandom;

public class Board {
    private final int[][] board;
    private final int n;
    private int[] arr;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles){
        n = tiles.length;
        board = new int[n][n];
        arr = new int[n*n];
        int index = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
               board[i][j] = tiles[i][j];
               arr[index++] = tiles[i][j];
            }
        }
    }

    // string representation of this board
    public String toString(){
        String result = board.length+"/n";
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                result += board[i][j]+" ";
            }
            result +="/n";
        }
        return result;
    }

    // board dimension n
    public int dimension(){
        return n;
    }

    // number of tiles out of place
    public int hamming(){
        int countHamming = 0;
        for(int i=0; i<n*n-1; i++){
            if(i+1!=arr[i]){
                countHamming++;
            }
        }
        if(arr[n*n-1]!=0){
            countHamming++;
        }
        return countHamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan(){

    }

    // is this board the goal board?
    public boolean isGoal(){

    }

    // does this board equal y?
    public boolean equals(Object y){

    }

    // all neighboring boards
    public Iterable<Board> neighbors(){

    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin(){

    }

    // unit testing (not graded)
    public static void main(String[] args){

    }

}