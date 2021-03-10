public class PathCompressionUF {
    static int[] array;

    PathCompressionUF(int n){
        array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = i;
        }
    }

    void union(int a, int b){
        array[rootID(a)] = rootID(b);
    }

    boolean connected(int a, int b){
        return rootID(a)==rootID(b);
    }

    int rootID(int a){
        if(array[a]==a){
            return a;
        }else{
            array[a] = array[array[a]];
            return rootID(array[a]);
        }
    }
}
