import java.util.Deque;
import java.util.LinkedList;

public class QueueOfString1 {
    Deque<String> Queue;
    QueueOfString1(){
        Queue = new LinkedList<>();
    }
    public void enqueue(String item){
        Queue.add(item);
    }
    public String dequeue(){
        String item = Queue.getFirst();
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
