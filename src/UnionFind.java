public class UnionFind {
    private static int[] array;
    private static int i = 0;
    UnionFind(int n){
        array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = i;
        }
    }
    void union(int a, int b){
        int temp = array[b];
        for(int i=0; i<array.length; i++){
            if(array[i] == temp){
                array[i] = array[a];
            }
        }
    }
    boolean connected(int a, int b){
        return array[a]==array[b];
    }

}
