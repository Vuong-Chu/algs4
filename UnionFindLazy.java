public class UnionFindLazy {
    static int[] array;

    UnionFindLazy(int n){
        array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = i;
        }
    }

    void union(int a, int b){
        array[rootID(b)] = rootID(a);
    }

    boolean connected(int a, int b){
        int rootA = rootID(a);
        int rootB = rootID(b);
        return rootA == rootB;
    }

    int rootID(int a){
        return array[a]==a ? a: rootID(array[a]);
    }

}
