public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    UnorderedMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
    };
    void insert(Key v){
        pq[N++] = v;
    }
    Key delMax(){
        int max = 0;
        for(int i=1; i<N; i++){
            if(pq[max].compareTo(pq[i])==-1){
                max = i;
            }
        }
        Key temp = pq[max];
        pq[max] = pq[N-1];
        return pq[--N];
    }
    boolean isEmpty(){
        return N==0;
    }
    Key max(){
        int max = 0;
        for(int i=1; i<N; i++){
            if(pq[max].compareTo(pq[i])==-1){
                max = i;
            }
        }
        return pq[max];
    }
    int size(){
        return N;
    }


}
