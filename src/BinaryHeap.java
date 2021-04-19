public class BinaryHeap<Key extends Comparable<Key>> {
    Key[] Heap;
    int N;

    BinaryHeap(int capacities){
        Heap = (Key[]) new Comparable[capacities];
    }

    private void swim(int k){
        while(k>1 && Heap[k].compareTo(Heap[k/2])==-1){
            Key temp = Heap[k];
            Heap[k] = Heap[k/2];
            Heap[k/2]=temp;
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && Heap[j].compareTo(Heap[j+1])==-1){
                j++;
            }
            if((Heap[k].compareTo(Heap[j])==1)){
                break;
            }
            Key temp = Heap[k];
            Heap[k] = Heap[j];
            Heap[j]=temp;
            k=j;
        }
    }

    public void insert(Key val){
        Heap[++N] = val;
        swim(N);
    }

    public Key delMax(){
        Key max = Heap[1];
        Key temp = Heap[1];
        Heap[1] = Heap[N--];
        Heap[N--]=temp;
        sink(1);
        Heap[N+1]=null;
        return max;
    }
}
