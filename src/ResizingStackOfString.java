//Insert N items: O(3N)
public class ResizingStackOfString {
    private int N = 1;
    private String[] Stack;


    ResizingStackOfString(){
        Stack = new String[N];
    }

    private void resize(int newLength){
        String[] copy = new String[newLength];
        for(int i=0; i<N; i++){
            copy[i] = Stack[i];
        }
        Stack = copy;
    }

    public boolean isEmpty(){
        return N==0? true: false;
    }

    public void push(String item){
        if(N==Stack.length){
            resize(2*Stack.length);
        }
        Stack[++N] = item;
    }

    public String pop(){
        String item = Stack[--N];
        Stack[N] = null;
        if(N>0 && N==Stack.length/4){
            resize(Stack.length/2);
        }
        return item;
    }

}
