import java.util.Iterator;

public class QueueOfString2<Item> implements Iterable<Item>{
    Node<Item> first, last;
    int N=0;
    QueueOfString2(){
    }
    public void enqueue(Item item){
        if(isEmpty()){
            first = new Node();
            first.item = item;
        }else{
            last = new Node();
            last.item = item;
            first.next = last;
        }
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = null;
        N--;
        return item;
    }
    public boolean isEmpty(){
        return first.item == null;
    }
    public int size(){
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    class Node<Item>{
        Item item;
        Node next;
    }
}


