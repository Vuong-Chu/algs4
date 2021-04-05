public class WeightedUnionFind {
    private static int[] array;
    private static int[] sz;
    WeightedUnionFind(int n){
        array = new int[n];
        sz = new int[n];
        for(int i=0; i<n; i++){
            array[i] = i;
            sz[i] = 1;
        }
    }

    void union(int a, int b){
        int rootA = rootID(a);
        int rootB = rootID(b);
        if(rootA==rootB){
            return;
        }
        if(sz[rootA]<sz[rootB]){
            sz[rootA] += sz[rootB];
            array[rootB] = array[rootA];
        }else{
            sz[rootB] += sz[rootA];
            array[rootA] = array[rootB];
        }
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
