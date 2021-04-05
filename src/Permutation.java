import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int inCount = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s!=null && s.length()>0) {
                queue.enqueue(s);
                inCount++;
            }
        }
        if (inCount<k) {
            throw new java.util.NoSuchElementException();
        }
        while (k>0) {
            System.out.println(queue.dequeue());
            k--;
        }
    }
}
