import java.util.LinkedList;
import java.util.List;

public class StackOfString {
    private List<String> stack;
    StackOfString(){
        stack = new LinkedList<>();
    }

    public void push(String item){
        stack.add(item);
    }
    public String pop(){
        if(!stack.isEmpty()) {
            String temp = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return temp;
        }else{
            return null;
        }
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }

}
