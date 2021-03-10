package algs4; /**
 * This code is to print out a string to the screen
 * @author vuongchu
 *
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String result = "";
        double i = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            i++;
            if (StdRandom.bernoulli(1/i)) {
                result = s;
            }
        }
        StdOut.println(result);
    }
}
