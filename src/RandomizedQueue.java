import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first, last;
    private int size;
    // construct an empty randomized queue
    public RandomizedQueue(){

    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if (item==null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            first = new Node<>();
            first.item = item;
            last = first;
        } else {
            Node<Item> newLast = new Node<>();
            newLast.item = item;
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        Node<Item> current = first;
        int r = StdRandom.uniform(size);
        Item item = null;
        if (r == 0) {
            item = first.item;
            if(current.next==null){
                first = null;
                last = null;
            }else{
                first = first.next;
            }
        } else {
            int i = 0;
            while(current.next!=null && i+1 != r){
                current = current.next;
                i++;
            }
            if(current.next!=null) {
                item = current.next.item;
                if (current.next == last) {
                    last = current;
                    current.next=null;
                }else {
                    current.next = current.next.next;
                }
            }
        }
        size--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Node<Item> current = first;
        int r = StdRandom.uniform(size);
        int i = 0;
        while (current.next!=null) {
            if (i==r) {
                break;
            }
            current = current.next;
        }
        return current.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] arr = (Item[]) new Object[size];
        private int counter = 0;
        private Node<Item> current = first;
        {
            int i=0;
            while(i!=size){
                arr[i] = current.item;
                current = current.next;
                i++;
            }
            StdRandom.shuffle(arr);
        }

        @Override
        public boolean hasNext() {
            return counter<arr.length;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                return arr[counter++];
            }else{
                throw new java.util.NoSuchElementException();
            }
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        RandomizedQueue<Integer> rdQueue = new RandomizedQueue<>();
        System.out.println(rdQueue.isEmpty());
        System.out.println(rdQueue.size());
        //rdQueue.iterator().hasNext();
        //System.out.println(rdQueue.iterator().next());
        rdQueue.enqueue(1);
        System.out.println(rdQueue.isEmpty());
        rdQueue.dequeue();
        System.out.println(rdQueue.isEmpty());
        System.out.println(rdQueue.size());
        rdQueue.enqueue(2);
        rdQueue.enqueue(3);
        rdQueue.enqueue(4);
        rdQueue.enqueue(5);
        System.out.println(rdQueue.isEmpty());
        Iterator<Integer> it = rdQueue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(rdQueue.isEmpty());
        System.out.println(rdQueue.size());
        System.out.println(rdQueue.sample());
        System.out.println(rdQueue.sample());
        System.out.println(rdQueue.sample());
        System.out.println(rdQueue.sample());
        System.out.println(rdQueue.dequeue());
        System.out.println(rdQueue.size());
//        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
//        queue.enqueue(457);
//        queue.enqueue(91);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.isEmpty());
//        System.out.println(queue.size());
//        Iterator<Integer> it = queue.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
    }

    private class Node<Item>{
        Item item;
        Node<Item> next;
    }
}
