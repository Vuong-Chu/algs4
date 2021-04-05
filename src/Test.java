import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<String> arr = new ArrayList<>();

        arr.add("Land Rover");
        arr.add("Toyota");
        arr.add("Nissan");
        arr.add("Ford");

        Iterator<String> it = arr.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
