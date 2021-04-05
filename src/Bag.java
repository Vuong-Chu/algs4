import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private int N=0;
    private Node<Item> first;
    Bag(){
        first = new Node();
    }
    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public int size(){
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            return first.item;
        }
    }

    private class Node<Item>{
        Item item;
        Node next;
    }
}
