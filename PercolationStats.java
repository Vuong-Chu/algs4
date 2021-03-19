import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double confidence95 = 1.96;
    private double[] results;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        results = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(n)+1, StdRandom.uniform(n)+1);
            }
            results[i] = percolation.numberOfOpenSites()*1.0/(1.0*n*n);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        double std = stddev();
        return mean - confidence95*std/Math.sqrt(results.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        double std = stddev();
        return mean + confidence95*std/Math.sqrt(results.length);
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }
        int gridSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
      PercolationStats stat = new PercolationStats(gridSize, trials);
      System.out.println("mean                    = "+stat.mean());
      System.out.println("stddev                  = "+stat.stddev());
      System.out.printf("95%% confidence interval = [%s, %s]\n", stat.confidenceLo(), stat.confidenceHi());
    }

}