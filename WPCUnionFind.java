public class WPCUnionFind {
    static int[] array;
    static int[] sz;
    WPCUnionFind(int n){
        array = new int[n];
        sz = new int[n];
        for(int i=0;i<n;i++){
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
            array[rootA]=rootB;
        }else{
            sz[rootB] += sz[rootA];
            array[rootB]=rootA;
        }
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
