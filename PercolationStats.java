import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    private double[] results;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        results = new double[trials];
        for(int i=0; i<trials; i++){
            Percolation percolation = new Percolation(n);
            while(!percolation.percolates()) {
                percolation.open(StdRandom.uniform(n), StdRandom.uniform(n));
            }
            results[i] = percolation.numberOfOpenSites()*1.0/(1.0*n*n);
        }

    }

    // sample mean of percolation threshold
    public double mean(){
        double sum = 0;
        for(double value: results){
            sum += value;
        }
        return sum/results.length;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        double sumSquare = 0;
        double mean = mean();
        for(double value: results){
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
        PercolationStats stat = new PercolationStats(200, 100);
        System.out.println("mean = "+stat.mean());
        System.out.println("mean = "+stat.stddev());
        System.out.println("95% confidence interval =" + stat.confidenceLo()+"-"+stat.confidenceHi());
    }

}