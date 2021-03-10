package algs4; /**
 * This code is to print out a string to the screen
 * @author vuongchu
 *
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {
            StdOut.printf("Hello %s and %s.\n", args[0], args[1]);
            StdOut.printf("Goodbye %s and %s.", args[1], args[0]);
    }
}
