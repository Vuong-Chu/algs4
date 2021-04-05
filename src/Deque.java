import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first, last;
    private int size;
    // construct an empty deque
    public Deque(){

    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            first = new Node<>();
            first.item = item;
            last = first;
        } else {
            Node<Item> newFirst = new Node<>();
            newFirst.item = item;
            newFirst.next = first;
            first.previous = newFirst;
            first = newFirst;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            last = new Node<>();
            last.item = item;
            first = last;
        }else {
            Node<Item> newLast = new Node<>();
            newLast.item = item;
            newLast.previous = last;
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }else {
            Item item = first.item;
            if(first==last){
                first=null;
                last = first;
            }else{
                first = first.next;
                first.previous = null;
            }
            size--;
            return item;
        }
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            Item item = last.item;
            if(first==last){
                last = null;
                first=last;
            }else{
                last = last.previous;
                last.next = null;
            }
            size--;
            return item;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            } else {
                throw new java.util.NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<Integer> deck = new Deque<>();
        //deck.addFirst(null);
        //deck.addLast(null);
        //System.out.println(deck.removeFirst());
        //System.out.println(deck.removeLast());
        //System.out.println(deck.iterator().next());
        //deck.iterator().remove();
        System.out.println(deck.isEmpty());
        System.out.println(deck.size());
        deck.addFirst(5);
        System.out.println(deck.removeFirst());
        deck.addLast(4);
        System.out.println(deck.removeLast());
        deck.addFirst(5);
        deck.addFirst(4);
        deck.addFirst(3);
        deck.addLast(6);
        deck.addLast(7);
        deck.addLast(8);
        System.out.println(deck.size());
        Iterator<Integer> it1 = deck.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println(deck.removeFirst());
        System.out.println(deck.removeLast());
        System.out.println(deck.isEmpty());
        System.out.println(deck.size());
        Iterator<Integer> it2 = deck.iterator();
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }
    }

    private class Node<Item>{
        Item item;
        Node<Item> next;
        Node<Item> previous;
    }
}
