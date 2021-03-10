public class PercolationStats {

    private int[] results;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        Percolation percolation = new Percolation(n);
        results = new int[trials];
        for(int i=0; i<trials; i++){

            results[i] = percolation.numberOfOpenSites()/(n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        double sum = 0;
        for(int value: results){
            sum += value;
        }
        return sum/results.length;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        double sumSquare = 0;
        double mean = mean();
        for(int value: results){
            sumSquare += Math.pow(value - mean,2);
        }
        return Math.sqrt(sumSquare/(results.length-1));
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        double mean = mean();
        double std = stddev();
        return mean - 1.96*std/Math.sqrt(results.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        double mean = mean();
        double std = stddev();
        return mean + 1.96*std/Math.sqrt(results.length);
    }

    // test client (see below)
    public static void main(String[] args){

    }

}