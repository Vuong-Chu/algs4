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
        if(item==null){
            throw new IllegalArgumentException();
        }
        if(isEmpty()){
            first = new Node<>();
            first.item = item;
            last = first;
        }else{
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
        if(r==0){
            item = first.item;
            first = first.next;
        }else{
            int i=0;
            while(current.next!=null){
                if(i+1==r){
                    break;
                }
                current = current.next;
                i++;
            }
            item = current.next.item;
            current.next = current.next.next;
        }
        size--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        Node<Item> current = first;
        int r = StdRandom.uniform(size);
        int i=0;
        while (current.next!=null){
            if(i==r){
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
        Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(hasNext()){
                Item item = current.item;
                current = current.next;
                return current.item;
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

    }

    class Node<Item>{
        Item item;
        Node<Item> next;
    }
}
