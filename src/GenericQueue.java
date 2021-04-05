import java.util.Deque;
import java.util.LinkedList;

public class GenericQueue <Item> {
    Deque<Item> Queue;
    GenericQueue(){
        Queue = new LinkedList<>();
    }
    public void enqueue(Item item){
        Queue.add(item);
    }
    public Item dequeue(){
        Item item = Queue.getFirst();
        Queue.removeFirst();
        return item;
    }
    public boolean isEmpty(){
        return Queue.size()==0 ? true : false;
    }
    public int size(){
        return Queue.size();
    }
}
