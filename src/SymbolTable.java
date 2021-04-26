import java.util.LinkedList;
import java.util.List;

public class SymbolTable<Key, Value> {
    List<Node> ST;
    SymbolTable(){ST = new LinkedList<>();}
    public void put(Key key, Value value){
        Node node = new Node(key, value);
        if(contains(key)){
            delete(key);
            ST.add(node);
        }else {
            ST.add(node);
        }
    }
    public Value get(Key key){
        for(Node node: ST){
            if(node.key==key){
                return (Value) node.value;
            }
        }
        return null;
    }
    public void delete(Key key){
        for(int i=0; i<ST.size(); i++){
            if(ST.get(i).key==key){
                ST.remove(i);
            }
        }
    }
    public boolean contains(Key key){
        for(int i=0; i<ST.size(); i++){
            if(ST.get(i).key==key){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return ST !=null;
    }
}

class Node<Key,Value>{
    Key key;
    Value value;
    Node next;
    Node(Key key, Value value){
        this.key = key;
        this.value = value;
    }
}
