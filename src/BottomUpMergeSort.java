public class BottomUpMergeSort {
    public static void main(String[] args){
        int[] arr = new int[]{1,5,2,4,6,9,8,7};
        sort(arr);
        for(int value: arr){
            System.out.println(value);
        }
    }
    public static void sort(int[] arr){
        int N = arr.length;
        for(int sz=1; sz<N; sz=sz+sz){
            for(int lo=0; lo<N-sz; lo +=sz+sz){
                merging(arr,lo,lo+sz-1, Math.min(lo+sz+sz, N-1));
            }
        }
    }
    public static void merging(int[] arr, int lo, int mid, int hi){
        int[] aux = new int[arr.length];
        for(int k=0; k<=hi; k++){
            aux[k] = arr[k];
        }
        int i = lo;
        int j = mid+1;
        for(int k=lo; k<=hi; k++){
            if(i>mid){
                arr[k] = aux[j++];
            }else if(j<=mid){
                arr[k] = aux[i++];
            }else if(aux[i]<aux[j]){
                arr[k] = aux[i];
            }else{
                arr[k] = aux[j];
            }
        }
    }
}
