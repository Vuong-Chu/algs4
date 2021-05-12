public class MergeSort {
    public static void main(String[] args){
        int i = 0;
        int[] arr = new int[]{3,2,5,4,1};
        Sort(arr,0,arr.length-1);

        for(int value: arr){
            System.out.println(value);
        }
    }

    public static void Sort(int[] arr, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int mid = lo+(hi-lo)/2;
        Sort(arr,lo,mid);
        Sort(arr,mid+1,hi);
        Merging(arr,lo,mid,hi);
    }

    public static void Merging(int[] arr, int lo, int mid, int hi) {
        int[] aux = new int[arr.length];
        for(int k=lo; k<=hi; k++){
            aux[k] = arr[k];
        }
        int i = lo;
        int j = mid+1;
        for(int k=lo; k<=hi; k++){
            if(i>mid){
                arr[k] = aux[j++];
            }
            else if(j>hi){
                arr[k] = aux[i++];
            }
            else if(aux[i]<aux[j]){
                arr[k] = aux[i++];
            }
            else{
                arr[k] = aux[j++];
            }
        }
    }

}
